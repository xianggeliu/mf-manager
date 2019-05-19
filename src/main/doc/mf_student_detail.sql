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

 Date: 19/05/2019 17:27:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mf_student_detail
-- ----------------------------
DROP TABLE IF EXISTS `mf_student_detail`;
CREATE TABLE `mf_student_detail`  (
  `stu_uuid` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生id',
  `stu_parent_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '监护人姓名',
  `stu_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭住址',
  `stu_phone_num` int(11) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`stu_uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
