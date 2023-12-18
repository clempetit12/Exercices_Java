CREATE DATABASE exercice_jdbc_1;

USE exercice_jdbc_1;

CREATE TABLE IF NOT EXISTS etudiants (
id INT AUTO_INCREMENT PRIMARY KEY,
last_name VARCHAR(200),
first_name VARCHAR(200),
numero_classe INT,
date_diplome DATE
);

SELECT * FROM etudiants;