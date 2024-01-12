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
coefficient_epreuve INT,
id_ex INT,
CONSTRAINT fk_examen_id FOREIGN KEY (id_ex) REFERENCES examens(id_ex)

);


CREATE TABLE IF NOT EXISTS enseignants (
id_en INT AUTO_INCREMENT PRIMARY KEY,
nom_enseignant VARCHAR(200),
tel_enseignant VARCHAR(200),
adresse_enseignant VARCHAR(50),
ville_enseignant VARCHAR(50),
 id_e INT,
CONSTRAINT fk_etablissement_id FOREIGN KEY (id_e) REFERENCES etablissement(id_e)

);

CREATE TABLE IF NOT EXISTS eleves (
id_el INT AUTO_INCREMENT PRIMARY KEY,
nom_eleve VARCHAR(200),
date_naissance_eleve DATE,
id_e INT,
CONSTRAINT fk_etablissement_eleves_id FOREIGN KEY (id_e) REFERENCES etablissement(id_e)
);

CREATE TABLE IF NOT EXISTS dossier_inscription (
id_d INT AUTO_INCREMENT PRIMARY KEY,
id_el INT,
CONSTRAINT fk_eleve_id FOREIGN KEY (id_el) REFERENCES eleves(id_el)
);

CREATE TABLE IF NOT EXISTS examen_eleve (
    id_el INT,
    id_ex INT,
    CONSTRAINT fk_eleves_id FOREIGN KEY (id_el) REFERENCES eleves(id_el),
    CONSTRAINT fk_examens_id FOREIGN KEY (id_ex) REFERENCES examens(id_ex),
    PRIMARY KEY (id_el, id_ex)
);

CREATE TABLE IF NOT EXISTS examen_dossier (
    id_d INT,
    id_ex INT,
    CONSTRAINT fk_dossier_id FOREIGN KEY (id_d) REFERENCES dossier_inscription(id_d),
    CONSTRAINT fk_examens_dossier_id FOREIGN KEY (id_ex) REFERENCES examens(id_ex),
    PRIMARY KEY (id_d, id_ex)
);


CREATE TABLE IF NOT EXISTS rediger (
    id_en INT,
    id_ex INT,
    CONSTRAINT fk_rediger_id FOREIGN KEY (id_en) REFERENCES enseignants(id_en),
    CONSTRAINT fk_examens_rediger_id FOREIGN KEY (id_ex) REFERENCES examens(id_ex),
    PRIMARY KEY (id_en, id_ex)
);

CREATE TABLE IF NOT EXISTS corriger (
    id_en INT,
    id_ex INT,
    CONSTRAINT fk_corriger_id FOREIGN KEY (id_en) REFERENCES enseignants(id_en),
    CONSTRAINT fk_examens_corriger_id FOREIGN KEY (id_ex) REFERENCES examens(id_ex),
    PRIMARY KEY (id_en, id_ex)
);

CREATE TABLE IF NOT EXISTS resultat (
    id_el INT,
    id_ep INT,
    note INT,
    CONSTRAINT fk_eleves_resultat_id FOREIGN KEY (id_el) REFERENCES eleves(id_el),
    CONSTRAINT fk_epreuves_resultat_id FOREIGN KEY (id_ep) REFERENCES epreuves(id_ep),
    PRIMARY KEY (id_el, id_ep)
);

INSERT INTO  eleves (nom_eleve,date_naissance_eleve,id_e,id_ex) 
VALUES
 ("thomas","2001-01-01",3,1),
 ("jean","2001-01-01",1,1),
 ("lea,","2001-01-01",2,2);
 
 INSERT INTO  examens (theme_examen) 
VALUES
 ("baccalaureat"),
 ("brevet");
 
  INSERT INTO  dossier_inscription (id_el) 
VALUES
 (1),
 (2),
 (3);
   INSERT INTO  examen_eleve (id_el,id_ex) 
VALUES
 (1,1),
 (2,1),
 (3,2);
 
INSERT INTO  epreuves (coefficient_epreuve,id_ex,nom_epreuve) 
VALUES
 (2,1, "math"),
 (1,1, "art"),
 (2,2, "histoire"),
 (2,1, "français");
 
INSERT INTO  resultat (id_el,id_ep,note) 
VALUES
 (1,1,5),
 (2,1,15);
 
 INSERT INTO  etablissement (nom_etablissement,adresse_etablissement,ville_etablissement) 
VALUES
 ("saintjean","12 rue zola","paris"),
 ("zola","12 rue zola","lille"),
 ("jules","12 rue zola","lyon");
 
INSERT INTO  enseignants (nom_enseignant,tel_enseignant,adresse_enseignant,ville_enseignant,id_e) 
VALUES
 ("eloise","087666","12 rue zola","paris",1),
 ("louis","087666","12 rue zola","lille",2),
 ("theo","087666","12 rue zola","paris",1);
 
  INSERT INTO  corriger (id_en,id_ex) 
VALUES
 (4,1),
 (5,1);
 
   INSERT INTO  rediger (id_en,id_ex) 
VALUES
 (4,1),
 (5,2);

ALTER TABLE epreuves
ADD COLUMN nom_epreuve VARCHAR(200); 

ALTER TABLE eleves
ADD COLUMN id_ex INT,
ADD CONSTRAINT fk_examens_id FOREIGN KEY (id_ex) REFERENCES examens(id_ex);


SELECT * FROM eleves;
SELECT * FROM examens;
SELECT * FROM dossier_inscription;
SELECT * FROM resultat;
SELECT * FROM epreuves;
SELECT * FROM enseignants;

SELECT avg(note) FROM resultat where id_ep = 1 ;
SELECT * FROM enseignants WHERE id_e IN (select id_e from etablissement where ville_etablissement = "paris");
SELECT id_e, COUNT(id_el) AS nombre_eleves FROM eleves GROUP BY id_e;
select nom_eleve from eleves where id_el in (select id_el from resultat where note > 10) ;
SELECT *
FROM epreuves e
JOIN examens ex ON e.id_ex = ex.id_ex;


select * from eleves where id_ex IS NULL ;

SELECT *
FROM rediger r
WHERE (r.id_en, r.id_ex) IN (
    SELECT c.id_en, c.id_ex
    FROM corriger c
    WHERE r.id_en = c.id_en AND r.id_ex = c.id_ex
);


drop table examen_dossier;
drop table examen_enseignant;
drop table examen_eleve;
