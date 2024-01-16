use("info");

//db.infos.find({"type" : "Book"})

// Liste des publications depuis 2011
//db.infos.find({year : {$gt : 2010}})

// Liste des livres depuis 2011
//db.infos.find({$and : [year : {$gt : 2010},{"type" : "Book"}])

//db.infos.find({authors : "Toru Ishida"})

//db.infos.distinct("publisher")

//  Liste de tous les auteurs distincts 
db.infos.distinct("authors")

