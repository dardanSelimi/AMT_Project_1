-- Users Database

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS users;
CREATE SCHEMA users;
USE users;

--
-- Table structure for table `user`
--

CREATE TABLE user (
  id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(45) NOT NULL,
  lastName VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  _password VARCHAR(45) NOT NULL,
  PRIMARY KEY  (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

USE users;
INSERT INTO user VALUES (NULL,'PENELOPE','GUINESS','email','password'),
(NULL,'NICK','WAHLBERG','email','password'),
(NULL,'ED','CHASE','email','password'),
(NULL,'JENNIFER','DAVIS','email','password'),
(NULL,'JOHNNY','LOLLOBRIGIDA','email','password'),
(NULL,'BETTE','NICHOLSON','email','password'),
(NULL,'GRACE','MOSTEL','email','password');
