/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : end_sdcsoft_db

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-06-18 09:31:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for terminal_product
-- ----------------------------
DROP TABLE IF EXISTS `terminal_product`;
CREATE TABLE `terminal_product` (
  `Id` int(20) NOT NULL AUTO_INCREMENT,
  `BoilerName` varchar(100) DEFAULT NULL,
  `ControllerNo` varchar(20) DEFAULT NULL,
  `UserId` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of terminal_product
-- ----------------------------
INSERT INTO `terminal_product` VALUES ('1', '123', '0100300001', '113');
INSERT INTO `terminal_product` VALUES ('2', '8888', '0111111111', '113');
INSERT INTO `terminal_product` VALUES ('4', '546', '0111111111', '113');
INSERT INTO `terminal_product` VALUES ('5', '554', '0333333333', '113');
INSERT INTO `terminal_product` VALUES ('6', '554', '0555555555', '113');
