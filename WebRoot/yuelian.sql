/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : yuelian

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-20 15:51:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_car_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_car_info`;
CREATE TABLE `t_car_info` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `platenumber` varchar(20) DEFAULT NULL,
  `cartype` int(11) DEFAULT NULL,
  `carimage` varchar(500) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car_info
-- ----------------------------
INSERT INTO `t_car_info` VALUES ('1', 'BXD121121', '0', null, null);
INSERT INTO `t_car_info` VALUES ('2', 'BXD121121', '0', null, null);

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
  `isreview` int(11) DEFAULT NULL,
  `reviewdesc` varchar(1000) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  `coachiddrivercarno` varchar(50) DEFAULT NULL,
  `coachiddrviercarimg` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_coach_info
-- ----------------------------
INSERT INTO `t_coach_info` VALUES ('1', 'fasljkfjalk', '121212', null, null, null, null, null, null, null, '5', null, null);
INSERT INTO `t_coach_info` VALUES ('2', 'werqwer', '1233425', null, null, null, null, null, null, null, '4', null, null);
INSERT INTO `t_coach_info` VALUES ('3', 'GourdJYao01', 'GX23121212', 'GX23121212', '500109198902150110', 'http://img3.imgtn.bdimg.com/it/u=1183223528,3058066243&fm=206&gp=0.jpg', '还可以~', '2016-04-11 00:00:00', '1', '资料齐全通过', '7', '渝A19312199', 'http://img3.imgtn.bdimg.com/it/u=1183223528,3058066243&fm=206&gp=0.jpg');

-- ----------------------------
-- Table structure for `t_field_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_field_info`;
CREATE TABLE `t_field_info` (
  `field_id` int(11) NOT NULL AUTO_INCREMENT,
  `fieldname` varchar(200) DEFAULT NULL,
  `fieldphoto` varchar(500) DEFAULT NULL,
  `fieldaddress` varchar(1000) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`field_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_field_info
-- ----------------------------
INSERT INTO `t_field_info` VALUES ('1', '1212', '1212', '1212', '2016-03-18 15:30:31');

-- ----------------------------
-- Table structure for `t_student_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_student_info`;
CREATE TABLE `t_student_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentname` varchar(200) DEFAULT NULL,
  `studenttype` int(11) DEFAULT NULL COMMENT '1学员，2初级人员',
  `studentidcard` varchar(50) DEFAULT NULL,
  `studentidcardimg` varchar(500) DEFAULT NULL,
  `studentcardno` varchar(100) DEFAULT NULL,
  `studentcardimg` varchar(500) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  `studentdrivercardno` varchar(50) DEFAULT NULL,
  `studentdrivercardnoimg` varchar(500) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_info
-- ----------------------------
INSERT INTO `t_student_info` VALUES ('1', 'GourdJYao', '1', '500109198902150110', 'http://img3.imgtn.bdimg.com/it/u=1183223528,3058066243&fm=206&gp=0.jpg', 'GX23121212a', 'http://img3.imgtn.bdimg.com/it/u=1183223528,3058066243&fm=206&gp=0.jpg', '7', '渝A19312199', 'http://img3.imgtn.bdimg.com/it/u=1183223528,3058066243&fm=206&gp=0.jpg', '2016-04-11 00:00:00');

-- ----------------------------
-- Table structure for `t_user_car_temp`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_car_temp`;
CREATE TABLE `t_user_car_temp` (
  `userid` int(11) NOT NULL,
  `carid` int(11) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`userid`,`carid`),
  KEY `caridPK` (`carid`),
  CONSTRAINT `caridPK` FOREIGN KEY (`carid`) REFERENCES `t_car_info` (`car_id`),
  CONSTRAINT `useridPK` FOREIGN KEY (`userid`) REFERENCES `t_coach_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_car_temp
-- ----------------------------
INSERT INTO `t_user_car_temp` VALUES ('1', '1', '2016-03-18 15:30:56');
INSERT INTO `t_user_car_temp` VALUES ('1', '2', '2016-03-18 15:31:16');

-- ----------------------------
-- Table structure for `t_user_field_temp`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_field_temp`;
CREATE TABLE `t_user_field_temp` (
  `userid` int(11) NOT NULL,
  `fieldid` int(11) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`fieldid`,`userid`),
  KEY `userid_PK` (`userid`),
  CONSTRAINT `fiedid_PK` FOREIGN KEY (`fieldid`) REFERENCES `t_field_info` (`field_id`),
  CONSTRAINT `userid_PK` FOREIGN KEY (`userid`) REFERENCES `t_coach_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_field_temp
-- ----------------------------
INSERT INTO `t_user_field_temp` VALUES ('1', '1', null);

-- ----------------------------
-- Table structure for `t_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `headimageurl` varchar(200) DEFAULT NULL,
  `usertype` int(11) DEFAULT NULL COMMENT '0：学员，1:教练',
  `email` varchar(100) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `bloodtype` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `hobby` varchar(200) DEFAULT NULL COMMENT '兴趣爱好',
  `address` varchar(50) DEFAULT NULL,
  `token` varchar(32) DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES ('5', 'yaojian', 'yaojian', null, null, null, null, null, null, '2016-04-11 00:00:00', null, null, 'dapJAExf//QjJuQnz/i0Aw==', '2016-03-08 00:00:00');
INSERT INTO `t_user_info` VALUES ('7', 'yaojian1', 'yaojian1', 'http://img5.imgtn.bdimg.com/it/u=1017606633,46849118&fm=11&gp=0.jpg', '1', 'yaojian@gdtm.com', '乱世英豪', '1', '1', '1987-01-23 00:00:00', '我去', '重庆市巴南区红光大道8号', 'PjprO6Tks/SFghwKLS0EKg==', '2016-04-11 00:00:00');
