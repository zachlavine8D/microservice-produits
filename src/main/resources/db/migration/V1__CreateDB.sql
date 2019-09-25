CREATE DATABASE IF NOT EXISTS store;

USE store;

CREATE TABLE IF NOT EXISTS store.product (
   id INT AUTO_INCREMENT,
   titre VARCHAR (45) UNIQUE,
   description VARCHAR (500),
   image VARCHAR (500) UNIQUE,
   prix DOUBLE ,
   PRIMARY KEY (id)
);
