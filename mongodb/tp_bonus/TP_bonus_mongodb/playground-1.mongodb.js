// Quels sont les sportifs (identifiant, nom et prénom) qui ont un âge entre 20 et 30 ans ?

use("Bonus");

//db.sportifs.find({ Age: { $gt: 20, $lt: 31 } }, { _id: 1, Nom: 1, Prenom: 1 })

// Quels sont les gymnases de ville “Villetaneuse” ou de “Sarcelles” qui ont une surface de plus de 400 m2 

// db.gymnase.find(
//     { Ville: { $regex: /^(Villetaneuse|Sarcelles)$/i }, Surface: { $gte: 400 } },
//     { _idGymnase: 1, Ville: 1, Surface: 1 }
//   )

// Quels sont les sportifs (identifiant et nom) qui pratiquent du handball 

// db.sportifs.aggregate([
//     {
//       $match: {
//         "Sports.Jouer": "Hand ball"
//       }
//     },
//     {
//       $project: {
//         _id: 1,
//         Nom: 1
//       }
//     }
//   ])

  // Quels sportifs (identifiant et nom) ne pratiquent aucun sport ?

//   db.sportifs.aggregate([
//     {
//         $match: {
            
//             "Sports.Jouer" : {$exists : false}
           
//         }
//     },
//     {
//         $project : {
//             _id : 1,
//             Nom : 1
//         }
//     }
//   ])
  
// Quels gymnases n’ont pas de séances le dimanche ?
// db.gymnase.find({"Seances.Jour": {$not: {$regex: /^dimanche$/i}}})


// Quels gymnases ne proposent que des séances de basketball ou de volley ball ?
// db.gymnase.aggregate([
//     {
//       $match: {
//         "Seances.Libelle": {
//           $all: ["Volley ball","Basket ball"]
//         }
//       }
//     },
//     {
//       $project: {
//         _id: 1,
//         NomGymnase: 1,
//         "Seances.Libelle": 1
//       }
//     }
//   ])
  

// db.gymnase.find({
//     "$nor": [
//       {"Seances.Libelle": {"$ne": "Basket ball"}},
//       {"Seances.Libelle": {"$ne": "Volley ball"}}
//     ]
//   },
//   {
//     "_id": 0,
//     "NomGymnase": 1,
//     "Ville": 1,
//     "Seances.Libelle": 1
//   })
  


  // Quels sont les entraîneurs qui sont aussi joueurs 


//     db.sportifs.aggregate([
//     {
//         $match: {
//             $and:[     {"Sports.Jouer" : {$exists : true},"Sports.Entrainer" : {$exists : true}}],
           
           
   
           
//         }
//     },
//     {
//         $project : {
//             _id : 1,
//             Nom : 1,
//             "Sports.Jouer" : 1,
//             "Sports.Entrainer" : 1
//         }
//     }
//   ])


// Pour le sportif “Kervadec” quel est le nom de son conseiller ?

//db.sportifs.find({Nom : "KERVADEC"})

// db.sportifs.aggregate([
//     {
//       $match: {
//        Nom : "KERVADEC"
//       }
//     },
//     {
//       $lookup: {
//         from: "sportifs",
//         localField: "IdSportifConseiller",
//         foreignField: "IdSportif",
//         as: "conseiller"
//       }
//     },
//     {
//       $project: {
//         _id: 0,
//         Nom : 1,
//         NomConseiller: "$conseiller.Nom",
//         PrenomConseiller: "$conseiller.Prenom"
//       }
//     }
//   ])
  

  // Quelle est la moyenne d’âge des sportives qui pratiquent du basket ball ?
  
//   db.sportifs.aggregate([
//     {
//       $match: {
//         "Sports.Jouer": "Basket ball",
//         Sexe: "F"
//       }
//     },
//     {
//       $group: {
//         _id: 1,
//         note_moyenne: { $avg: "$Age" }
//       }
//     }
//   ])
  

//   Quels entraîneurs n’entraînent que du hand ball ou du basketball ?
db.sportifs.aggregate([
    {
      $match: {
        $or : [
          {
            "Sports.Entrainer":{$eq :"Basket ball" }  ,
                 $and: [
                  {
                    "Sports.Entrainer": {
                      $in: [/^basket ball$/i, /^hand ball$/i]
                    }
                  },
                  {
                    "Sports.Entrainer": {
                      $size: 2
                    }
                  }
                ]
              
          }
        ]
      
          
        
          
          
          
           
                 
        
            
           
            
          
          }
      
    }
  ])
  
  
  // Pour chaque sportif donner le nombre de sports qu’il arbitre?

 
  
  // db.sportifs.aggregate([
  //   {
  //     $unwind: "$Sports.Arbitrer"
  //   },
  //   {
  //     $group: {
  //       _id: {
  //         IdSportif: "$IdSportif",
  //         Nom: "$Nom",
  //         Prenom: "$Prenom"
  //       },
  //       nombre_sports_arbitrer: { $sum: 1 }
  //     }
  //   },
  //   {
  //     $project: {
  //       _id: 0,
  //       IdSportif: "$_id.IdSportif",
  //       Nom: "$_id.Nom",
  //       Prenom: "$_id.Prenom",
  //       nombre_sports_arbitrer: 1
  //     }
  //   }
  // ]);
