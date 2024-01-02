CREATE DATABASE ba	nk;

USE bank;

CREATE TABLE IF NOT EXISTS customers (
customer_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(200),
last_name VARCHAR(200),
telephone VARCHAR(12)
);

CREATE TABLE IF NOT EXISTS accounts (
account_id INT AUTO_INCREMENT PRIMARY KEY,
solde DECIMAL(15,2) DEFAULT 0,
customer_id INT,
CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE

);

CREATE TABLE IF NOT EXISTS operations (
operation_id INT AUTO_INCREMENT PRIMARY KEY,
account_id INT,
montant DECIMAL(15,2),
statut VARCHAR(200),
CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES accounts(account_id) ON DELETE CASCADE

);

SELECT * FROM customers;
SELECT * FROM accounts;
SELECT * FROM operations;

DROP TABLE operations;
DROP TABLE accounts;
DROP TABLE customers;

