/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50617
Source Host           : 127.0.0.1:3306
Source Database       : finance_db

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2014-09-23 09:55:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `action`
-- ----------------------------
DROP TABLE IF EXISTS `action`;
CREATE TABLE `action` (
  `at_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(32) DEFAULT NULL,
  `master_name` varchar(32) DEFAULT NULL,
  `action_desc` varchar(128) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `view_mode` int(11) DEFAULT NULL,
  `ac_id` int(11) DEFAULT NULL,
  `action_no` varchar(64) DEFAULT NULL,
  `action_path` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`at_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of action
-- ----------------------------

-- ----------------------------
-- Table structure for `action_column`
-- ----------------------------
DROP TABLE IF EXISTS `action_column`;
CREATE TABLE `action_column` (
  `ac_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(32) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `note` varchar(32) DEFAULT NULL,
  `cg_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of action_column
-- ----------------------------

-- ----------------------------
-- Table structure for `column_group`
-- ----------------------------
DROP TABLE IF EXISTS `column_group`;
CREATE TABLE `column_group` (
  `cg_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(32) DEFAULT NULL,
  `master_name` varchar(32) DEFAULT NULL,
  `post_name` datetime DEFAULT NULL,
  `note` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`cg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of column_group
-- ----------------------------

-- ----------------------------
-- Table structure for `master`
-- ----------------------------
DROP TABLE IF EXISTS `master`;
CREATE TABLE `master` (
  `mt_id` int(11) NOT NULL DEFAULT '0',
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `position` varchar(64) DEFAULT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `post_date` varchar(32) DEFAULT NULL,
  `forbidden` smallint(2) DEFAULT NULL,
  PRIMARY KEY (`mt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master
-- ----------------------------

-- ----------------------------
-- Table structure for `master_map_action`
-- ----------------------------
DROP TABLE IF EXISTS `master_map_action`;
CREATE TABLE `master_map_action` (
  `mma_id` int(11) NOT NULL DEFAULT '0',
  `master_id` int(11) DEFAULT NULL,
  `at_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`mma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_map_action
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_users`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_users`;
CREATE TABLE `tbl_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `usertype` tinyint(2) DEFAULT NULL COMMENT '用户类型',
  `regist_time` datetime DEFAULT NULL COMMENT '注册时间',
  `state` tinyint(2) DEFAULT NULL COMMENT '用户状态',
  `user_address` varchar(128) DEFAULT NULL COMMENT '用户地址',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `pic_url` varchar(128) DEFAULT NULL COMMENT '头像路径',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbl_users
-- ----------------------------
