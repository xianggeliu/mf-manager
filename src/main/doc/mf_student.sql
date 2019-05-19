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

 Date: 19/05/2019 17:27:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mf_student
-- ----------------------------
DROP TABLE IF EXISTS `mf_student`;
CREATE TABLE `mf_student`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id自增长',
  `stu_uuid` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生id',
  `stu_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名不能为空',
  `stu_age` tinyint(4) NOT NULL COMMENT '学生年龄',
  `stu_gender` tinyint(4) NOT NULL COMMENT '学生性别1是男生，',
  `stu_img_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上传照片路径',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `edit_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `stu_state` tinyint(1) NOT NULL COMMENT '学生状态 1是正常  2是毕业  0 是不正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
