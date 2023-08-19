/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : xuekan

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2023-05-30 11:11:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `journals`
-- ----------------------------
DROP TABLE IF EXISTS `journals`;
CREATE TABLE `journals` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `publisher` varchar(128) NOT NULL,
  `issn` char(8) NOT NULL,
  `cn` char(16) NOT NULL,
  `index_term` varchar(1024) DEFAULT '',
  `introduction` text,
  `cover_image` mediumblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `issn` (`issn`),
  UNIQUE KEY `cn` (`cn`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of journals
-- ----------------------------
INSERT INTO `journals` VALUES ('3', '传统文化', '新青年', '9389', '10298', '传统', '传统', null);
