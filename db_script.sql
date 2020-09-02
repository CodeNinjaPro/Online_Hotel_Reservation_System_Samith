-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hotel_reservation_system_samith
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel_reservation_system_samith
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel_reservation_system_samith` DEFAULT CHARACTER SET utf8 ;
USE `hotel_reservation_system_samith` ;

-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL,
  `user_type` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`customer` (
  `customer_` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `loyalty` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`room` (
  `room_id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `img` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `no_of_rooms` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`room_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`reservation` (
  `reservation_id` INT NOT NULL AUTO_INCREMENT,
  `room_id` INT NULL,
  `customer_id` INT NULL,
  `in_date` VARCHAR(45) NULL,
  `out_date` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`reservation_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`payment` (
  `payment_id` INT NOT NULL AUTO_INCREMENT,
  `reservation_id` INT NULL,
  `amount` DOUBLE NULL,
  `payment_type` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`payment_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`finance_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`finance_details` (
  `finance_details_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`finance_details_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`offer` (
  `offer_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `amount` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`offer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`salary_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`salary_plan` (
  `salary_plan_id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NULL,
  `basic_salary` DOUBLE NULL,
  `ot_rate` DOUBLE NULL,
  `allowance` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`salary_plan_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
