//1
use("bibliotheque")

// db.articles.find({auteurId : "auteur1" });

// db.auteurs.find({nom : "Alice Dupont"})

// db.articles.find({titre : "La Science des Données"});

// db.articles.aggregate([
//   {
//     $group: {
//       _id: "$auteurId",
//       titre: { $push: "$titre" },
//       contenu: { $push: "$contenu" }
//     }
//   },
//   {
//     $project: {
//       _id: 1,
//       titre: 1,
//       contenu: 1
//     }
//   }
// ])

// db.auteurs.aggregate([
//     {
//       $match: {
//         "email": "alice@example.com"
//       }
//     },
//     {
//       $lookup: {
//         from: "articles", 
//         localField: "_id",
//         foreignField: "auteurId",
//         as: "articles"
//       }
//     },
//     {
//       $project: {
//         _id: 0,
//         "articles.titre": 1,
//         "articles.contenu": 1
//       }
//     }
//   ])
  

// db.auteurs.aggregate([
//     {
//       $match: {
//         email: { $regex: "example\\.com$", $options: "i" }}
       
      
//     },
//     {
//       $lookup: {
//         from: "articles", 
//         localField: "_id",
//         foreignField: "auteurId",
//         as: "articles"
//       }
//     },
//     {
//       $project: {
//         _id: 0,
//         nom: 1,
//         email: 1
//       }
//     }
//   ])


//  db.auteurs.updateOne({
//     nom: "Alice Dupont"},
//     {$set: {email: "dupont@example.com"}});



db.auteurs.deleteMany([
    {
      $match: {
        "email": "alice@example.com"
      }
    },
    {
      $lookup: {
        from: "articles", 
        localField: "_id",
        foreignField: "auteurId",
        as: "articles"
      }
    },
    {
      $project: {
        _id: 0,
        "articles.titre": 1,
        "articles.contenu": 1
      }
    }
  ])




  