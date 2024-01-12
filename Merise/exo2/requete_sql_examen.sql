CREATE DATABASE examens ;
USE examens;

CREATE TABLE IF NOT EXISTS etablissement (
id_e INT AUTO_INCREMENT PRIMARY KEY,
nom_etablissement VARCHAR(200),
adresse_etablissement VARCHAR(200),
ville_etablissement VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS examens (
id_ex INT AUTO_INCREMENT PRIMARY KEY,
theme_examen VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS epreuves (
id_ep INT AUTO_INCREMENT PRIMARY KEY,
coefficient_epreuve INT
);


CREATE TABLE IF NOT EXISTS enseignants (
id_en INT AUTO_INCREMENT PRIMARY KEY,
nom_enseignant VARCHAR(200),
tel_enseignant VARCHAR(200),
adresse_enseignant VARCHAR(50),
ville_enseignant VARCHAR(50),
CONSTRAINT fk_etablissement_id FOREIGN KEY (id_e) REFERENCES etablissement(id_e)

);

CREATE TABLE IF NOT EXISTS eleves (
id_el INT AUTO_INCREMENT PRIMARY KEY,
nom_eleve VARCHAR(200),
date_naissance_eleve DATE,
CONSTRAINT fk_etablissement_id FOREIGN KEY (id_e) REFERENCES etablissement(id_e)
);

CREATE TABLE IF NOT EXISTS dossier_inscription (
id_d INT AUTO_INCREMENT PRIMARY KEY,
CONSTRAINT fk_eleve_id FOREIGN KEY (id_el) REFERENCES eleves(id_el)
);

CREATE TABLE IF NOT EXISTS examen_eleve (
    id_ex_el INT AUTO_INCREMENT PRIMARY KEY,
    id_el INT,
    id_ex INT,
    CONSTRAINT fk_eleve_id FOREIGN KEY (id_el) REFERENCES eleves(id_el),
    CONSTRAINT fk_examen_id FOREIGN KEY (id_ex) REFERENCES examens(id_ex)
);




SELECT * FROM customers;
SELECT * FROM accounts;
SELECT * FROM operations;

DROP TABLE operations;
DROP TABLE accounts;

