/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80300 (8.3.0)
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80300 (8.3.0)
 File Encoding         : 65001

 Date: 24/04/2024 10:23:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `userrole` int DEFAULT NULL,
  `cart` int DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `FKmslgiy8oe299cwxfalm7nbna6` (`cart`),
  CONSTRAINT `FKmslgiy8oe299cwxfalm7nbna6` FOREIGN KEY (`cart`) REFERENCES `cart` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of cart
-- ----------------------------
BEGIN;
INSERT INTO `cart` (`cart_id`, `price`, `product_id`, `product_name`, `quantity`, `userrole`, `cart`) VALUES (49, 3000, 41, 'Macbook Pro M1', 1, 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for cartorder
-- ----------------------------
DROP TABLE IF EXISTS `cartorder`;
CREATE TABLE `cartorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `tex` varchar(255) DEFAULT NULL,
  `total_price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of cartorder
-- ----------------------------
BEGIN;
INSERT INTO `cartorder` (`id`, `date`, `tex`, `total_price`) VALUES (1, '2024-04-23', '178538005', '165850.03');
INSERT INTO `cartorder` (`id`, `date`, `tex`, `total_price`) VALUES (2, '2024-04-24', '234378538', '192600.02');
INSERT INTO `cartorder` (`id`, `date`, `tex`, `total_price`) VALUES (3, '2024-04-24', '236086397', '155150.03');
COMMIT;

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `tex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
BEGIN;
INSERT INTO `orderdetail` (`id`, `price`, `product`, `product_id`, `quantity`, `tex`) VALUES (1, 45000.01, 'Asus A10', 46, 1, '178538005');
INSERT INTO `orderdetail` (`id`, `price`, `product`, `product_id`, `quantity`, `tex`) VALUES (2, 110000.02, 'Asus A20', 47, 2, '178538005');
INSERT INTO `orderdetail` (`id`, `price`, `product`, `product_id`, `quantity`, `tex`) VALUES (3, 45000.01, 'Asus A10', 46, 1, '234378538');
INSERT INTO `orderdetail` (`id`, `price`, `product`, `product_id`, `quantity`, `tex`) VALUES (4, 55000.01, 'Asus A20', 47, 1, '234378538');
INSERT INTO `orderdetail` (`id`, `price`, `product`, `product_id`, `quantity`, `tex`) VALUES (5, 80000, 'Aser M11', 48, 1, '234378538');
INSERT INTO `orderdetail` (`id`, `price`, `product`, `product_id`, `quantity`, `tex`) VALUES (6, 90000.02, 'Asus A10', 46, 2, '236086397');
INSERT INTO `orderdetail` (`id`, `price`, `product`, `product_id`, `quantity`, `tex`) VALUES (7, 55000.01, 'Asus A20', 47, 1, '236086397');
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `detail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `product` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq39fk2qbnqmgxuiqh5wrccgy8` (`product`),
  CONSTRAINT `FKq39fk2qbnqmgxuiqh5wrccgy8` FOREIGN KEY (`product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` (`id`, `detail`, `name`, `price`, `quantity`, `image`, `product`) VALUES (46, 'Notebook Asus', 'Asus A10', 45000.01, 1, '1713870074231_.jpg', NULL);
INSERT INTO `product` (`id`, `detail`, `name`, `price`, `quantity`, `image`, `product`) VALUES (47, 'Asus', 'Asus A20', 55000.01, 1, '1713870223688_.jpg', NULL);
INSERT INTO `product` (`id`, `detail`, `name`, `price`, `quantity`, `image`, `product`) VALUES (50, 'MacBook All New 2025', 'MacBook Pro', 20000, 1, '1713926497163_.jpg', NULL);
INSERT INTO `product` (`id`, `detail`, `name`, `price`, `quantity`, `image`, `product`) VALUES (51, 'Apple', 'Macbook A1 Pro', 20000.01, 1, '1713927886317_.jpg', NULL);
COMMIT;

-- ----------------------------
-- Table structure for promotion
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of promotion
-- ----------------------------
BEGIN;
INSERT INTO `promotion` (`id`, `name`, `price`) VALUES (1, 'Promotion 1', 1000.01);
INSERT INTO `promotion` (`id`, `name`, `price`) VALUES (2, 'Promotion 2', 2000.01);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` int NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`user_id`, `password`, `role`, `user_name`) VALUES (1, '123', 1, 'admin');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
