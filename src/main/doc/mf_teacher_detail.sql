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

 Date: 19/05/2019 17:27:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mf_teacher_detail
-- ----------------------------
DROP TABLE IF EXISTS `mf_teacher_detail`;
CREATE TABLE `mf_teacher_detail`  (
  `teach_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师编号',
  `teach_idnum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师身份证号码',
  `teach_edu` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学历',
  `teach_edu_school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '毕业学校',
  `teach_edu_time` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '毕业时间',
  `teach_address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭住址',
  `teach_phone` int(11) NOT NULL COMMENT '联系电话',
  `teach_marital_state` tinyint(1) NOT NULL COMMENT '婚姻状态 1 是未婚  2 是已婚  0 是离婚',
  PRIMARY KEY (`teach_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
