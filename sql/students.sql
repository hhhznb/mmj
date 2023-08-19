/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : xuekan

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2023-05-30 11:09:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `sno` int NOT NULL COMMENT '学号',
  `name` varchar(16) NOT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `grade` varchar(8) DEFAULT NULL COMMENT '年级',
  `sex` char(3) DEFAULT NULL COMMENT '性别',
  `dept` varchar(32) DEFAULT NULL COMMENT '系部',
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('202088128', '浪淘沙', '23', '大四', '男', '核弹系');
