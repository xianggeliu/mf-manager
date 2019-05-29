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

 Date: 29/05/2019 21:05:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mf_express_day_total
-- ----------------------------
DROP TABLE IF EXISTS `mf_express_day_total`;
CREATE TABLE `mf_express_day_total`  (
  `id` int(8) NOT NULL COMMENT '唯一主键 记录每天的入库出库统计',
  `into_total` int(4) NULL DEFAULT NULL COMMENT '每天入库的数量',
  `out_total` int(4) NULL DEFAULT NULL COMMENT '每天出库的数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
