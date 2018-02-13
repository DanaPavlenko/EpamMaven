DROP SCHEMA IF EXISTS Dogs;
CREATE SCHEMA IF NOT EXISTS Dogs DEFAULT CHARACTER SET utf8;
USE Dogs;

CREATE TABLE Breed 
(
  id INT NOT NULL AUTO_INCREMENT,
  breed VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;


CREATE TABLE Dog 
(
  Id INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(20) NOT NULL,
  Age INT NULL,
  BreedId INT NULL,
  PRIMARY KEY (Id),
  CONSTRAINT FOREIGN KEY (BreedId) 
    REFERENCES Breed (id)
    ON UPDATE CASCADE
    ON DELETE SET NULL
) ENGINE = InnoDB;

INSERT INTO breed (Breed) VALUES ('Bulldog'), ('Sheepdog'), ('Yorkshire Terrier'), ('Labrador'), ('Pekingese'), ('Poodle');

INSERT INTO dog VALUES

(1, 'Richard', 10, 3),
(2, 'Rudolf', 5, 1),
(3, 'Yarinka', 27, NULL),
(4, 'Tim', 2, 4),
(5, 'Jessica', 1, 1),
(6, 'Bahira', 5, 1),
(7, 'Mukhtar', 13, 2),
(8, 'Michel', 4, NULL),
(9, 'Maya', 2, 5);



