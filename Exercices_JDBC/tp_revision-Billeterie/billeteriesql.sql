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
    id_customer INT ,
    id_event INT,
    numberTicketsBought INT,
    FOREIGN KEY (id_customer) REFERENCES customers(id_customer)  ON DELETE CASCADE,
    FOREIGN KEY (id_event) REFERENCES events(id_event)  ON DELETE CASCADE
);

SELECT event_name, capacity, number_tickets_sold FROM events INNER JOIN locations 
ON locations.id_location = events.id_location WHERE capacity - number_tickets_sold > 0;

INSERT INTO locations (location_name,adress,capacity ) 
VALUES 
("PARIS", "12 rue de la paix", 2000),
("LILLE", "12 rue de la gare", 500),
("AMIENS", "12 rue de la colombe", 5000),
("ARRAS", "12 rue de la pluie", 1000);

INSERT INTO events (event_name,date_event,hour_event,id_location,price,number_tickets_sold ) 
VALUES 
("rock en seine", "2024-06-12", "20:00:00", 1, 50, 0) ,
("solidays", "2025-07-14", "21:00:00", 2, 50, 0) ,
("main square", "2026-06-12", "20:00:00", 4, 60, 0) ,
("lolapaloza", "2023-12-30", "21:00:00", 3, 40, 0) ;

INSERT INTO customers (first_name,last_name,email ) 
VALUES 
("louis", "pami","lp@gmail.com"),
("elodie", "taram","et@gmail.com"),
("helene", "patard","hp@gmail.com"),
("pauline", "lahout","pl@gmail.com");

SELECT * FROM tickets_sales;
SELECT * FROM locations;
SELECT * FROM events;
SELECT * FROM customers;

DROP TABLE tickets_sales;
DROP TABLE events;
DROP TABLE customers;
DROP TABLE locations;