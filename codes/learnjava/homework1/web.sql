/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-03-09 11:00:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `credits` int(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `last_visit` datetime DEFAULT NULL,
  `last_ip` varchar(23) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', null, '123456', '2018-03-06 09:24:11', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(8) DEFAULT '男',
  `hobbys` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', '男', '篮球', '成都', '单身');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(8) DEFAULT '男',
  `likes` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'firstone', '123456', '男', '音乐', '北京', '单身');
INSERT INTO `users` VALUES ('12', 'forth', '123', 'man', '读书', 'chengdu', '有啥不一样');
INSERT INTO `users` VALUES ('13', '123', '123', 'man', '游泳', '成都', '烦烦烦');
INSERT INTO `users` VALUES ('14', '1', '1', '男', '看报', 'didu', '祟拜你');
INSERT INTO `users` VALUES ('15', '2', '2', 'woman', '看报', 'yaodu', '公司法个');
INSERT INTO `users` VALUES ('16', '3', '4', '男', '写作', 'wudu', '打发打发');
INSERT INTO `users` VALUES ('17', '4', '34', 'woman', '游泳', 'yaodu', '饿啊');
INSERT INTO `users` VALUES ('18', '5', '12', '男', '音乐', '成都', '饭饭');
INSERT INTO `users` VALUES ('19', '6', '3453', '男', '电脑', '大竹', '啊都放假啊大家f');
INSERT INTO `users` VALUES ('20', '7', '234', '男', '游戏', '达州', '20');
INSERT INTO `users` VALUES ('21', 'second', '123', '男', '游戏', '成都', '20');
INSERT INTO `users` VALUES ('22', 'third', '123', '男', '音乐', '东莞', '单身');
INSERT INTO `users` VALUES ('23', 'fifth', '123', '女', '哼', '成都', null);
INSERT INTO `users` VALUES ('24', 'sixth', '123', '男', '哼哼', null, null);
INSERT INTO `users` VALUES ('25', 'seventh', '123', '男', '哼哼哼', null, null);
INSERT INTO `users` VALUES ('26', 'eighth', '123', '男', '哈', null, '哈哈哈');
INSERT INTO `users` VALUES ('27', 'ninth', '123', '男', '哈哈哈', '重庆', '呵呵');
