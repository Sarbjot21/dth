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
USE `dth`;
CREATE TABLE IF NOT EXISTS `dth`.`channels` (
  `CHANNEL_ID` INT(11) NOT NULL,
  `CHANNEL_NAME` VARCHAR(20) NULL DEFAULT NULL,
  `Cost_per_month` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`CHANNEL_ID`))
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------------------------------------------------------
-- Table dth.customer
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `dth`.`customer` (
  `SUBSCRIBER_ID` BIGINT(20) NOT NULL,
  `REGISTERED_MOBILE` BIGINT(20) NULL DEFAULT NULL,
  `FIRST_NAME` VARCHAR(30) NULL DEFAULT NULL,
  `LAST_NAME` VARCHAR(30) NULL DEFAULT NULL,
   PRIMARY KEY (`SUBSCRIBER_ID`))
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

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
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

