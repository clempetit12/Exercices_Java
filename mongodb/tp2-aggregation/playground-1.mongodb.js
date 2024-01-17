use("restaurant")

// 1. Afficher la liste des restaurants mais limitez l’affichage à 10.
/* db.restaurants.aggregate([

    {
        $limit: 10
    }
]) */


//2. Afficher la liste des 10 premiers restaurants mais en triant cette liste par ordre
//alphabétique.
/* db.restaurants.aggregate([
  
    {
        $match: {
            name: { $exists: true, $ne: "" }
        }
    },
    {
        $sort: {
            name: 1
        }
    },
    {
        $limit: 10
    }
]) */



//3. Afficher la liste des 10 premiers restaurants mais en triant cette liste par ordre
//alphabétique, mais uniquement ceux sur “Brooklyn” (champs : borough)..
/* db.restaurants.aggregate([
    {
        $match: {
            borough: "Brooklyn"
        }
    },
    {
        $sort: {
            name: 1
        }
    },
    {
        $limit: 10
    }
]) */



//4. Afficher la liste des 10 premiers restaurants mais on affiche que le nom du restaurant
//et son quartier.

/* db.restaurants.aggregate([
    {
         $project: {
            name: 1,
            borough: 1
        }
    },
    {
      $limit: 10
    }
]) */

//5. Afficher la liste des 10 premiers restaurants mais on affiche tout sauf adresse et le
//grade.

/* db.restaurants.aggregate([
    {
         $project: {
            address: 0,
            "address line 2": 0,
            grades: 0
        }
    },
    {
      $limit: 10
    }
    
]) */

//6. Afficher la liste des 10 premiers restaurants avec un nouveau champ qui va afficher
//le nombre d’avis (grades) par restaurant.

/* db.restaurants.aggregate([
    {
        $unwind: "$grades"
    },
    {
        $group: {
            _id: "$_id",
            name: { $first: "$name" },
            grades_count: { $sum: 1 }
        }
    },

    {
        $limit: 10
    }
]) */

//7. Afficher la liste des 10 premiers restaurants avec un nouveau champ qui va afficher
//le nombre d’avis (grades) par restaurant et il faudra faire le tri par nombre d’avis.

/* db.restaurants.aggregate([
    {
        $unwind: "$grades"
    },
    {
        $group: {
            _id: "$_id",
            name: { $first: "$name" },
            grades_count: { $sum: 1 }
        }
    },

    {
        $limit: 10
    },
    {
        $sort : {grades_count : 1}
    }
]) */

//8. On souhaite toujours afficher la liste des 10 premiers restaurants en affichant le nom
//du restaurant en majuscule et le quartier du restaurant.
/* db.restaurants.aggregate([
    {
        $project: {
            name: { $toUpper: "$name" },
            borough: 1,
        }
    },
    {
        $limit: 10
    }
]) */

//9. On souhaite toujours afficher la liste des 10 premiers restaurants en affichant le nom
//du restaurant en majuscule et les 3 premières lettres du quartier.

/* db.restaurants.aggregate([
    {
        $project: {
            name: { $toUpper: "$name" },
            borough_first_three_l: { $substr: ["$borough", 0, 3] }
           
        }
    },
    {
        $limit: 10
    }
]) */

//10. On souhaite avoir le nombre total de restaurants toujours avec agrégation.

/* db.restaurants.aggregate(
    {
        $count: "nombre_restaurants"
    }
) */

//11. On souhaite avoir le nombre de restaurants par quartier (borough).

/* db.restaurants.aggregate(
    {
        $group : { _id: "$borough",nombre_restau_quartier : {$sum:1}}
    }
    
) */






