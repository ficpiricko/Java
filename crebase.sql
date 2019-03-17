CREATE SCHEMA `projekcije` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `projekcije`.`film` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
 CREATE TABLE `projekcije`.`projekcija` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `film` INT,
  `vreme` CHAR(5) NOT NULL,
  `cena` INT NOT NULL,
  `duzina` INT NULL,
  `brojSale` INT NOT NULL,
  `tip` CHAR(2) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE INDEX `id_UNIQUE` (`id` ASC),
   INDEX `fk_projekcija_film_idx` (`film` ASC),
   CONSTRAINT `fk_projekcija_film`
   FOREIGN KEY (`film`)
   REFERENCES `projekcije`.`film` (`id`)
   ON DELETE CASCADE
   ON UPDATE CASCADE);
   
use projekcije;

insert into film(naziv) values('Rampage');
insert into film(naziv) values('Tiho mesto');
insert into film(naziv) values('Nevesta');
insert into film(naziv) values('Ponoćno sunce');

insert into projekcija(film, vreme, cena, brojSale, duzina, tip) values(1, '20:20', 450, 3, 107, '3D');
insert into projekcija(film, vreme, cena, brojSale, duzina, tip) values(1, '16:30', 300, 1, 107, '2D');
insert into projekcija(film, vreme, cena, brojSale, duzina, tip) values(2, '21:00', 350, 2, 90, '2D');
insert into projekcija(film, vreme, cena, brojSale, duzina, tip) values(3, '22:30', 350, 1, 93, '2D');
insert into projekcija(film, vreme, cena, brojSale, duzina, tip) values(4, '22:05', 350, 6, 91, '2D');

CREATE TABLE IF NOT EXISTS User(
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (id));

INSERT INTO User (username, password) VALUES ('pera', 'peric');
INSERT INTO User (username, password) VALUES ('steva', 'stevic');

	  
	  

