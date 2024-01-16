use("info");
// db.produits.insert(
    
//         {
//                     "nom":"Macbook Pro",
//                 "fabriquant":"Apple",
//                 "prix" : 11435.99,
//                 "options"  : ["Intel Core i5"
//             , "Retina Display",
//         "Long Life battery"],
            
            
            
//             }
    
// )

// db.produits.insert(
    
//             {
//                         "nom":"Macbook Air",
//                     "fabriquant":"Apple",
//                     "prix" : 125794.73,
//                     "ultabook" : true,
//                     "options"  : ["Intel Core i7"
//                 , "SSD",
//             "Long Life battery"],
                
                
                
//                 }
        
//     )

//     db.produits.insert(
    
//         {
//                     "nom":"Thinkpad X230",
//                 "fabriquant":"Lenovo",
//                 "prix" : 114358.74,
//                 "ultabook" : true,
//                 "options"  : ["Intel Core i5"
//             , "SSD",
//         "Long Life battery"],
            
            
            
//             }
    
// )

// Récupérez tout les produits 

//db.produits.find();

//Récupere le premier produit 
//db.produits.find().limit(1);

//Trouver id du ThinkPad 
//db.produits.find({ "nom": /Thinkpad/ }, { "_id": 1 })

//db.produits.find({_id : ObjectId("65a69e428c239be8cb1f29bd")})

// Recuperer prix > 13723

//db.produits.find({prix : {$gt:13723}})

// Récupérer le premier produit ayant le champ ultrabook à true
//db.produits.find({ultabook : true}).limit(1)

// Récupérer le premier produit dont le nom contient Macbook
//db.produits.find({nom : /Macbook/}).limit(1)

//Récupére les produits dont le nom commence par MacBook
db.produits.find({ "nom": { $regex: /^Macbook/ } })



// Récupérer les deux produits dont le fabricant est Apple
//db.produits.deleteMany({"fabriquant" : "Apple"})

