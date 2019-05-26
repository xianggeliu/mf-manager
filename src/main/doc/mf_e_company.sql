/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : mfmanager

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 26/05/2019 19:13:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mf_e_company
-- ----------------------------
DROP TABLE IF EXISTS `mf_e_company`;
CREATE TABLE `mf_e_company`  (
  `id` tinyint(2) NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `e_company_name` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '快递公司名称',
  `e_company_code` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '快递公司code',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mf_e_company
-- ----------------------------
INSERT INTO `mf_e_company` VALUES (1, '韵达快递', 'YD');

SET FOREIGN_KEY_CHECKS = 1;
