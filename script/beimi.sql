/*
Navicat MySQL Data Transfer

Source Server         : UCKeFu
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : beimi

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-03 23:43:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bm_organ`
-- ----------------------------
DROP TABLE IF EXISTS `bm_organ`;
CREATE TABLE `bm_organ` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `CODE` varchar(50) DEFAULT NULL COMMENT '代码',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `ORGI` varchar(32) DEFAULT NULL COMMENT '租户ID',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  `PARENT` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `SKILL` tinyint(4) DEFAULT '0' COMMENT '启用技能组',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_organ
-- ----------------------------

-- ----------------------------
-- Table structure for `bm_organrole`
-- ----------------------------
DROP TABLE IF EXISTS `bm_organrole`;
CREATE TABLE `bm_organrole` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `organ_id` varchar(32) DEFAULT NULL COMMENT '机构ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `creater` varchar(32) DEFAULT NULL COMMENT '创建人',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `orgi` varchar(32) DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_organrole
-- ----------------------------

-- ----------------------------
-- Table structure for `bm_playuser`
-- ----------------------------
DROP TABLE IF EXISTS `bm_playuser`;
CREATE TABLE `bm_playuser` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `LANGUAGE` varchar(255) DEFAULT NULL COMMENT '语言',
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '密码',
  `SECURECONF` varchar(255) DEFAULT NULL COMMENT '安全级别',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT '邮件',
  `FIRSTNAME` varchar(255) DEFAULT NULL COMMENT '姓',
  `MIDNAME` varchar(255) DEFAULT NULL COMMENT '名',
  `LASTNAME` varchar(255) DEFAULT NULL COMMENT '名',
  `JOBTITLE` varchar(255) DEFAULT NULL COMMENT '职位',
  `DEPARTMENT` varchar(255) DEFAULT NULL COMMENT '部门',
  `GENDER` varchar(255) DEFAULT NULL COMMENT '性别',
  `BIRTHDAY` varchar(255) DEFAULT NULL COMMENT '生日',
  `NICKNAME` varchar(255) DEFAULT NULL COMMENT '昵称',
  `USERTYPE` varchar(255) DEFAULT NULL COMMENT '用户类型',
  `RULENAME` varchar(255) DEFAULT NULL COMMENT '角色',
  `SEARCHPROJECTID` varchar(255) DEFAULT NULL COMMENT '备用',
  `ORGI` varchar(32) DEFAULT NULL COMMENT '租户ID',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MEMO` varchar(255) DEFAULT NULL COMMENT '备注',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `MOBILE` varchar(32) DEFAULT NULL COMMENT '手机号',
  `passupdatetime` datetime DEFAULT NULL COMMENT '最后 一次密码修改时间',
  `sign` text,
  `del` tinyint(4) DEFAULT '0',
  `login` tinyint(4) DEFAULT '0',
  `online` tinyint(4) DEFAULT '0',
  `headimg` tinyint(4) DEFAULT '0' COMMENT '是否设置头像',
  `secquestion` tinyint(4) DEFAULT '0' COMMENT '是否设置密保问题',
  `playerlevel` varchar(32) DEFAULT NULL COMMENT '玩家等级',
  `experience` int(11) DEFAULT '0' COMMENT '玩家积分',
  `uname` varchar(100) DEFAULT NULL,
  `musteditpassword` tinyint(4) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `fans` int(11) DEFAULT '0' COMMENT '关注人数',
  `follows` int(11) DEFAULT '0' COMMENT '被关注次数',
  `integral` int(11) DEFAULT '0',
  `lastlogintime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `deactivetime` datetime DEFAULT NULL COMMENT '离线时间',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `DATASTATUS` tinyint(4) DEFAULT '0' COMMENT '数据状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_playuser
-- ----------------------------
INSERT INTO `bm_playuser` VALUES ('1', 'zh', 'admin', '14e1b600b1fd579f47433b88e8d85291', '1', 'admin@beixi.me', null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-08-03 21:31:23', null, '2017-08-03 21:31:26', null, '2017-08-03 21:31:30', null, '0', '1', '0', '0', '0', null, '0', null, null, null, null, '0', '0', '0', '2017-08-03 23:38:31', null, null, null, '0');

-- ----------------------------
-- Table structure for `bm_role`
-- ----------------------------
DROP TABLE IF EXISTS `bm_role`;
CREATE TABLE `bm_role` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `CODE` varchar(50) DEFAULT NULL COMMENT '代码',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `ORGI` varchar(32) DEFAULT NULL COMMENT '租户ID',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_role
-- ----------------------------

-- ----------------------------
-- Table structure for `bm_role_auth`
-- ----------------------------
DROP TABLE IF EXISTS `bm_role_auth`;
CREATE TABLE `bm_role_auth` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `CODE` varchar(50) DEFAULT NULL COMMENT '代码',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `ORGI` varchar(32) DEFAULT NULL COMMENT '租户ID',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  `ROLEID` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `DICID` varchar(32) DEFAULT NULL COMMENT '权限ID',
  `DICVALUE` varchar(30) DEFAULT NULL COMMENT '权限代码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_role_auth
-- ----------------------------

-- ----------------------------
-- Table structure for `bm_user`
-- ----------------------------
DROP TABLE IF EXISTS `bm_user`;
CREATE TABLE `bm_user` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `LANGUAGE` varchar(255) DEFAULT NULL COMMENT '语言',
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '密码',
  `SECURECONF` varchar(255) DEFAULT NULL COMMENT '安全级别',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT '邮件',
  `FIRSTNAME` varchar(255) DEFAULT NULL COMMENT '姓',
  `MIDNAME` varchar(255) DEFAULT NULL COMMENT '名',
  `LASTNAME` varchar(255) DEFAULT NULL COMMENT '名',
  `JOBTITLE` varchar(255) DEFAULT NULL COMMENT '职位',
  `DEPARTMENT` varchar(255) DEFAULT NULL COMMENT '部门',
  `GENDER` varchar(255) DEFAULT NULL COMMENT '性别',
  `BIRTHDAY` varchar(255) DEFAULT NULL COMMENT '生日',
  `NICKNAME` varchar(255) DEFAULT NULL COMMENT '昵称',
  `USERTYPE` varchar(255) DEFAULT NULL COMMENT '用户类型',
  `RULENAME` varchar(255) DEFAULT NULL COMMENT '角色',
  `SEARCHPROJECTID` varchar(255) DEFAULT NULL COMMENT '备用',
  `ORGI` varchar(32) DEFAULT NULL COMMENT '租户ID',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MEMO` varchar(255) DEFAULT NULL COMMENT '备注',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `ORGAN` varchar(32) DEFAULT NULL COMMENT '部门',
  `MOBILE` varchar(32) DEFAULT NULL COMMENT '手机号',
  `passupdatetime` datetime DEFAULT NULL COMMENT '最后 一次密码修改时间',
  `sign` text,
  `del` tinyint(4) DEFAULT '0',
  `uname` varchar(100) DEFAULT NULL,
  `musteditpassword` tinyint(4) DEFAULT NULL,
  `AGENT` tinyint(4) DEFAULT NULL COMMENT '工号',
  `SKILL` varchar(32) DEFAULT NULL COMMENT '技能组',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `fans` int(11) DEFAULT NULL COMMENT '关注人数',
  `follows` int(11) DEFAULT NULL COMMENT '被关注次数',
  `integral` int(11) DEFAULT NULL,
  `lastlogintime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `deactivetime` datetime DEFAULT NULL COMMENT '离线时间',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `DATASTATUS` tinyint(4) DEFAULT NULL COMMENT '数据状态',
  `callcenter` tinyint(4) DEFAULT NULL COMMENT '启用呼叫中心坐席',
  `SUPERUSER` tinyint(4) DEFAULT NULL COMMENT '是否超级管理员',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_user
-- ----------------------------
INSERT INTO `bm_user` VALUES ('297e8c7b455798280145579c73e501c1', null, 'admin', '14e1b600b1fd579f47433b88e8d85291', '5', 'admin@ukewo.com', null, null, null, null, null, '0', null, null, '0', null, null, 'ukewo', null, '2017-03-16 13:56:34', '北京', '2017-07-17 23:27:29', null, '18510129577', null, null, '0', '系统管理员', '0', '1', null, '北京', '北京', '2', '1', '0', '2017-08-03 21:37:56', null, null, null, '0', '0', '1');
INSERT INTO `bm_user` VALUES ('402883965c1dfe92015c1e12651d0002', null, 'chenfarong', '14e1b600b1fd579f47433b88e8d85291', '5', 'chen@ukewo.cn', null, null, null, null, null, null, null, null, null, null, null, 'ukewo', null, '2017-05-19 08:19:01', null, '2017-07-05 16:52:39', null, '18510294566', '2017-05-19 08:19:01', null, '0', '陈法蓉', null, '1', null, null, null, '0', '0', '0', '2017-07-26 17:02:18', null, null, null, '0', '0', '0');

-- ----------------------------
-- Table structure for `bm_userrole`
-- ----------------------------
DROP TABLE IF EXISTS `bm_userrole`;
CREATE TABLE `bm_userrole` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `creater` varchar(32) DEFAULT NULL COMMENT '创建人',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `orgi` varchar(32) DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_userrole
-- ----------------------------
