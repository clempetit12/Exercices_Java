CREATE DATABASE offres;
use offres;


CREATE TABLE Appel_offre (
    id_appel_offre INT AUTO_INCREMENT PRIMARY KEY,
    date_offre DATE,
    date_cloture_offre DATE
);

CREATE TABLE Produits (
    id_produits INT AUTO_INCREMENT PRIMARY KEY,
    nom_produit VARCHAR(150)
);

CREATE TABLE Offres_fermes (
    id_of INT AUTO_INCREMENT PRIMARY KEY,
    prix_of VARCHAR(150),
    date_cloture_offre DATE,
  id_produits INT,
 FOREIGN KEY (id_produits) REFERENCES Produits(id_produits)
);

CREATE TABLE Fournisseur (
    id_fournisseur INT AUTO_INCREMENT PRIMARY KEY,
    nom_fournisseur VARCHAR(150),
    adresse_fournisseur VARCHAR(150),
    cp_fournisseur INT,
	ville_fournisseur VARCHAR(150),
     id_produits INT,
FOREIGN KEY (id_produits) REFERENCES Produits(id_produits)
);

CREATE TABLE Contrat (
    id_contrat INT AUTO_INCREMENT PRIMARY KEY,
    date_contrat DATE,
    quantité_negociee INT,
    signature BOOLEAN,
    date_signature DATE,
    id_fournisseur INT,
	FOREIGN KEY (id_fournisseur) REFERENCES Fournisseur(id_fournisseur)
);


CREATE TABLE appel_offre_produit (
    id_produits INT,
    id_appel_offre INT,
  quantite INT,
    PRIMARY KEY (id_produits, id_appel_offre),
    FOREIGN KEY (id_produits) REFERENCES Produits(id_produits),
    FOREIGN KEY (id_appel_offre) REFERENCES Appel_offre(id_appel_offre)
);




CREATE TABLE offres_fermes_fournisseur (
    id_of INT,
    id_fournisseur INT,
    PRIMARY KEY (id_of, id_fournisseur),
    FOREIGN KEY (id_of) REFERENCES Offres_fermes(id_of),
    FOREIGN KEY (id_fournisseur) REFERENCES Fournisseur(id_fournisseur)
);



-- Example 1
INSERT INTO Produits (nom_produit )
VALUES ('Produit E'),
('Produit F'),
 ('Produit G'),
 ('Produit H');

-- Example 1
INSERT INTO Appel_offre (date_offre, date_cloture_offre)
VALUES ('2024-02-01', '2024-02-15'),
 ('2024-02-10', '2024-02-25'),
 ('2024-02-15', '2024-03-01'),
 ('2024-02-20', '2024-03-10');
 
-- Assuming id_produits are 1, 2, 3, and 4 for Produit A, B, C, and D respectively
-- Example 1
INSERT INTO Offres_fermes (prix_of, date_cloture_offre, id_produits)
VALUES ('4500.00', '2024-04-15', 1),
 ('5200.00', '2024-04-25', 1),
('4800.00', '2024-03-01', 3),
('5100.00', '2024-03-10', 4);


-- Example 1
INSERT INTO Fournisseur (nom_fournisseur, adresse_fournisseur, cp_fournisseur, ville_fournisseur,id_produits)
VALUES ('Fournisseur A', 'Rue de la République', 75001, 'Paris', 1),
 ('Fournisseur B', 'Avenue des Champs-Élysées', 75008, 'Paris',1),
 ('Fournisseur C', 'Rue de la Liberté', 69001, 'Lyon',3),
 ('Fournisseur D', 'Boulevard Saint-Germain', 75006, 'Paris',4),
('Fournisseur E', 'Place de la Bourse', 75002, 'Paris',4);


-- Example 1
INSERT INTO Contrat (date_contrat, quantité_negociee, signature, date_signature, id_fournisseur)
VALUES ('2024-01-15', 100, 1, '2024-01-15', 1),
 ('2024-02-01', 150, 1, '2024-02-01', 3),
 ('2024-03-10', 200, 1, '2024-03-10', 4);

-- Inserting data into appel_offre_produit with coherence
INSERT INTO appel_offre_produit (id_produits, id_appel_offre, quantite)
VALUES (1, 1, 100),
(2, 2, 150),
 (3, 3, 250);


drop table  offres_fermes_produit;
drop table  contrat;
drop table  produits;
drop database offres;

select p.nom_produit, o.prix_of from produits p 
inner join offres_fermes o on p.id_produits = o.id_produits;

select distinct count(id_of) as nombre_offres from offres_fermes;

select nom_fournisseur from fournisseur where ville_fournisseur = "paris";

select p.nom_produit, ao.quantite as quantite_produit_appel_offre 
from appel_offre_produit ao
join produits p on ao.id_produits=p.id_produits;

SELECT p.nom_produit, p.id_produits
FROM Produits p
WHERE NOT EXISTS (
    SELECT 1
    FROM Fournisseur f
    WHERE p.id_produits = f.id_produits
);

SELECT o.id_of, p.nom_produit
FROM offres_fermes o
INNER JOIN produits p ON o.id_produits = p.id_produits;



select * from contrat;

select * from contrat;
select * from produits;
select * from offres_fermes;
