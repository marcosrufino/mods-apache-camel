DROP TABLE IF EXISTS people;

CREATE TABLE people (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL,
  sync int
);

INSERT INTO people (first_name, last_name, career,sync) VALUES
('Aliko', 'Dangote', 'Billionaire Industrialist', 0),
('Bill', 'Gates', 'Billionaire Tech Entrepreneur', 0),
('Folrunsho', 'Alakija', 'Billionaire Oil Magnate', 0);