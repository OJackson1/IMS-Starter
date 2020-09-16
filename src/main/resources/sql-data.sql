INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('Owen', 'Jackson');
INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('Kay', 'Benjamin');

INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Football', 2.50);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Yoyo', 3.50);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Hat', 4.75);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Laptop', 950.50);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Fan', 23.50);

INSERT INTO `ims`.`orders` (`customerid`) VALUES (1);
INSERT INTO `ims`.`orders` (`customerid`) VALUES (2);
INSERT INTO `ims`.`orders` (`customerid`) VALUES (3);
INSERT INTO `ims`.`orders` (`customerid`) VALUES (4);

INSERT INTO `ims`.`orderItems` (`orderid`, `itemid`, `quantity`) VALUES (1,2,10);
INSERT INTO `ims`.`orderItems` (`orderid`, `itemid`, `quantity`) VALUES (2,2,8);
INSERT INTO `ims`.`orderItems` (`orderid`, `itemid`, `quantity`) VALUES (1,3,6);