use("book")
// 1.	Trier les publications de « Toru Ishida » par titre de livre et par page de début.
/*  db.books.aggregate([
    { $match: { authors: "Toru Ishida" } },
    { $sort: { "title": 1, "pages.start": 1 } }
  ]); 

//2.	Projeter le résultat sur le titre de la publication, et les pages.
db.books.aggregate([
    {  $match: { authors: "Toru Ishida" }},
    {$project: {
        _id: 0,  
        title: 1,
        "pages": 1
    }},
    { $sort: { "title": 1, "pages.start": 1 } },
 
  ]);  */



  /*   // 3.	Compter le nombre de ses publications.
    db.books.aggregate([
        {
          $match: {
            authors: "Toru Ishida"
          }
        },
        {
          $count: "nombre_publications"
        }
      ]) */
      
/* 
    // 4.	Compter le nombre de publications depuis 2011 et par type.
    db.books.aggregate({$match : {year : {$gt : 2010}}
    },{$group: {_id : "$type", count : { $sum : 1}}},)
 */
    // 5.	Compter le nombre de publications par auteur et trier le résultat par ordre croissant.
    db.books.aggregate([
        {
            $unwind: "$authors"
        },
        {
            $group: {
                _id: "$authors",
                count: { $sum: 1 }
            }
        },
        {
            $sort: {
                count: -1
            }
        }
    ])
    
    
    
    