/*
Navicat MySQL Data Transfer

Source Server         : UCKeFu
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : beimi

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-23 22:55:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `uk_user`
-- ----------------------------
DROP TABLE IF EXISTS `uk_user`;
CREATE TABLE `uk_user` (
  `ID` varchar(32) NOT NULL,
  `LANGUAGE` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `SECURECONF` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `MIDNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `JOBTITLE` varchar(255) DEFAULT NULL,
  `DEPARTMENT` varchar(255) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `BIRTHDAY` varchar(255) DEFAULT NULL,
  `NICKNAME` varchar(255) DEFAULT NULL,
  `USERTYPE` varchar(255) DEFAULT NULL,
  `RULENAME` varchar(255) DEFAULT NULL,
  `SEARCHPROJECTID` varchar(255) DEFAULT NULL,
  `ORGI` varchar(32) DEFAULT NULL,
  `CREATER` varchar(32) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `MEMO` varchar(255) DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `ORGAN` varchar(32) DEFAULT NULL,
  `MOBILE` varchar(32) DEFAULT NULL,
  `passupdatetime` datetime DEFAULT NULL,
  `sign` text,
  `del` tinyint(4) DEFAULT '0',
  `uname` varchar(100) DEFAULT NULL,
  `musteditpassword` tinyint(4) DEFAULT NULL,
  `AGENT` tinyint(4) DEFAULT NULL,
  `SKILL` varchar(32) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `fans` int(11) DEFAULT NULL,
  `follows` int(11) DEFAULT NULL,
  `integral` int(11) DEFAULT NULL,
  `lastlogintime` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `deactivetime` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `DATASTATUS` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uk_user
-- ----------------------------
INSERT INTO `uk_user` VALUES ('297e8c7b455798280145579c73e501c1', null, 'admin', '14e1b600b1fd579f47433b88e8d85291', '5', 'admin@ukewo.com', null, null, null, null, null, '0', null, null, '0', null, null, 'ukewo', null, '2017-03-16 13:56:34', '北京', '2017-03-16 18:36:15', '402883965c1dfe92015c1e1291900003', '18510129577', null, null, '0', '系统管理员', '0', '1', null, '北京', '北京', '2', '1', '0', '2017-06-11 20:34:10', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402883965c1dfe92015c1e12651d0002', null, 'chenfarong', '14e1b600b1fd579f47433b88e8d85291', '5', 'chen@ukewo.cn', null, null, null, null, null, null, null, null, null, null, null, 'ukewo', null, '2017-05-19 08:19:01', null, '2017-05-19 08:19:01', '402883965c1dfe92015c1e1291900003', '18510294566', '2017-05-19 08:19:01', null, '0', '陈法蓉', null, '1', null, null, null, '0', '0', '0', '2017-05-19 08:19:01', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402888815c3fbe82015c3fbeed2d0000', null, null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-05-25 21:14:56', null, '2017-05-25 21:14:56', null, null, '2017-05-25 21:14:56', null, '0', null, null, '0', null, null, null, '0', '0', '0', '2017-05-25 21:14:56', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402888815c3fec05015c3fec2f440000', null, null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-05-25 22:04:22', null, '2017-05-25 22:04:22', null, null, '2017-05-25 22:04:22', null, '0', null, null, '0', null, null, null, '0', '0', '0', '2017-05-25 22:04:22', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402888815c3fec05015c3fec5bd90001', null, null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-05-25 22:04:33', null, '2017-05-25 22:04:33', null, null, '2017-05-25 22:04:33', null, '0', null, null, '0', null, null, null, '0', '0', '0', '2017-05-25 22:04:33', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402888815c3fefe6015c3ff04b630000', null, null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-05-25 22:08:52', null, '2017-05-25 22:08:52', null, null, '2017-05-25 22:08:52', null, '0', null, null, '0', null, null, null, '0', '0', '0', '2017-05-25 22:08:52', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402888815c3fefe6015c3ff04e350001', null, null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-05-25 22:08:52', null, '2017-05-25 22:08:52', null, null, '2017-05-25 22:08:52', null, '0', null, null, '0', null, null, null, '0', '0', '0', '2017-05-25 22:08:52', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402888815c3fefe6015c3ff050060002', null, null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-05-25 22:08:53', null, '2017-05-25 22:08:53', null, null, '2017-05-25 22:08:53', null, '0', null, null, '0', null, null, null, '0', '0', '0', '2017-05-25 22:08:53', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402888815c3fefe6015c3ff050b70003', null, null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-05-25 22:08:53', null, '2017-05-25 22:08:53', null, null, '2017-05-25 22:08:53', null, '0', null, null, '0', null, null, null, '0', '0', '0', '2017-05-25 22:08:53', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402888815c3fefe6015c3ff051830004', null, null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-05-25 22:08:53', null, '2017-05-25 22:08:53', null, null, '2017-05-25 22:08:53', null, '0', null, null, '0', null, null, null, '0', '0', '0', '2017-05-25 22:08:53', null, null, null, '0');
INSERT INTO `uk_user` VALUES ('402888815c3fefe6015c3ff052490005', null, null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-05-25 22:08:53', null, '2017-05-25 22:08:53', null, null, '2017-05-25 22:08:53', null, '0', null, null, '0', null, null, null, '0', '0', '0', '2017-05-25 22:08:53', null, null, null, '0');
