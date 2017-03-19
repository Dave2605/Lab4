CREATE DATABASE library;

USE library;

CREATE TABLE books (id INT primary key AUTO_INCREMENT, name VARCHAR(50), author VARCHAR(20), genre VARCHAR(50));
CREATE TABLE authors (id INT primary key AUTO_INCREMENT, name VARCHAR(50), birth_place VARCHAR(50));

INSERT INTO books VALUES (1, 'The hobbit', 'J.R.R. Tolkien', 'adventure');
INSERT INTO books VALUES (2, '1984', 'George Orwell', 'novel');

INSERT INTO authors VALUES (1, 'J.R.R. Tolkien', 'Republic of South Africa');
INSERT INTO authors VALUES (2, 'George Orwell', 'India'); 
