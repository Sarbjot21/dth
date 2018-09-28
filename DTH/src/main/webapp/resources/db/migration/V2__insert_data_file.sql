-- ----------------------------------------------------------------------------
-- Routine dth.insertChannels
-- ----------------------------------------------------------------------------

INSERT INTO `dth`.`channels` VALUES(101,'STAR PLUS',3.70);
INSERT INTO `dth`.`channels` VALUES(102,'DISCOVERY',4.00);
INSERT INTO `dth`.`channels` VALUES(103,'STAR MOVIES',5.50);
INSERT INTO `dth`.`channels` VALUES(104,'NDTV',13.00);
INSERT INTO `dth`.`channels` VALUES(105,'ZEE',12.0);
INSERT INTO `dth`.`channels` VALUES(106,'SPORTS',4.50);
INSERT INTO `dth`.`channels` VALUES(107,'TIMES NOW',6.50);

-- ----------------------------------------------------------------------------
-- Routine dth.insertCustomers
-- ----------------------------------------------------------------------------

INSERT INTO  `dth`.`customer` VALUES (1102345678, 7284957435, 'SARBJOT','SINGH');
INSERT INTO  `dth`.`customer` VALUES (1102345679, 7284957435, 'GURPREET','SINGH');
INSERT INTO  `dth`.`customer` VALUES (1102345676, 7284957435, 'MINAL','KUMARI');

SET FOREIGN_KEY_CHECKS = 1;
