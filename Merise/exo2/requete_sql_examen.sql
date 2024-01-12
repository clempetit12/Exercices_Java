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
theme_examen VARCHAR(200),
date_examen DATE
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
id_ex INT,
CONSTRAINT fk_etablissement_eleves_id FOREIGN KEY (id_e) REFERENCES etablissement(id_e),
CONSTRAINT fk_examen_eleves_id FOREIGN KEY (id_ex) REFERENCES examens(id_ex)
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
 ("lea,","2001-01-01",2,2),
 ("eloise,","2001-01-01",3,1);
 INSERT INTO  eleves (nom_eleve,date_naissance_eleve,id_e) 
VALUES
 ("thomas","2001-01-01",3),
 ("jean","2001-01-01",1);

 
 INSERT INTO  examens (theme_examen,date_examen) 
VALUES
 ("baccalaureat","2023-06-12"),
 ("brevet","2023-05-12");
 
  INSERT INTO  dossier_inscription (id_el) 
VALUES
 (1),
 (2),
 (3),
 (4),
 (4);
   INSERT INTO  examen_eleve (id_el,id_ex) 
VALUES
 (1,1),
 (2,1),
 (3,2);
 
INSERT INTO  epreuves (coefficient_epreuve,id_ex,nom_epreuve,date) 
VALUES
 (2,1, "sciences","2023-06-12"),
 (1,1, "plastique", "2023-06-15"),
 (2,2, "histoire", "2023-07-18"),
 (2,1, "français", "2023-05-11");
 
INSERT INTO  resultat (id_el,id_ep,note) 
VALUES
 (1,1,5),
 (1,2,14),
 (1,4,16),
  (2,1,9),
 (2,2,11),
 (2,4,18),
 (3,3,15);
 
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
 (1,1),
 (2,1);
 
   INSERT INTO  rediger (id_en,id_ex) 
VALUES
 (1,1),
 (2,2);

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

SELECT AVG(moyenne_individuelle) AS moyenne_globale
FROM (
    SELECT id_el, 
           SUM(note * coefficient_epreuve) / SUM(coefficient_epreuve) AS moyenne_individuelle
    FROM resultat r
    INNER JOIN epreuves e ON r.id_ep = e.id_ep
    INNER JOIN examens ex ON e.id_ex = ex.id_ex
    WHERE ex.theme_examen = 'baccalaureat'
    GROUP BY id_el
) AS moyennes_individuelles;

 
SELECT * FROM enseignants WHERE id_e IN (select id_e from etablissement where ville_etablissement = "paris");
SELECT id_e, COUNT(id_el) AS nombre_eleves FROM eleves GROUP BY id_e;
select nom_eleve from eleves where id_el in (select id_el from resultat where note > 10) ;

 SELECT r.id_el, el.nom_eleve,
           note 
    FROM resultat r
    INNER JOIN eleves el ON el.id_el = r.id_el
    WHERE note > 10 group by r.id_el,note;
    
SELECT ex.id_ex,e.nom_epreuve,e.coefficient_epreuve
FROM examens ex
JOIN epreuves e ON e.id_ex = ex.id_ex;

select e.nom_etablissement, COUNT(el.id_ex) as nombre_examens
from etablissement e
join eleves el on e.id_e = el.id_e group by e.nom_etablissement ;

select * from eleves where id_ex IS NULL ;

SELECT en.nom_enseignant
from enseignants en
join rediger r on en.id_en = r.id_en
WHERE (r.id_en, r.id_ex) IN (
    SELECT c.id_en, c.id_ex
    FROM corriger c
    WHERE r.id_en = c.id_en AND r.id_ex = c.id_ex
) group by en.nom_enseignant;

select el.nom_eleve, MAX(ep.date), r.note from
eleves el 
join resultat r on r.id_el = el.id_el
join epreuves ep on el.id_ex = ep.id_ex group by el.nom_eleve,r.note;

alter table epreuves add column date DATE;

drop table examen_dossier;
drop table examen_enseignant;
drop table examen_eleve;
drop database examens;
