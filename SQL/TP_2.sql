-- 1. Trouvez des produits contenant le nom «Ford »?
SELECT * FROM products WHERE productName LIKE  "%ford%";

-- 2. Listez les produits se terminant par 'ship'?
SELECT * FROM products WHERE productName LIKE  "%ship";

--  3. Listez les produits dont le code produit commence par S700?
SELECT * FROM products WHERE productCode LIKE  "S700%";

--  4. Énumérez les fournisseurs dont le nom se termine par Diecast?
SELECT * FROM products WHERE productVendor LIKE  "%diecast";

-- 5. Déclarez le total des paiements par date
SELECT paymentDate, SUM(AMOUNT) AS total_paiements_date FROM payments GROUP BY paymentDate ;


SELECT * FROM productLines;
SELECT * FROM products;
SELECT * FROM customers;
SELECT * FROM employees;