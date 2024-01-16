// TP1

// Insérer trois dossier patient avec au moins 1 historique par patient

 use("hopital");
// db.patients.insertMany([
//     {
//         "firstname":"Olivia",
//     "lastname":"Pigani",
//     "age" : "28",
//     "history"  : [
//         {"desease" : "grippe",
//     "treatment" : "sirop"},
//     {"desease" : "gastrot",
//     "treatment" : "repos"}],



// }, 
// {
//     "firstname":"Pauline",
// "lastname":"Laout",
// "age" : "31",
// "history"  : [
//     {"desease" : "appendicite",
// "treatment" : "operation"},
// {"desease" : "gastrot",
// "treatment" : "repos"}],



// }, 
// {
//     "firstname":"Olivia",
// "lastname":"Pigani",
// "age" : "30",
// "history"  : [
//     {"desease" : "grippe",
// "treatment" : "sirop"},
// {"desease" : "gastrot",
// "treatment" : "repos"}],



// }



// ]);


// Mettre à jour les données d'un patient avec un nouvel age , nouveau nom et nouvel historique medical 

// db.patients.updateOne(
//     { _id: ObjectId('65a681482d4b9fe99793e050') },
//     {
//       $set: {
//         age: 28,
//         lastname: 'pamela',
//         history: [
//           { disease: 'bronchite', treatment: 'sirop' },
//           { disease: 'flebite', treatment: 'repos' }
//         ]
//       }
//     }
//   );

  // Trouver tous les patients qui ont un age supérieur à 29

  db.patients.find({"age": {$gt: 29}});

  //Supprimer tous les patients qui ont attrapé un rhume
  db.patients.deleteMany({ "history.desease": "grippe" });


  
