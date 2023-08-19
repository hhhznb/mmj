/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : xuekan

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2023-05-30 11:10:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `papers`
-- ----------------------------
DROP TABLE IF EXISTS `papers`;
CREATE TABLE `papers` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(100) NOT NULL COMMENT '题目',
  `author` varchar(50) NOT NULL COMMENT '作者',
  `supervisor` varchar(50) NOT NULL COMMENT '导师',
  `keywords` varchar(100) NOT NULL COMMENT '关键词',
  `abstract` text NOT NULL COMMENT '摘要',
  `content` longtext NOT NULL COMMENT '正文',
  `reference` longtext NOT NULL COMMENT '参考文献',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='论文表';

-- ----------------------------
-- Records of papers
-- ----------------------------
INSERT INTO `papers` VALUES ('3', '母猪的产后管理', '波比', '迷糊老师', '生产力', 'so like pig', 'pig', 'pig books');
