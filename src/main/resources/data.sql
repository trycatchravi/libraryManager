DROP TABLE IF EXISTS book;

CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  book_name VARCHAR(250) NOT NULL,
  availability boolean
);

INSERT INTO book (book_name, booked) VALUES
  ('Java Basics and Advance level', false),
  ('Java Basics and Advance level', false),
  ('Guided learning for Elastic Search', false),
  ('Learn Docker and Kubernetes', false),
  ('Microservices Architecture Basics', false);
  ('Microservices Architecture Basics', false);

CREATE TABLE USER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL
);

INSERT INTO USER (username) VALUES
  ('martin@abc.de'),
  ('alex_12@xyz.de'),
  ('mairus@hjd.com');


CREATE TABLE Borrowed (
  user_id INT,
  book_id int
);

INSERT INTO Borrowed (user_id,book_id) VALUES
  (1234,4546),
  (1234,3122),
  (45467,1214);