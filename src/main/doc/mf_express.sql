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

 Date: 26/05/2019 19:13:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mf_express
-- ----------------------------
DROP TABLE IF EXISTS `mf_express`;
CREATE TABLE `mf_express`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `express_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '快递单号',
  `e_company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '快递公司名称',
  `e_company_code` tinyint(1) NOT NULL COMMENT '快递公司状态 1 2 3 4 5 6 7',
  `entering_time` bigint(20) NOT NULL COMMENT '录入时间',
  `get_time` bigint(20) NULL DEFAULT NULL COMMENT '取走时间',
  `e_phone` bigint(11) NULL DEFAULT NULL COMMENT '收件人手机号',
  `e_name` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人姓名',
  `e_mark` tinyint(1) NULL DEFAULT NULL COMMENT '快递分类号',
  `e_state` tinyint(1) NULL DEFAULT NULL COMMENT '快递状态 1是正常  0 是已取件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mf_express
-- ----------------------------
INSERT INTO `mf_express` VALUES (1, '6933684005730', '韵达快递', 1, 1558855980207, NULL, NULL, NULL, NULL, 1);
INSERT INTO `mf_express` VALUES (2, '6933684005730', '韵达快递', 1, 1558856464880, NULL, NULL, NULL, NULL, 1);
INSERT INTO `mf_express` VALUES (3, '6933684005730', '韵达快递', 1, 1558856577841, NULL, NULL, NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
