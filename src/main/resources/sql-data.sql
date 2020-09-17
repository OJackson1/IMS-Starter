INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('Jordan', 'Harrison');
INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('Owen', 'Jackson');
INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('Theo', 'Thuckthunder');
INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('Dick', 'Dickerson');
INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('Harriet', 'Harriman');
INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('Kayley', 'Thompson');


INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Football', 2.95);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Yoyo', 3.45);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Hat', 4.75);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Laptop', 950.95);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Fan', 23.95);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Books', 5.75);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('GoPro', 450.95);
INSERT INTO `ims`.`items` (`itemName`, `value`) VALUES ('Call of Duty Game', 45.95);

INSERT INTO `ims`.`orders` (`customerid`) VALUES (1);
INSERT INTO `ims`.`orders` (`customerid`) VALUES (2);
INSERT INTO `ims`.`orders` (`customerid`) VALUES (3);
INSERT INTO `ims`.`orders` (`customerid`) VALUES (4);
INSERT INTO `ims`.`orders` (`customerid`) VALUES (5);
INSERT INTO `ims`.`orders` (`customerid`) VALUES (6);

INSERT INTO `ims`.`orderItems` (`orderid`, `itemid`, `quantity`) VALUES (1,2,10);
INSERT INTO `ims`.`orderItems` (`orderid`, `itemid`, `quantity`) VALUES (2,2,8);
INSERT INTO `ims`.`orderItems` (`orderid`, `itemid`, `quantity`) VALUES (1,3,6);
INSERT INTO `ims`.`orderItems` (`orderid`, `itemid`, `quantity`) VALUES (3,5,10);
INSERT INTO `ims`.`orderItems` (`orderid`, `itemid`, `quantity`) VALUES (3,5,8);
INSERT INTO `ims`.`orderItems` (`orderid`, `itemid`, `quantity`) VALUES (4,2,4);