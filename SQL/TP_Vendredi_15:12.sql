-- 1. Créez une base de données appelée "tabletoptreasures_database".
CREATE DATABASE tabletoptreasures_database;
USE tabletoptreasures_database;

-- 2 Création des tables 

CREATE TABLE IF NOT EXISTS clients (
client_id INT AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(50) NOT NULL,
prenom VARCHAR(50) NOT NULL,
adresse_mail VARCHAR(50) NOT NULL,
adresse_de_livraison VARCHAR(50),
telephone VARCHAR(11)
);
CREATE TABLE IF NOT EXISTS jeux (
jeu_id INT AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(50) NOT NULL,
description VARCHAR(200),
prix INT NOT NULL,
id_categorie INT,
CONSTRAINT fk_id_categorie FOREIGN KEY (id_categorie) REFERENCES categories(categorie_id)
);

CREATE TABLE IF NOT EXISTS categories (
categorie_id INT AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS commandes (
commande_id INT AUTO_INCREMENT PRIMARY KEY,
id_client INT NOT NULL,
date_de_commande DATE NOT NULL,
adresse_de_livraison VARCHAR(50) NOT NULL,
statut VARCHAR(50),
CONSTRAINT fk_id_client FOREIGN KEY (id_client) REFERENCES clients(client_id)
);

-- 2 Opérations en DML
--  Insérez les enregistrements du fichier annexe dans les tables "Jeux", "Categories" et "Clients".

INSERT INTO categories (nom)
VALUES 
('Stratégie'),
('Familial'),
('Aventure');

INSERT INTO jeux (nom,description, prix,id_categorie)
VALUES 
('Catan', 'Jeu de stratégie et de développement de colonies', 30, 1),
('Dixit', 'Jeu d''association d''images', 25, 2),
('Les Aventuriers', 'Jeu de plateau d''aventure', 40, 3),
('Carcassonne', 'Jeu de placement de tuiles', 28, 1),
('Codenames', 'Jeu de mots et d''indices', 20, 2),
('Pandemic', 'Jeu de coopération pour sauver le monde', 35, 3),
('7 Wonders', 'Jeu de cartes et de civilisations', 29, 1),
('Splendor', 'Jeu de développement économique', 27, 2),
('Horreur à Arkham', 'Jeu d''enquête et d''horreur', 45, 3),
('Risk', 'Jeu de conquête mondiale', 22, 1),
('Citadelles', 'Jeu de rôles et de bluff', 23, 2),
('Terraforming Mars', 'Jeu de stratégie de colonisation de Mars', 55, 3),
('Small World', 'Jeu de civilisations fantastiques', 32, 1),
('7 Wonders Duel', 'Jeu de cartes pour 2 joueurs', 26, 2),
('Horreur à l''Outreterre', 'Jeu d''aventure horrifique', 38, 3);

INSERT INTO clients (nom,prenom, adresse_mail,adresse_de_livraison, telephone)
VALUES 
('Dubois', 'Marie', 'marie.dubois@example.com', '123 Rue de la Libération, Ville', '+1234567890'),
('Lefebvre', 'Thomas', 'thomas.lefebvre@example.com', '456 Avenue des Roses, Ville', '+9876543210'),
('Martinez', 'Léa', 'lea.martinez@example.com', '789 Boulevard de la Paix, Ville', '+2345678901'),
('Dupuis', 'Antoine', 'antoine.dupuis@example.com', '567 Avenue de la Liberté, Ville', '+3456789012'),
('Morin', 'Camille', 'camille.morin@example.com', '890 Rue de l''Avenir, Ville', '+4567890123'),
('Girard', 'Lucas', 'lucas.girard@example.com', '234 Avenue des Champs, Ville', '+5678901234'),
('Petit', 'Emma', 'emma.petit@example.com', '123 Rue des Étoiles, Ville', '+6789012345'),
('Sanchez', 'Gabriel', 'gabriel.sanchez@example.com', '345 Boulevard du Bonheur, Ville', '+7890123456'),
('Rossi', 'Clara', 'clara.rossi@example.com', '678 Avenue de la Joie, Ville', '+8901234567'),
('Lemoine', 'Hugo', 'hugo.lemoine@example.com', '456 Rue de la Nature, Ville', '+9012345678'),
('Moreau', 'Eva', 'eva.moreau@example.com', '789 Avenue de la Créativité, Ville', '+1234567890'),
('Fournier', 'Noah', 'noah.fournier@example.com', '234 Rue de la Découverte, Ville', '+2345678901'),
('Leroy', 'Léa', 'lea.leroy@example.com', '567 Avenue de l''Imagination, Ville', '+3456789012'),
('Robin', 'Lucas', 'lucas.robin@example.com', '890 Rue de la Création, Ville', '+4567890123'),
('Marchand', 'Anna', 'anna.marchand@example.com', '123 Boulevard de l''Innovation, Ville', '+5678901234');

SELECT * FROM categories;
SELECT * FROM jeux;
SELECT * FROM clients;
SELECT * FROM commandes;

DROP TABLE clients;
DROP TABLE commandes;

-- 2 3 COMMANDES
INSERT INTO commandes (id_client,date_de_commande, adresse_de_livraison,statut)
VALUES 
(1,"2023-12-03","10 rue de la paix, Lille","Livré"),
(5,"2023-08-03","70 rue de la gare, Paris","En transit"),
(8,"2023-05-01","5 rue de la mare, Lille","Livré");

-- Mettez à jour le prix du jeu avec l'ID 3 (Les Aventuriers) pour le fixer à 35 €.
UPDATE jeux 
SET prix = 35
WHERE jeu_id = 3;

-- Supprimez le jeu avec l'ID 2 (Dixit) de la table "Jeux".
DELETE FROM jeux WHERE jeu_id = 2;

-- Etape 3 
-- Table categories

-- 1. Sélectionnez tous les noms de catégories distinctes.
SELECT DISTINCT nom FROM categories;

-- 2. Montrez les catégories avec des noms commençant par "A" ou "S".
SELECT * FROM categories WHERE nom LIKE "A%" OR nom LIKE "S%";

-- 3. Quelles catégories ont un ID entre 2 et 5 inclus ?
SELECT * FROM categories WHERE categorie_id BETWEEN 2 AND 5;

-- 4. Combien de catégories différentes existent ?
SELECT DISTINCT COUNT(*) AS nombre_categories_differentes FROM categories;

-- 5. Quelle est la catégorie ayant le nom le plus long ?
SELECT * FROM categories ORDER BY LENGTH(nom) DESC LIMIT 1;

-- 6. Montrez le nombre de jeux dans chaque catégorie.
SELECT categories.nom,COUNT(jeux.jeu_id) AS nombre_jeux_categories
FROM jeux 
JOIN categories ON id_categorie = categorie_id GROUP BY categories.nom;

-- 7. Affichez les catégories triées par ordre alphabétique inversé.
SELECT * FROM categories ORDER BY nom DESC;

-- Table jeux
-- 1. Sélectionnez tous les noms de jeux distincts.

SELECT  DISTINCT nom FROM jeux;

-- 2. Montrez les jeux avec un prix entre 25 et 40.
SELECT * FROM jeux WHERE prix BETWEEN 25 AND 41;

-- 3. Quels jeux appartiennent à la catégorie avec l'ID 3 ?
SELECT * FROM jeux WHERE id_categorie = 3;

-- 4. Combien de jeux ont une description contenant le mot "aventure" ?
SELECT COUNT(*) AS description_mot_aventure FROM jeux WHERE description LIKE "%aventure%";

-- 5. Quel est le jeu le moins cher ?
SELECT * FROM jeux WHERE prix = (SELECT MIN(prix) FROM jeux);

-- 6. Montrez la somme totale des prix de tous les jeux.
SELECT SUM(prix) AS prix_total_jeux FROM jeux;

-- 7. Affichez les jeux triés par ordre alphabétique des noms en limitant les résultats à 5.
SELECT * FROM jeux ORDER BY
  CASE
    WHEN nom LIKE '7 Wonders%' THEN 2
    ELSE 1
  END,
  nom
LIMIT 5;

-- Table Clients
-- 1. Sélectionnez tous les prénoms des clients distincts.
SELECT DISTINCT prenom FROM clients;

-- 2. Montrez les clients dont l'adresse contient "Rue" et dont le numéro de téléphone commence par "+1".
SELECT * FROM clients WHERE adresse_de_livraison LIKE "%rue%" AND telephone LIKE "+1%";

-- 3. Quels clients ont un nom commençant par "M" ou "R" ?
SELECT * FROM clients WHERE nom LIKE "m%" OR nom LIKE "r%";

-- 4. Combien de clients ont une adresse e-mail valide (contenant "@") ?
SELECT COUNT(*) AS client_avec_adressemail_valide FROM clients WHERE adresse_mail LIKE "%@%";

-- 5. Quel est le prénom le plus court parmi les clients ?
SELECT * FROM clients WHERE LENGTH(prenom) = (SELECT MIN(LENGTH(prenom)) FROM clients);

-- 6. Montrez le nombre total de clients enregistrés.
SELECT COUNT(*) AS nombre_clients_enregistrés FROM clients;

-- 7. Affichez les clients triés par ordre alphabétique des noms de famille, mais en excluant les premiers 3.
SELECT * FROM clients ORDER BY nom LIMIT 18446744073709551615 OFFSET 3;

-- Étape 4 : Requêtes SQL avancées
-- Modification table Commandes ajoutant foreign key jeux 
ALTER TABLE commandes
	ADD COLUMN id_jeu INT;
    
 ALTER TABLE commandes   
    ADD CONSTRAINT fk_id_jeu FOREIGN KEY(id_jeu) REFERENCES jeux(jeu_id);
    
 SELECT * FROM commandes;   
  SELECT * FROM jeux;
 
 UPDATE commandes 
 SET id_jeu = 1
 WHERE commande_id = 1;
  UPDATE commandes 
 SET id_jeu = 5
 WHERE commande_id = 2;
  UPDATE commandes 
 SET id_jeu = 8
 WHERE commande_id = 3;

--  1. Sélectionnez les noms des clients, noms de jeux et date de commande pour chaque commande passée.
SELECT (SELECT nom FROM clients WHERE id_client = client_id) AS nom_clients, 
(SELECT nom FROM jeux WHERE id_jeu = jeu_id) AS nom_jeu , date_de_commande FROM commandes;

-- 2. Sélectionnez les noms des clients et le montant total dépensé par chaque client. Triez les résultats par montant total décroissant.
-- Ajout de commandes 

INSERT INTO commandes (id_client,date_de_commande, adresse_de_livraison,statut, id_jeu)
VALUES 
(1,"2023-12-04","10 rue de la paix, Lille","Livré", 7),
(5,"2023-08-07","70 rue de la gare, Paris","En transit",10),
(8,"2023-05-09","5 rue de la mare, Lille","Livré",5),
(10,"2023-05-12","12 rue de la ville, Lille","En transit",5),
(10,"2023-05-23","12 rue de la ville, Lille","Livré",6),
(13,"2023-05-16","59 rue de la patrie, Lille","Livré",5);


SELECT (SELECT nom FROM clients WHERE id_client = client_id) AS nom_clients, SUM(prix)
FROM commandes 
JOIN jeux ON id_jeu = jeu_id GROUP BY nom_clients;

-- 3. Sélectionnez les noms des jeux, noms de catégories et prix de de chaque jeux
SELECT (SELECT nom FROM categories where categorie_id = id_categorie) AS categories_jeux, nom, prix
FROM jeux ;

-- 4. Sélectionnez les noms des clients, date de commande et noms de jeux pour toutes les commandes passées.
SELECT (SELECT nom FROM clients WHERE id_client = client_id) AS nom_clients, date_de_commande,
(SELECT nom FROM jeux WHERE id_jeu = jeu_id) AS nom_jeux FROM commandes WHERE statut = "livré";

-- 5. Sélectionnez les noms des clients, nombre total de commandes par client et montant total dépensé par client. Incluez uniquement les clients ayant effectué au moins une commande.
SELECT (SELECT nom FROM clients WHERE id_client = client_id) AS nom_clients, COUNT(id_client) AS nombre_commandes_client,
SUM(prix) AS montant_depense
FROM commandes 
JOIN jeux ON id_jeu = jeu_id GROUP BY nom_clients HAVING  COUNT(id_client)>= 1;