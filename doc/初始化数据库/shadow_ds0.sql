/*
 Navicat Premium Dump SQL

 Source Server         : shardinggit
 Source Server Type    : MySQL
 Source Server Version : 50631 (5.6.31)
 Source Host           : 114.132.79.213:3306
 Source Schema         : shadow_ds0

 Target Server Type    : MySQL
 Target Server Version : 50631 (5.6.31)
 File Encoding         : 65001

 Date: 14/09/2024 09:28:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order0
-- ----------------------------
DROP TABLE IF EXISTS `t_order0`;
CREATE TABLE `t_order0`  (
  `order_id` bigint(20) NOT NULL COMMENT '订单流水ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户流水ID',
  `order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `order_state` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for t_order1
-- ----------------------------
DROP TABLE IF EXISTS `t_order1`;
CREATE TABLE `t_order1`  (
  `order_id` bigint(20) NOT NULL COMMENT '订单流水ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户流水ID',
  `order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `order_state` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for t_order2
-- ----------------------------
DROP TABLE IF EXISTS `t_order2`;
CREATE TABLE `t_order2`  (
  `order_id` bigint(20) NOT NULL COMMENT '订单流水ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户流水ID',
  `order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `order_state` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for t_order3
-- ----------------------------
DROP TABLE IF EXISTS `t_order3`;
CREATE TABLE `t_order3`  (
  `order_id` bigint(20) NOT NULL COMMENT '订单流水ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户流水ID',
  `order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `order_state` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = COMPACT;

SET FOREIGN_KEY_CHECKS = 1;
