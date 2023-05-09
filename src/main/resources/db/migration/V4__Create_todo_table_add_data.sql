CREATE TABLE todos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  text VARCHAR(100) NOT NULL,
  done BIT
);
INSERT INTO todos (text, done) values ('Done todo', 1);
INSERT INTO todos (text, done) values ('Undone todo', 0);