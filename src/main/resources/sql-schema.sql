drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customerid` INT(11) NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`customerid`)
);
CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `itemid` INT(11) NOT NULL AUTO_INCREMENT,
    `itemName` VARCHAR(40) NULL DEFAULT NULL,
    `value` DECIMAL(3) NULL DEFAULT NULL,
    PRIMARY KEY (`itemid`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `orderid` INT(11) NOT NULL AUTO_INCREMENT,
    `customerid` INT(11) NOT NULL,
    `itemid` INT(11) NOT NULL, `quantity` INT(11) NOT NULL,
    PRIMARY KEY (`orderid`),
    foreign key (`customerid`) references customers (`customerid`),
    foreign key (`itemid`) references items (`itemid`)
);