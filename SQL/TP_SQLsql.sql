
-- 1. Combien y a-t-il d'employés dans l'entreprise?
SELECT COUNT(*) AS nombre_total_employe FROM employees;

-- 2. Quel est le total des paiements reçus?
SELECT FLOOR(SUM(amount)) AS total_paiements_recus FROM payments;

-- 3. Listez les gammes de produits qui contiennent des voitures
SELECT * FROM products WHERE productLine LIKE "%cars%";

-- 4. Indiquez le total des paiements pour le 28 octobre 2004
SELECT SUM(amount) AS total_paiement FROM payments WHERE paymentDate = "2004-10-28";

-- 5. Déclarez les paiements supérieurs à 100 000$
SELECT *  FROM payments HAVING amount > 100000;

--  6. Dressez la liste des produits de chaque gamme de produits.
SELECT 
    productLine,
    GROUP_CONCAT(productName ) AS productList
FROM 
    products
GROUP BY 
    productLine; 

-- 7. Combien y a t-il de produits dans chaque gamme de produits
SELECT 
    productLine,
    COUNT(productName) AS productList
FROM 
    products
GROUP BY 
    productLine; 

-- 8. Quel est le paiement minimum reçu ?
SELECT * FROM payments WHERE amount = (SELECT MIN(amount) FROM payments);

-- 9. Listez tous les paiements supérieurs à deux fois le montant moyen ?
SELECT amount AS paiements_superieurs FROM payments WHERE amount > 2 * (SELECT AVG(amount) FROM payments);

-- 10. Combien de produits (distincts) sont vendus?
SELECT DISTINCT COUNT(productName) AS produits_distincts_vendus FROM products;

-- 11. Indiquez le nom et la ville des clients qui n'ont pas de représentants commerciaux ?
SELECT contactLastName, city FROM customers WHERE salesRepEmployeeNumber IS NULL;

-- 12. Comment s'appellent les dirigeants avec VP ou Manager dans leur titre ? Utilisation
-- la fonction CONCAT pour combiner le prénom et le nom des employés
-- dans un champ unique pour le reporting ?

SELECT CONCAT(lastName, " ", firstName) AS managers
FROM employees 
WHERE jobTitle LIKE "%vp%" OR jobTitle LIKE "%manager%";


-- 13. Quelles commandes ont une valeur supérieure à 5 000 $
SELECT orders.orderNumber , status , SUM(quantityOrdered * priceEach) total 
FROM orders 
INNER JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber
GROUP BY orderNumber HAVING total > 5000;

SELECT * FROM productLines;
SELECT * FROM products;
SELECT * FROM customers;
SELECT * FROM employees;