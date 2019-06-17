/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : user_product

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-06-17 14:54:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_product
-- ----------------------------
DROP TABLE IF EXISTS `user_product`;
CREATE TABLE `user_product` (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `BoilerName` varchar(100) DEFAULT NULL,
  `ControllerNo` varchar(20) DEFAULT NULL,
  `UserId` int(100) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_product
-- ----------------------------
INSERT INTO `user_product` VALUES ('46', '123', '333333333', '113');
INSERT INTO `user_product` VALUES ('48', '456', '0100300001', '113');
INSERT INTO `user_product` VALUES ('49', '254', '0333333333', '113');
INSERT INTO `user_product` VALUES ('51', '6666666', '0444444444', '113');
INSERT INTO `user_product` VALUES ('54', '123', '1111111111', '113');
INSERT INTO `user_product` VALUES ('55', '88', '2222222222', '113');
INSERT INTO `user_product` VALUES ('56', '力威', '1234567895', '113');
INSERT INTO `user_product` VALUES ('58', '546', '01122112211', '113');
