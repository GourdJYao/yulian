/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : yuelian

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-03-07 16:58:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_car_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_car_info`;
CREATE TABLE `t_car_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platenumber` varchar(20) DEFAULT NULL,
  `cartype` int(11) DEFAULT NULL,
  `carimage` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_coach_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_coach_info`;
CREATE TABLE `t_coach_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coachname` varchar(50) DEFAULT NULL COMMENT '教练名字',
  `coachcardnumber` varchar(100) DEFAULT NULL COMMENT '教练证号码',
  `coachcardimage` varchar(1000) DEFAULT NULL COMMENT '教练证图片',
  `coachidcardnumber` varchar(50) DEFAULT NULL COMMENT '教练身份证号码',
  `coachidcardimage` varchar(1000) DEFAULT NULL,
  `coachdesc` varchar(500) DEFAULT NULL,
  `coachdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_coach_info
-- ----------------------------
INSERT INTO `t_coach_info` VALUES ('1', '你好', null, null, null, null, null, null);
INSERT INTO `t_coach_info` VALUES ('2', '你好', null, null, null, null, null, null);
INSERT INTO `t_coach_info` VALUES ('3', '你好', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_field_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_field_info`;
CREATE TABLE `t_field_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fieldname` varchar(200) DEFAULT NULL,
  `fieldphoto` varchar(500) DEFAULT NULL,
  `fieldaddress` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_field_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES ('4', 'yaojian', 'yaojian', '2016-03-04 00:00:00', null);
