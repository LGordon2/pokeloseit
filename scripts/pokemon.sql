CREATE TABLE pokemon
(
  number INT NOT NULL,
  name VARCHAR(200) PRIMARY KEY NOT NULL,
  weight NUMERIC(131089) NOT NULL
);
CREATE UNIQUE INDEX unique_name ON pokemon (name);
