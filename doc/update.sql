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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbl_users
-- ----------------------------


-- ----------------------------
-- Table structure for `tbl_product_info` (产品详情表)
-- ----------------------------

CREATE TABLE `tbl_product_info` (
	`id`  int(11) NOT NULL AUTO_INCREMENT ,
	`product_name`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称' ,
	`fund_scale`  double(16,0) NULL DEFAULT NULL COMMENT '基金规模( 需要募集的资金, 已元为单位 )' ,
	`expect_profit`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预期收益' ,
	`total_money`  double(11,0) NULL DEFAULT NULL COMMENT '已募集总金额' ,
	`fund_type_id`  int(11) NULL DEFAULT NULL COMMENT '基金类型( 基金类型表ID )' ,
	`investment_time_limit`  tinyint(2) NULL DEFAULT NULL COMMENT '投资期限( 以月为单位 )' ,
	`fund_manage`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基金管理( 目前理解为公司名称 )' ,
	`min_bid_money`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '起投金额( 目前为字符串，如果单位定了的话，转为int类型 )' ,
	`profit_distribution`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收益分配 ( 同起投金额 )' ,
	`year_interest_rate`  double(4,0) NULL DEFAULT 0 COMMENT '年利率' ,
	`credit_levle`  tinyint(2) NULL DEFAULT 0 COMMENT '信用等级' ,
	`begin_time`  datetime NULL DEFAULT NULL COMMENT '产品投资开始时间' ,
	`end_time`  datetime NULL DEFAULT NULL COMMENT '产品投资结束时间( 根据开始时间及募集日期推算 )' ,
	`product_detaile_info`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '项目介绍' ,
	`is_mortgage`  tinyint(2) NULL DEFAULT NULL COMMENT '是否抵押( 1:有抵押，2:未抵押 )' ,
	`fund_use`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '资金用途' ,
	`repayment_source`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '还款方式' ,
	`business_structure`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'business_structure' ,
	`wind_control_measures`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '风控措施' ,
	`to_examine_status`  tinyint(2) NULL DEFAULT NULL COMMENT '审核状态( 1.未审核 2.审核)' ,
	`product_mortgage_id`  int(11) NULL DEFAULT NULL COMMENT '产品抵押物品(对应抵押物品表)' ,
	PRIMARY KEY (`id`)
	)
	ENGINE=InnoDB
	DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
	AUTO_INCREMENT=1
	ROW_FORMAT=COMPACT
;




-- ----------------------------
-- Table structure for `tbl_product_mortgage` (产品对应抵押物品表)
-- ----------------------------

CREATE TABLE `tbl_product_mortgage` (
`id`  int(11) NOT NULL ,
`mortgage_name`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押物品名称' ,
`imag_url`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押物品对应图片' ,
`product_id`  int(11) NOT NULL COMMENT '对应产品ID' ,
`status`  tinyint(2) NULL DEFAULT NULL COMMENT '1.可用 2.不可用' ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
CHECKSUM=0
ROW_FORMAT=DYNAMIC
DELAY_KEY_WRITE=0
;

-- ----------------------------
-- Table structure for `tbl_product_fund_type` (基金类型表)
-- ----------------------------

CREATE TABLE `tbl_product_fund_type` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`investment_name`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资类型名称' ,
`status`  tinyint(2) NULL DEFAULT 1 COMMENT '状态： 1 可用，2不可用' ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=DYNAMIC
DELAY_KEY_WRITE=0
;

