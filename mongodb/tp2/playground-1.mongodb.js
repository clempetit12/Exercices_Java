use("user");


// Afficher ChuckNorris

db.users.find({ "name": "Chuck Norris"  });

//db.users.find({ "name": "Chuck Norris" }, { "_id": 0 });

//Afficher users age entre 20 & 25 ans
//db.users.find({$and: [{age : {$gt: 20}}, {age : {$lt:25}}]})

//Afficher les hommes entre 30 & 40 ans 
//db.users.find({"gender" : "male",$and: [{age : {$gt: 20}}, {age : {$lt:25}}]})


// Afficher utilisateurs habitants état de Louisianne
//db.users.find({"address.state" : "Louisiana"})

//Afficher les 20 premiers utilisateurs triés par ordre décroissant age
//db.users.find().sort({age:-1}).limit(20)


// -- avec 2 auteurs, tri par titre et puis _id
// db.books.find({authors: {$size: 2}}).sort({title:1, _id:-1});

// Combien y a-t-il de femmes âgées de 30 ans
//db.users.find({"gender" : "female",$and: [{age : 30}]}).count()

//Supprimer champ phone de tous les utilisateurs 
//db.users.updateMany({}, { $unset: { "phone": 1 } });

//Changer age de chuck norris à infinity
//db.users.updateOne({"name" : "Chuck Norris"}, {$set : {age: "infinity"}})

//Ajouter un hobby à tous nos utilisateurs de plus de 50 ans 
