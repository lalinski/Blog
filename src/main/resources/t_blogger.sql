/*
Navicat MySQL Data Transfer

Source Server         : xiao
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : blogssm

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-03-01 19:18:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_blogger
-- ----------------------------
DROP TABLE IF EXISTS `t_blogger`;
CREATE TABLE `t_blogger` (
  `blogger_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `md` text COMMENT '信息',
  `html` text COMMENT '昵称',
  `github` varchar(200) DEFAULT NULL COMMENT '签名',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像路径',
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`blogger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
