-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: dth
-- Source Schemata: dth
-- Created: Mon Sep 24 13:14:50 2018
-- Workbench Version: 8.0.12
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema dth
-- ----------------------------------------------------------------------------
DROP DATABASE IF EXISTS `dth` ;
CREATE DATABASE IF NOT EXISTS `dth` ;

-- ----------------------------------------------------------------------------
-- Table dth.channels
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `dth`.`channels` (
  `CHANNEL_ID` INT(11) NOT NULL,
  `CHANNEL_NAME` VARCHAR(20) NULL DEFAULT NULL,
  `Cost_per_month` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`CHANNEL_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table dth.customer
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `dth`.`customer` (
  `SUBSCRIBER_ID` BIGINT(20) NOT NULL,
  `REGISTERED_MOBILE` BIGINT(20) NULL DEFAULT NULL,
  `FIRST_NAME` VARCHAR(30) NULL DEFAULT NULL,
  `LAST_NAME` VARCHAR(30) NULL DEFAULT NULL,
  `mobile` BIGINT(20) NOT NULL,
  PRIMARY KEY (`SUBSCRIBER_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table dth.subscription_details
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `dth`.`subscription_details` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `SUBSCRIPTION_DATE` DATE NULL DEFAULT NULL,
  `SUBSCRIPTION_ID` BIGINT(20) NOT NULL,
  `CHANNEL_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `CHANNEL_ID` (`CHANNEL_ID` ASC) VISIBLE,
  INDEX `SUBSCRIPTION_ID` (`SUBSCRIPTION_ID` ASC) VISIBLE,
  CONSTRAINT `subscription_details_ibfk_1`
    FOREIGN KEY (`CHANNEL_ID`)
    REFERENCES `dth`.`channels` (`CHANNEL_ID`),
  CONSTRAINT `subscription_details_ibfk_2`
    FOREIGN KEY (`SUBSCRIPTION_ID`)
    REFERENCES `dth`.`customer` (`SUBSCRIBER_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Routine dth.createChannels
-- ----------------------------------------------------------------------------
DELIMITER $$

DELIMITER $$
USE `dth`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `createChannels`()
BEGIN

	DROP TABLE IF EXISTS CHANNELS;
	create table CHANNELS(
	CHANNEL_ID INT PRIMARY KEY,
	CHANNEL_NAME VARCHAR(20),
	COST_PER_MONTH DECIMAL
	);

END$$

DELIMITER ;

-- ----------------------------------------------------------------------------
-- Routine dth.create_Cutomer
-- ----------------------------------------------------------------------------
DELIMITER $$

DELIMITER $$
USE `dth`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_Cutomer`()
BEGIN
		DROP TABLE IF EXISTS CUSTOMER;

		CREATE TABLE CUSTOMER (
			SUBSCRIBER_ID BIGINT PRIMARY KEY,
			REGISTERED_MOBILE BIGINT ,
			FIRST_NAME VARCHAR(30), 
			LAST_NAME VARCHAR(30)
		);
END$$

DELIMITER ;

-- ----------------------------------------------------------------------------
-- Routine dth.insertChannels
-- ----------------------------------------------------------------------------
DELIMITER $$

DELIMITER $$
USE `dth`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertChannels`()
BEGIN
INSERT INTO CHANNELS VALUES(101,'STAR PLUS',3.70);
INSERT INTO CHANNELS VALUES(102,'DISCOVERY',4.00);
INSERT INTO CHANNELS VALUES(103,'STAR MOVIES',5.50);
INSERT INTO CHANNELS VALUES(104,'NDTV',13.00);
INSERT INTO CHANNELS VALUES(105,'ZEE',12.0);
INSERT INTO CHANNELS VALUES(106,'SPORTS',4.50);
INSERT INTO CHANNELS VALUES(107,'TIMES NOW',6.50);

END$$

DELIMITER ;

-- ----------------------------------------------------------------------------
-- Routine dth.insertCustomers
-- ----------------------------------------------------------------------------
DELIMITER $$

DELIMITER $$
USE `dth`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCustomers`()
BEGIN
	INSERT INTO CUSTOMER VALUES (1102345678, 7284957435, 'SARBJOT','SINGH');
	INSERT INTO CUSTOMER VALUES (1102345679, 7284957435, 'GURPREET','SINGH');
	INSERT INTO CUSTOMER VALUES (1102345676, 7284957435, 'MINAL','KUMARI');
END$$

DELIMITER ;
SET FOREIGN_KEY_CHECKS = 1;
