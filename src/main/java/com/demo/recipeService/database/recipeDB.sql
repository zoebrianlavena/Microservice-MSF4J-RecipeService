-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema recipedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema recipedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `recipedb` DEFAULT CHARACTER SET latin1 ;
USE `recipedb` ;

-- -----------------------------------------------------
-- Table `recipedb`.`recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `recipedb`.`recipe` (
  `recipeID` INT(11) NOT NULL AUTO_INCREMENT,
  `chefName` VARCHAR(45) NOT NULL,
  `recipeName` VARCHAR(45) NOT NULL,
  `ingredients` VARCHAR(45) NOT NULL,
  `instructions` VARCHAR(45) NOT NULL,
  `rating` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`recipeID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
