-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotel_reservation_system_samith
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel_reservation_system_samith
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel_reservation_system_samith` DEFAULT CHARACTER SET utf8 ;
USE `hotel_reservation_system_samith` ;

-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`attendace`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`attendace` (
  `attendance_id` INT NOT NULL AUTO_INCREMENT,
  `employee_id` INT NULL DEFAULT NULL,
  `in_time` VARCHAR(45) NULL DEFAULT NULL,
  `out_time` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`attendance_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`customer` (
  `customer_` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `loyalty` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `nic` VARCHAR(45) NULL DEFAULT NULL,
  `contact` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `designation` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`finance_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`finance_details` (
  `finance_details_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`finance_details_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`offer` (
  `offer_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`offer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`payment` (
  `payment_id` INT NOT NULL AUTO_INCREMENT,
  `reservation_id` INT NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `payment_type` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`payment_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`reservation` (
  `reservation_id` INT NOT NULL AUTO_INCREMENT,
  `room_id` INT NULL DEFAULT NULL,
  `customer_id` INT NULL DEFAULT NULL,
  `in_date` VARCHAR(45) NULL DEFAULT NULL,
  `out_date` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`reservation_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`room` (
  `room_id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `img` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `no_of_rooms` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`room_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`salary_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`salary_plan` (
  `salary_plan_id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NULL DEFAULT NULL,
  `basic_salary` DOUBLE NULL DEFAULT NULL,
  `ot_rate` DOUBLE NULL DEFAULT NULL,
  `allowance` DOUBLE NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`salary_plan_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel_reservation_system_samith`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_reservation_system_samith`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL DEFAULT NULL,
  `user_type` VARCHAR(45) NULL DEFAULT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `date_time` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
