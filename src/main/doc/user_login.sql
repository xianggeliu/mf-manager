/*
 Navicat Premium Data Transfer

 Source Server         : localMySql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : mfmanager

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 16/05/2019 17:57:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `id` int(8) NOT NULL COMMENT '主键自增长',
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录账户',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录密码',
  `last_login_ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后一次登录IP',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次登录时间',
  `regist_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES (1, 'admin', '21232F297A57A5A743894A0E4A801FC3', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
