/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : xuekan

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2023-05-30 11:11:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `username` varchar(32) NOT NULL COMMENT '管理员用户名',
  `password` varchar(64) NOT NULL COMMENT '管理员密码',
  `realname` varchar(32) NOT NULL COMMENT '管理员真实姓名',
  `gender` char(1) DEFAULT NULL COMMENT '管理员性别',
  `email` varchar(64) DEFAULT NULL COMMENT '管理员电子邮箱',
  `phone` varchar(16) DEFAULT NULL COMMENT '管理员联系电话',
  `role` varchar(32) NOT NULL COMMENT '管理员角色',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
