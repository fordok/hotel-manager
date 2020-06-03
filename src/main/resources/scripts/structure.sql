SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hotelManager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotelManager` DEFAULT CHARACTER SET utf8 ;
USE `hotelManager` ;

-- -----------------------------------------------------
-- Table `hotelManager`.`reservations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelManager`.`reservations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `roomNumber` INT NOT NULL,
  `startDate` DATETIME NULL,
  `endDate` DATETIME NULL,
  `createDate` DATETIME NULL,
  `updateDate` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
