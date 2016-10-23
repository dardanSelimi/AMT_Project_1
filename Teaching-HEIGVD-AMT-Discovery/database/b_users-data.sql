SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

USE users;


SET AUTOCOMMIT=0;

INSERT INTO user VALUES (NULL, "admin", "admin", "admin@admin.ch", "admin"), 
						(NULL, "test1", "test1", "test1@test1.ch", "test"), 
						(NULL, "test1", "test1", "test2@test2.ch", "test"),
						(NULL, "test1", "test1", "test3@test3.ch", "test");
COMMIT;

SET AUTOCOMMIT=1;

