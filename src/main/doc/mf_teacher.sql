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

 Date: 19/05/2019 17:27:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mf_teacher
-- ----------------------------
DROP TABLE IF EXISTS `mf_teacher`;
CREATE TABLE `mf_teacher`  (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT 'id自增长',
  `teach_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师编号',
  `teach_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师姓名',
  `teach_gender` tinyint(1) NOT NULL COMMENT '教师性别',
  `teach_img_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师照片',
  `teach_age` tinyint(3) NOT NULL COMMENT '教师年龄',
  `create_time` datetime NULL DEFAULT NULL COMMENT '录入时间',
  `edit_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `teach_state` tinyint(1) NOT NULL COMMENT '教师状态 1 正常 0 离职  2其他',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
