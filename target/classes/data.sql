DROP TABLE IF EXISTS book;

CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  book_name VARCHAR(250) NOT NULL,
  booked boolean
);

INSERT INTO book (book_name, booked) VALUES
  ('ABC', false),
  ('XYZ', false),
  ('PQR', false),
  ('TMC', false);
