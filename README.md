## Projet Formation DataScientest - Fait 4 jours

Script SQL pour tester (ne pas oublier de changer les logins mySQL dans Connect) :

CREATE DATABASE library_project

USE library_project

CREATE TABLE user(
   id_user INT AUTO_INCREMENT,
   login VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   is_librarian BOOLEAN NOT NULL,
   PRIMARY KEY(id_user),
   UNIQUE(login),
   UNIQUE(id_user)
);

CREATE TABLE subscriber(
   id_subscriber INT AUTO_INCREMENT,
   firstname VARCHAR(50) NOT NULL,
   lastname VARCHAR(50) NOT NULL,
   address VARCHAR(50) NOT NULL,
   nb_max_borrow INT NOT NULL DEFAULT 5,
   nb_blames INT DEFAULT 0,
   not_allowed_to_borrow_until DATE,	
   id_user INT,
   PRIMARY KEY(id_subscriber),
   FOREIGN KEY(id_user) REFERENCES user(id_user) ON DELETE CASCADE ON UPDATE CASCADE
UNIQUE(id_user)
);

CREATE TABLE document_type(
   id_document_type INT AUTO_INCREMENT,
   label VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_document_type),
   UNIQUE(label)
);

CREATE TABLE document(
   id_document INT AUTO_INCREMENT,
   title VARCHAR(50) NOT NULL,
   id_document_type INT NOT NULL,
   PRIMARY KEY(id_document),
   FOREIGN KEY(id_document_type) REFERENCES document_type(id_document_type) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE copy(
   id_copy INT AUTO_INCREMENT,
   state VARCHAR(50) NOT NULL,
   available BOOLEAN NOT NULL DEFAULT 1,
   id_document INT NOT NULL,
   PRIMARY KEY(id_copy),
   FOREIGN KEY(id_document) REFERENCES document(id_document) ON DELETE CASCADE ON UPDATE CASCADE

);

CREATE TABLE author(
   id_author INT AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_author)
);

CREATE TABLE reservation(
   id_reservation INT AUTO_INCREMENT,
   date_reservation DATE NOT NULL,
   is_valid BOOLEAN NOT NULL DEFAULT 1,
   PRIMARY KEY(id_reservation)
);

CREATE TABLE borrow(
   id_subscriber INT,
   id_copy INT,
   date_beginning DATE NOT NULL,
   date_end DATE,
   PRIMARY KEY(id_subscriber, id_copy),
	UNIQUE(id_copy)
   FOREIGN KEY(id_subscriber) REFERENCES subscriber(id_subscriber),
   FOREIGN KEY(id_copy) REFERENCES copy(id_copy) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE to_write(
   id_document INT,
   id_author INT,
   PRIMARY KEY(id_document, id_author),
   FOREIGN KEY(id_document) REFERENCES document(id_document) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY(id_author) REFERENCES author(id_author) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE to_have(
   id_subscriber INT,
   id_reservation INT,
   PRIMARY KEY(id_subscriber, id_reservation),
   FOREIGN KEY(id_subscriber) REFERENCES subscriber(id_subscriber) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY(id_reservation) REFERENCES reservation(id_reservation) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE to_book(
   id_subscriber INT,
   id_document INT,
   PRIMARY KEY(id_subscriber, id_document),
   FOREIGN KEY(id_subscriber) REFERENCES subscriber(id_subscriber) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY(id_document) REFERENCES document(id_document) ON DELETE CASCADE ON UPDATE CASCADE
);





INSERT INTO user (login, password, is_librarian)
VALUES ('john_doe', 'password123', 0),
       ('jane_smith', 'secret456', 1),
       ('admin', 'admin123', 1);

INSERT INTO subscriber (firstname, lastname, address, nb_max_borrow, nb_blames, not_allowed_to_borrow_until, id_user)
VALUES ('Alice', 'Johnson', '123 Main St', 5, 0, NULL, 1),
       ('Bob', 'Smith', '456 Elm St', 3, 1, '2023-06-30', 2);

INSERT INTO document_type (label)
VALUES ('Book'),
       ('Magazine'),
       ('Newspaper');

INSERT INTO document (title, id_document_type)
VALUES ('The Great Gatsby', 1),
       ('National Geographic', 2),
       ('The New York Times', 3);

INSERT INTO copy (state, available, id_document)
VALUES ('Good', 1, 1),
       ('Damaged', 0, 1),
       ('Excellent', 1, 2);

INSERT INTO author (name)
VALUES ('F. Scott Fitzgerald'),
       ('Jane Goodall'),
       ('Mark Twain');

INSERT INTO reservation (date_reservation, is_valid)
VALUES ('2023-05-15', 1),
       ('2023-05-16', 0);



INSERT INTO borrow (id_subscriber, id_copy, date_beginning, date_end)
VALUES (1, 1, '2023-05-15', '2023-05-22'),
       (2, 3, '2023-05-16', NULL);

INSERT INTO to_write (id_document, id_author)
VALUES (1, 1),
       (2, 2),
       (3, 3);

INSERT INTO to_have (id_subscriber, id_reservation)
VALUES (1, 1),
       (2, 2);

INSERT INTO to_book (id_subscriber, id_document)
VALUES (1, 1),
       (2, 3);

