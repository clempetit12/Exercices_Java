--  1. Lister tous les produits achetés par ‘Herkku Gifts’.
SELECT customerName, productName
FROM customers c
JOIN orders o ON c.customerNumber = o.customerNumber  
JOIN orderDetails od ON od.orderNumber = o.orderNumber
JOIN products p ON od.productCode = p.productCode 
WHERE customerName = "Herkku Gifts";


-- 2. Signaler le représentant de compte pour chaque client ?
SELECT customerName, (SELECT CONCAT(lastName, " ", firstName) FROM employees WHERE employeeNumber = salesRepEmployeeNumber) AS representant
FROM customers ;

-- 3. Donnez les paiements totaux pour l'Atelier graphique.
SELECT (SELECT customerName FROM customers WHERE customerName ="Atelier graphique" ) AS atelier_graphique,
SUM(amount) AS total
FROM payments GROUP BY atelier_graphique;

-- 4. Retounez les produits qui n'ont pas été vendus.
SELECT *
FROM products p
LEFT JOIN orderdetails od ON p.productCode = od.productCode
WHERE od.productCode IS NULL OR od.quantityOrdered = 0;


-- 5. Listez le montant payé pour chaque client.
SELECT (SELECT customerName FROM customers WHERE customers.customerNumber = payments.customerNumber) AS customer_Name
, SUM(AMOUNT)
FROM payments 
 GROUP BY customer_Name 
 ORDER BY customer_Name;

-- 6. Indiquez le nombre de commandes « en attente » pour chaque client.
SELECT c.customerName,COUNT(*) AS order_onHold
FROM orders o
JOIN customers c ON o.customerNumber = c.customerNumber
WHERE o.status = 'On Hold'
GROUP BY c.customerName;



SELECT * FROM productLines;
SELECT * FROM products;
SELECT * FROM customers;
SELECT * FROM employees;
SELECT * FROM orderdetails;
SELECT * FROM payments;
SELECT * FROM orders;