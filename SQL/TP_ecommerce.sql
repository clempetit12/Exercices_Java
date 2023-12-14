
-- 1 Afficher les noms, prénoms et titres de l’ensemble des employées en les ordonnant par leurs noms de famille
SELECT lastName, firstName, jobTitle FROM employees ORDER BY lastName;

-- 2 Afficher les noms des employées en supprimant les doublons.
SELECT DISTINCT lastName FROM employees;

-- 3 Sélectionner et afficher le nom de la société, le prénom et le nom du officesofficescontact des clients qui habitent aux USA.
SELECT customerName, contactLastName, contactFirstName, country FROM customers WHERE country = "usa";

-- 4 Sélectionner les emails des employées qui ont un firstname qui se termine par 'y' et qui ont un reportsTo qui commence par '105
SELECT email, firstName, reportsTo FROM employees WHERE firstName LIKE "%y" AND reportsTo LIKE "105%";

-- 5 Sélectionner les noms et emails des employees qui ont un firstname qui commence par un L
SELECT firstName, lastName, email FROM employees WHERE firstName LIKE "L%";

-- 6 Trier la table customers par ordre alphabétique à partir du contactLastName
SELECT * FROM customers ORDER BY contactLastname;

-- 7 - Trier la table employées par ordre croissant en se basant officeCode
SELECT * FROM employees ORDER BY officeCode;

-- 8 Sélectionner les clients qui ont payé pour plus de 100000 euros.
SELECT customerNumber, amount FROM payments WHERE amount > 100000;

-- 9  Afficher le total des ventes par 'orderNumber' et 'status' ?
SELECT orderNumber, status, SUM(amount) 
FROM orders
INNER JOIN payments ON orders.customerNumber = payments.customerNumber GROUP BY orderNumber, status;

-- 10 Afficher les “orderNumber”, “productName”, “msrp”, “priceEach” des produits qui un productcode = ‘S10_1678’ et ont un msrp supérieur au priceEach.
 SELECT productName, msrp, priceEach, orderNumber, products.productCode
 FROM products
 INNER JOIN orderdetails ON orderdetails.productCode = products.productCode 
 WHERE products.productCode = "S10_1678" AND msrp > priceEach;
 
 -- 11  Sélectionner les emails des employées qui ont un firstname qui se termine par 'y' ou qui appartiennent à au bureau de San Francisco.
SELECT email, firstname, officeCode FROM employees WHERE firstName LIKE "%y" OR officeCode = 1 ;

-- 12  Donner le nombre de client qui sont gérés par Leslie Jennings.
SELECT COUNT(*)
FROM employees 
JOIN customers ON customers.salesRepEmployeeNumber = employees.employeeNumber WHERE lastName = "jennings" AND firstName = "leslie";

-- 13 Afficher le nom et prénom de la personne qui a le jobTitle de Président
SELECT firstName, lastName, jobTitle FROM employees WHERE jobTitle = "president";

-- 14 Donner la somme des montants des paiements reçu pendant le mois de Mars 2005.
SELECT FLOOR(SUM(amount)) AS montant_mars FROM payments WHERE paymentDate LIKE "2005-03-%";

-- 15 Afficher le total des paiements par nom des clients
SELECT contactLastName, SUM(amount)
FROM customers
JOIN payments ON payments.customerNumber = customers.customerNumber GROUP BY contactLastName;


-- 16 Afficher la date de commande et le numéro client des commandes annulées
SELECT customerNumber, status, orderDate FROM orders WHERE status = "cancelled";

-- 17 Afficher la liste (prénom et nom ) des subordonnées de Bow Anthony
SELECT lastName, firstName, jobTitle FROM employees WHERE officeCode = 1 AND lastName <> "bow" AND firstName <> "anthony"  ;

-- 18 Afficher le nom et le prénom du ou des employés qui n'ont pas de supérieur hiérarchique
SELECT lastName, firstName FROM employees WHERE reportsTo IS NULL ;

-- 19 Dans le detail des commandes afficher la commande avec la plus petite quantité
SELECT MIN(quantityOrdered) AS plus_petite_quantite FROM orderdetails ;

-- 20  Afficher le detail de la commande qui est datée du 21-04-2003
SELECT * 
FROM orderdetails
JOIN orders ON orderdetails.orderNumber = orders.orderNumber WHERE orderDate = "2003-04-21";

-- 21 Afficher la liste des managers avec les employées qu’ils managent. Le nom
-- de la colonne s’appellera ‘Manager’ pour la colonne des managers, elle
-- regroupera leurs noms et prénoms. Idem pour la colonne employée, elle
-- s’appellera ‘Employée’, elle affichera le nom et prénom des employés.

SELECT
CONCAT(e.lastName," ", e.firstName) AS employee, e.reportsTo,
CONCAT(manager.lastName, " ", manager.firstName) AS manager
FROM
  employees e
 JOIN
  employees manager ON e.reportsTo = manager.employeeNumber;

-- 22   Afficher le nom des managers et le nombre d’employé qu’ils managent.
  SELECT manager.lastname, COUNT(*) AS nombre_employe
  FROM 
  employees e
  JOIN 
  employees manager ON e.reportsTo = manager.employeeNumber GROUP BY manager.lastname ;
  
  SELECT * FROM employees WHERE reportsTo = 1102;

SELECT * FROM employees  WHERE lastName = "jennings" AND firstName = "leslie";
SELECT * FROM employees;
SELECT * FROM offices;
SELECT * FROM customers;
SELECT * FROM payments;
SELECT * FROM orders;
SELECT * FROM products;
SELECT * FROM productlines;
SELECT * FROM orderdetails;