CREATE DATABASE tickets;

USE tickets;

CREATE TABLE IF NOT EXISTS locations (
id_location INT AUTO_INCREMENT PRIMARY KEY,
location_name VARCHAR(200),
adress VARCHAR(200),
capacity LONG
);

CREATE TABLE IF NOT EXISTS events (
id_event INT AUTO_INCREMENT PRIMARY KEY,
event_name VARCHAR(200),
date_event DATE,
hour_event TIME,
id_location INT,
price FLOAT,
number_tickets_sold INT,
CONSTRAINT fk_id_location FOREIGN KEY (id_location) REFERENCES locations(id_location)
);

CREATE TABLE IF NOT EXISTS customers (
id_customer INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(200),
last_name VARCHAR(200),
email VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS tickets_sales (
id_tickets_sales INT AUTO_INCREMENT PRIMARY KEY,
    id_customer INT,
    id_event INT,
    numberTicketsBought INT,
    FOREIGN KEY (id_customer) REFERENCES customers(id_customer),
    FOREIGN KEY (id_event) REFERENCES events(id_event)
);

SELECT event_name, capacity, number_tickets_sold FROM events INNER JOIN locations 
ON locations.id_location = events.id_location WHERE capacity - number_tickets_sold > 0;

SELECT * FROM tickets_sales;
SELECT * FROM locations;
SELECT * FROM events;
SELECT * FROM customers;

DROP TABLE tickets_sales;
DROP TABLE events;
DROP TABLE customers;
DROP TABLE locations;