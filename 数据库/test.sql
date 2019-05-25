/*
Navicat MySQL Data Transfer

Source Server         : linuxDateBase
Source Server Version : 50726
Source Host           : 192.168.6.128:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-05-25 11:05:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_balance` double(9,2) DEFAULT '0.00',
  `bank_card_num` int(11) DEFAULT '0' COMMENT '银行卡数量',
  `account_code` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `user_account` (`user_id`),
  CONSTRAINT `user_account` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=555556 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('111111', '0.00', '0', '18069863726', '444444', '0');
INSERT INTO `account` VALUES ('222222', '100.00', '2', '741852963', '-1419191891', '0');
INSERT INTO `account` VALUES ('333333', '0.00', '0', '74804762', '26740847', '0');
INSERT INTO `account` VALUES ('444444', '0.00', '0', '31248762', '26784213', '0');
INSERT INTO `account` VALUES ('555555', '0.00', '0', '26795910', '26795910', '0');

-- ----------------------------
-- Table structure for `address_province`
-- ----------------------------
DROP TABLE IF EXISTS `address_province`;
CREATE TABLE `address_province` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of address_province
-- ----------------------------
INSERT INTO `address_province` VALUES ('1', '安徽省');
INSERT INTO `address_province` VALUES ('2', '北京');
INSERT INTO `address_province` VALUES ('3', '重庆');
INSERT INTO `address_province` VALUES ('4', '福建省');
INSERT INTO `address_province` VALUES ('5', '甘肃省');
INSERT INTO `address_province` VALUES ('6', '广东省');
INSERT INTO `address_province` VALUES ('7', '广西壮族自治区');
INSERT INTO `address_province` VALUES ('8', '贵州省');
INSERT INTO `address_province` VALUES ('9', '海南省');
INSERT INTO `address_province` VALUES ('10', '河北省');
INSERT INTO `address_province` VALUES ('11', '河南省');
INSERT INTO `address_province` VALUES ('12', '黑龙江省');
INSERT INTO `address_province` VALUES ('13', '湖北省');
INSERT INTO `address_province` VALUES ('14', '湖南省');
INSERT INTO `address_province` VALUES ('15', '吉林省');
INSERT INTO `address_province` VALUES ('16', '江苏省');
INSERT INTO `address_province` VALUES ('17', '江西省');
INSERT INTO `address_province` VALUES ('18', '辽宁省');
INSERT INTO `address_province` VALUES ('19', '内蒙古自治区');
INSERT INTO `address_province` VALUES ('20', '宁夏回族自治区');
INSERT INTO `address_province` VALUES ('21', '青海省');
INSERT INTO `address_province` VALUES ('22', '山东省');
INSERT INTO `address_province` VALUES ('23', '山西省');
INSERT INTO `address_province` VALUES ('24', '陕西省');
INSERT INTO `address_province` VALUES ('25', '上海');
INSERT INTO `address_province` VALUES ('26', '四川省');
INSERT INTO `address_province` VALUES ('27', '天津');
INSERT INTO `address_province` VALUES ('28', '西藏自治区');
INSERT INTO `address_province` VALUES ('29', '新疆维吾尔自治区');
INSERT INTO `address_province` VALUES ('30', '云南省');
INSERT INTO `address_province` VALUES ('31', '浙江省');

-- ----------------------------
-- Table structure for `bank_card`
-- ----------------------------
DROP TABLE IF EXISTS `bank_card`;
CREATE TABLE `bank_card` (
  `bank_card_id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '所属银行名字',
  `bank_card_balance` int(11) NOT NULL COMMENT '银行卡余额',
  `owner_id` varchar(18) COLLATE utf8_unicode_ci NOT NULL COMMENT '所有者ID',
  `bank_card_code` varchar(19) COLLATE utf8_unicode_ci NOT NULL COMMENT '银行卡编码',
  `account_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`bank_card_id`,`bank_card_code`),
  KEY `account_bankcard_key` (`account_id`),
  KEY `bankCard_peopleCard` (`owner_id`),
  CONSTRAINT `bankCard_peopleCard` FOREIGN KEY (`owner_id`) REFERENCES `people_card` (`card_num`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bank_card
-- ----------------------------
INSERT INTO `bank_card` VALUES ('1', '中国建设银行', '9900', '410184199709210612', '6210812430001288063', '222222', '0');
INSERT INTO `bank_card` VALUES ('2', '中国银行', '10000', '410184199709210612', '6216611300009670358', '222222', '0');

-- ----------------------------
-- Table structure for `browse_record`
-- ----------------------------
DROP TABLE IF EXISTS `browse_record`;
CREATE TABLE `browse_record` (
  `browse_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `store_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`browse_record_id`),
  KEY `123456` (`goods_id`),
  KEY `654321` (`user_id`),
  CONSTRAINT `123456` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `654321` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of browse_record
-- ----------------------------
INSERT INTO `browse_record` VALUES ('3', '0', '520203559', '-1419191891', '2019-05-01');
INSERT INTO `browse_record` VALUES ('4', '0', '412135950', '-1419191891', '2019-05-01');
INSERT INTO `browse_record` VALUES ('5', '0', '520223814', '-1419191891', '2019-05-01');

-- ----------------------------
-- Table structure for `business`
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `business_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  PRIMARY KEY (`business_id`),
  KEY `user_business` (`user_id`),
  KEY `account_business` (`account_id`),
  KEY `store_business` (`store_id`),
  CONSTRAINT `account_business` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `store_business` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`),
  CONSTRAINT `user_business` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=333334 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('111111', '26740847', '0', '333333', '222222');
INSERT INTO `business` VALUES ('222222', '26784213', '0', '444444', '333333');
INSERT INTO `business` VALUES ('333333', '26795910', '0', '555555', '444444');

-- ----------------------------
-- Table structure for `favorites_record`
-- ----------------------------
DROP TABLE IF EXISTS `favorites_record`;
CREATE TABLE `favorites_record` (
  `favorites_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `create_time` date NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`favorites_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of favorites_record
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL,
  `goods_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `goods_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `store_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `goods_category_id` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0未上架1已上架2审核',
  `goods_monthly_sales` int(11) NOT NULL DEFAULT '0',
  `goods_comment_volume` int(11) NOT NULL DEFAULT '0',
  `goods_favorite_volume` int(11) NOT NULL DEFAULT '0',
  `goods_page_views` int(11) NOT NULL DEFAULT '0',
  `goods_total_sales` int(11) NOT NULL DEFAULT '0',
  `goods_sku_id_list` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goods_main_image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `store_goods_key` (`store_id`),
  KEY `goods_category_key` (`goods_category_id`),
  CONSTRAINT `goods_category_key` FOREIGN KEY (`goods_category_id`) REFERENCES `goods_category` (`goods_category_id`),
  CONSTRAINT `store_goods_key` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('412135950', 'adidas上衣', 'dfgdgdgd', '111111', '2019-04-12 00:00:00', '412135950', '0', '0', '0', '0', '0', '0', null, 'http://192.168.6.128:8088/filepath/imageadidas.jpg');
INSERT INTO `goods` VALUES ('520203559', '夏季最时尚潮牌男装', '........', '222222', '2019-05-20 20:35:59', '520203559', '0', '0', '0', '0', '0', '0', null, 'http://192.168.6.128:8088/filepath/520204828_520203559%E7%94%B7%E8%A3%85.jpg.jpg');
INSERT INTO `goods` VALUES ('520212230', '时尚小姐姐必备女装', '........', '222222', '2019-05-20 21:22:03', '520212230', '0', '0', '0', '0', '0', '0', null, 'http://192.168.6.128:8088/filepath/520212360_520212230%E5%A5%B3%E8%A3%85.jpg.jpg');
INSERT INTO `goods` VALUES ('520222848', '拉不坏的品牌旅行箱', '........', '333333', '2019-05-20 22:28:48', '520222848', '0', '0', '0', '0', '0', '0', null, 'http://192.168.6.128:8088/filepath/%E6%97%85%E8%A1%8C%E7%AE%B1.jpg.jpg');
INSERT INTO `goods` VALUES ('520223044', '韩版小恶魔帅气背包', '.....................', '333333', '2019-05-20 22:30:44', '520223044', '0', '0', '0', '0', '0', '0', null, 'http://192.168.6.128:8088/filepath/520223227_520223044%E7%94%B7%E5%8C%85.jpg.jpg');
INSERT INTO `goods` VALUES ('520223528', '苹果手机iphone8puls', '........', '444444', '2019-05-20 22:35:28', '520223528', '0', '0', '0', '0', '0', '0', null, 'http://192.168.6.128:8088/filepath/iphone8.jpg.jpg');
INSERT INTO `goods` VALUES ('520223814', '吃鸡不卡的联想笔记本ThinkPad', '............', '444444', '2019-05-20 22:38:14', '520223814', '0', '0', '0', '0', '0', '0', null, 'http://192.168.6.128:8088/filepath/520223910_520223814TB2Ltp6h80kpuFj.jpg');

-- ----------------------------
-- Table structure for `goods_category`
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category` (
  `goods_category_id` int(11) NOT NULL,
  `goods_family_id` int(11) NOT NULL,
  `goods_category_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`goods_category_id`),
  KEY `goods_category_family_key` (`goods_family_id`),
  CONSTRAINT `goods_category_family_key` FOREIGN KEY (`goods_family_id`) REFERENCES `goods_family` (`goods_family_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_category
-- ----------------------------
INSERT INTO `goods_category` VALUES ('412135950', '1', '休闲上衣');
INSERT INTO `goods_category` VALUES ('423205100', '1', '男鞋');
INSERT INTO `goods_category` VALUES ('519154635', '7', '智能手机');
INSERT INTO `goods_category` VALUES ('520195844', '1', '休闲男士衬衫');
INSERT INTO `goods_category` VALUES ('520203559', '1', '休闲男士衬衫');
INSERT INTO `goods_category` VALUES ('520212230', '2', '女士连衣裙');
INSERT INTO `goods_category` VALUES ('520222848', '5', '旅行箱');
INSERT INTO `goods_category` VALUES ('520223044', '5', '背包');
INSERT INTO `goods_category` VALUES ('520223528', '7', '苹果手机');
INSERT INTO `goods_category` VALUES ('520223814', '8', '笔记本电脑');

-- ----------------------------
-- Table structure for `goods_comment`
-- ----------------------------
DROP TABLE IF EXISTS `goods_comment`;
CREATE TABLE `goods_comment` (
  `comment_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment_text` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `comment_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `goods_comment_key` (`goods_id`),
  KEY `user_comment_key` (`user_id`),
  CONSTRAINT `goods_comment_key` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `user_comment_key` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_comment
-- ----------------------------
INSERT INTO `goods_comment` VALUES ('12', '412135950', '444444', 'cvsdfcv', 'dfd', '2019-04-16 20:50:35');

-- ----------------------------
-- Table structure for `goods_family`
-- ----------------------------
DROP TABLE IF EXISTS `goods_family`;
CREATE TABLE `goods_family` (
  `goods_family_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `goods_family_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_family_sequence` int(11) NOT NULL,
  PRIMARY KEY (`goods_family_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_family
-- ----------------------------
INSERT INTO `goods_family` VALUES ('男装', '1', '1');
INSERT INTO `goods_family` VALUES ('女装', '2', '1');
INSERT INTO `goods_family` VALUES ('内衣', '3', '1');
INSERT INTO `goods_family` VALUES ('鞋靴', '4', '2');
INSERT INTO `goods_family` VALUES ('箱包', '5', '2');
INSERT INTO `goods_family` VALUES ('配饰', '6', '2');
INSERT INTO `goods_family` VALUES ('手机', '7', '3');
INSERT INTO `goods_family` VALUES ('数码', '8', '3');
INSERT INTO `goods_family` VALUES ('家电', '9', '3');
INSERT INTO `goods_family` VALUES ('美妆', '10', '4');
INSERT INTO `goods_family` VALUES ('洗护', '11', '4');
INSERT INTO `goods_family` VALUES ('母婴', '12', '4');
INSERT INTO `goods_family` VALUES ('珠宝', '13', '5');
INSERT INTO `goods_family` VALUES ('手表', '14', '5');
INSERT INTO `goods_family` VALUES ('眼镜', '15', '5');
INSERT INTO `goods_family` VALUES ('运动', '16', '6');
INSERT INTO `goods_family` VALUES ('玩具', '17', '6');
INSERT INTO `goods_family` VALUES ('乐器', '18', '6');
INSERT INTO `goods_family` VALUES ('零食', '19', '7');
INSERT INTO `goods_family` VALUES ('生鲜', '20', '7');
INSERT INTO `goods_family` VALUES ('特产', '21', '7');
INSERT INTO `goods_family` VALUES ('礼品鲜花', '22', '8');
INSERT INTO `goods_family` VALUES ('宠物', '23', '8');
INSERT INTO `goods_family` VALUES ('图书', '24', '9');
INSERT INTO `goods_family` VALUES ('办公', '25', '9');
INSERT INTO `goods_family` VALUES ('床上用品', '26', '10');
INSERT INTO `goods_family` VALUES ('五金电子', '27', '10');

-- ----------------------------
-- Table structure for `goods_images`
-- ----------------------------
DROP TABLE IF EXISTS `goods_images`;
CREATE TABLE `goods_images` (
  `goods_image_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_sku_id` int(11) NOT NULL,
  `goods_image_path` text COLLATE utf8_unicode_ci,
  `goods_image_type` int(11) NOT NULL,
  PRIMARY KEY (`goods_image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_images
-- ----------------------------
INSERT INTO `goods_images` VALUES ('3', '520204828', 'http://192.168.6.128:8088/filepath/520204828_520203559男装.jpg.jpg', '0');
INSERT INTO `goods_images` VALUES ('4', '520205734', 'http://192.168.6.128:8088/filepath/520205734_520203559O1CN01NzxDZ1.jpg', '0');
INSERT INTO `goods_images` VALUES ('5', '520212360', 'http://192.168.6.128:8088/filepath/520212360_520212230女装.jpg.jpg', '0');
INSERT INTO `goods_images` VALUES ('6', '520221038', 'http://192.168.6.128:8088/filepath/520221038_520212230O1CN01nsV7J61.jpg', '0');
INSERT INTO `goods_images` VALUES ('7', '520223116', 'http://192.168.6.128:8088/filepath/520223116_520222848旅行箱.jpg.jpg', '0');
INSERT INTO `goods_images` VALUES ('8', '520223227', 'http://192.168.6.128:8088/filepath/520223227_520223044男包.jpg.jpg', '0');
INSERT INTO `goods_images` VALUES ('9', '520223615', 'http://192.168.6.128:8088/filepath/520223615_520223528iphone8.jpg.jpg', '0');
INSERT INTO `goods_images` VALUES ('10', '520223910', 'http://192.168.6.128:8088/filepath/520223910_520223814TB2Ltp6h80kpuFj.jpg', '0');

-- ----------------------------
-- Table structure for `goods_property_name`
-- ----------------------------
DROP TABLE IF EXISTS `goods_property_name`;
CREATE TABLE `goods_property_name` (
  `property_name_text` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `property_name_id` int(11) NOT NULL,
  `goods_category_id` int(11) NOT NULL,
  PRIMARY KEY (`property_name_id`),
  KEY `goods_category_property_key` (`goods_category_id`),
  CONSTRAINT `goods_category_property_key` FOREIGN KEY (`goods_category_id`) REFERENCES `goods_category` (`goods_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_property_name
-- ----------------------------
INSERT INTO `goods_property_name` VALUES ('颜色', '412165370', '412135950');
INSERT INTO `goods_property_name` VALUES ('内存', '519179280', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520201253', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520201431', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520201700', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520201854', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520202238', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520202400', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520204828', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520205340', '412135950');
INSERT INTO `goods_property_name` VALUES ('颜色', '520205734', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520207150', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520208570', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520212360', '412135950');
INSERT INTO `goods_property_name` VALUES ('颜色', '520221038', '412135950');
INSERT INTO `goods_property_name` VALUES ('颜色', '520223116', '412135950');
INSERT INTO `goods_property_name` VALUES ('尺寸', '520223227', '412135950');
INSERT INTO `goods_property_name` VALUES ('内存', '520223615', '412135950');
INSERT INTO `goods_property_name` VALUES ('硬盘', '520223910', '412135950');

-- ----------------------------
-- Table structure for `goods_property_relate`
-- ----------------------------
DROP TABLE IF EXISTS `goods_property_relate`;
CREATE TABLE `goods_property_relate` (
  `goods_property_relate_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_sku_id` int(11) NOT NULL,
  `goods_property_name_id` int(11) NOT NULL,
  `goods_property_value_id` int(11) NOT NULL,
  PRIMARY KEY (`goods_property_relate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_property_relate
-- ----------------------------
INSERT INTO `goods_property_relate` VALUES ('20', '520204828', '520204828', '520204828');
INSERT INTO `goods_property_relate` VALUES ('21', '520205734', '520205734', '520205734');
INSERT INTO `goods_property_relate` VALUES ('22', '520212360', '520212360', '520212360');
INSERT INTO `goods_property_relate` VALUES ('23', '520221038', '520221038', '520221038');
INSERT INTO `goods_property_relate` VALUES ('24', '520223116', '520223116', '520223116');
INSERT INTO `goods_property_relate` VALUES ('25', '520223227', '520223227', '520223227');
INSERT INTO `goods_property_relate` VALUES ('26', '520223615', '520223615', '520223615');
INSERT INTO `goods_property_relate` VALUES ('27', '520223910', '520223910', '520223910');

-- ----------------------------
-- Table structure for `goods_property_value`
-- ----------------------------
DROP TABLE IF EXISTS `goods_property_value`;
CREATE TABLE `goods_property_value` (
  `goods_property_name_id` int(11) NOT NULL,
  `property_value_id` int(11) NOT NULL,
  `property_value` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`property_value_id`),
  KEY `goods_property_value_key` (`goods_property_name_id`),
  CONSTRAINT `goods_property_value_key` FOREIGN KEY (`goods_property_name_id`) REFERENCES `goods_property_name` (`property_name_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_property_value
-- ----------------------------
INSERT INTO `goods_property_value` VALUES ('412165370', '412165370', '白色');
INSERT INTO `goods_property_value` VALUES ('519179280', '519179280', '32G');
INSERT INTO `goods_property_value` VALUES ('520201253', '520201253', 'L');
INSERT INTO `goods_property_value` VALUES ('520201431', '520201431', 'L');
INSERT INTO `goods_property_value` VALUES ('520201700', '520201700', '_L');
INSERT INTO `goods_property_value` VALUES ('520201854', '520201854', '_L');
INSERT INTO `goods_property_value` VALUES ('520202238', '520202238', '_L');
INSERT INTO `goods_property_value` VALUES ('520202400', '520202400', 'L');
INSERT INTO `goods_property_value` VALUES ('520204828', '520204828', '_L');
INSERT INTO `goods_property_value` VALUES ('520205340', '520205340', 'L');
INSERT INTO `goods_property_value` VALUES ('520205734', '520205734', '_红色');
INSERT INTO `goods_property_value` VALUES ('520207150', '520207150', 'L');
INSERT INTO `goods_property_value` VALUES ('520208570', '520208570', 'L');
INSERT INTO `goods_property_value` VALUES ('520212360', '520212360', '_M');
INSERT INTO `goods_property_value` VALUES ('520221038', '520221038', '_褐色');
INSERT INTO `goods_property_value` VALUES ('520223116', '520223116', '_黑色');
INSERT INTO `goods_property_value` VALUES ('520223227', '520223227', '_50cm');
INSERT INTO `goods_property_value` VALUES ('520223615', '520223615', '_64G');
INSERT INTO `goods_property_value` VALUES ('520223910', '520223910', '_800G');

-- ----------------------------
-- Table structure for `goods_skill_activity`
-- ----------------------------
DROP TABLE IF EXISTS `goods_skill_activity`;
CREATE TABLE `goods_skill_activity` (
  `goods_skill_activity_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `skill_start_time` date NOT NULL,
  `skill_end_time` date NOT NULL,
  `goods_skill_count` int(11) NOT NULL,
  PRIMARY KEY (`goods_skill_activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_skill_activity
-- ----------------------------

-- ----------------------------
-- Table structure for `goods_sku`
-- ----------------------------
DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE `goods_sku` (
  `goods_sku_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `goods_sku_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_now_price` double NOT NULL,
  `goods_old_price` double NOT NULL,
  `goods_stroage_balance` int(11) NOT NULL DEFAULT '0',
  `goods_stroage_sale_volume` int(11) NOT NULL DEFAULT '0',
  `sku_status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`goods_sku_id`),
  KEY `goods_spu_sku_key` (`goods_id`),
  CONSTRAINT `goods_spu_sku_key` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_sku
-- ----------------------------
INSERT INTO `goods_sku` VALUES ('520204828', '2019-05-20 20:48:28', '', '520203559', '39.9', '39.9', '20', '0', '0');
INSERT INTO `goods_sku` VALUES ('520205734', '2019-05-20 20:57:34', '', '520203559', '69.9', '69.9', '20', '0', '0');
INSERT INTO `goods_sku` VALUES ('520212360', '2019-05-20 21:23:06', '', '520212230', '199', '199', '10', '0', '0');
INSERT INTO `goods_sku` VALUES ('520221038', '2019-05-20 22:10:38', '', '520212230', '129', '129', '10', '0', '0');
INSERT INTO `goods_sku` VALUES ('520223116', '2019-05-20 22:31:16', '', '520222848', '399', '399', '5', '0', '0');
INSERT INTO `goods_sku` VALUES ('520223227', '2019-05-20 22:32:27', '', '520223044', '189', '189', '5', '0', '0');
INSERT INTO `goods_sku` VALUES ('520223615', '2019-05-20 22:36:15', '', '520223528', '3999', '3999', '6', '0', '0');
INSERT INTO `goods_sku` VALUES ('520223910', '2019-05-20 22:39:10', '', '520223814', '5999', '5999', '8', '0', '0');

-- ----------------------------
-- Table structure for `logistics_distribution_info`
-- ----------------------------
DROP TABLE IF EXISTS `logistics_distribution_info`;
CREATE TABLE `logistics_distribution_info` (
  `logistics_distribution_info_id` int(11) NOT NULL,
  `logistics_order_id` int(11) NOT NULL,
  `physical_status` int(11) NOT NULL,
  `create_time` date NOT NULL,
  `physical_distribution_spot` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `logistics_physical_distribution_info` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  KEY `order_logistics_key` (`logistics_order_id`),
  CONSTRAINT `order_logistics_key` FOREIGN KEY (`logistics_order_id`) REFERENCES `logistics_order` (`logistics_order_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of logistics_distribution_info
-- ----------------------------

-- ----------------------------
-- Table structure for `logistics_order`
-- ----------------------------
DROP TABLE IF EXISTS `logistics_order`;
CREATE TABLE `logistics_order` (
  `logistics_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `logistics_company_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `order_id` int(11) NOT NULL,
  `shipping_info_id` int(11) NOT NULL,
  `logistics_order_code` int(11) NOT NULL,
  PRIMARY KEY (`logistics_order_id`),
  KEY `logistics_order_code` (`logistics_order_code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of logistics_order
-- ----------------------------
INSERT INTO `logistics_order` VALUES ('8', '顺丰快递', '523213518', '524018120', '524018120');

-- ----------------------------
-- Table structure for `people_card`
-- ----------------------------
DROP TABLE IF EXISTS `people_card`;
CREATE TABLE `people_card` (
  `people_card_id` int(11) NOT NULL,
  `card_num` varchar(18) COLLATE utf8_unicode_ci NOT NULL,
  `card_front_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `card_back_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `card_status` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `card_num` (`card_num`),
  CONSTRAINT `people_card_user_key` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of people_card
-- ----------------------------
INSERT INTO `people_card` VALUES ('1', '410184199709210612', 'D:\\linux\\file\\image\\517219300_people_card2.png', 'D:\\linux\\file\\image\\517219300_people_card1.png', '0', '-1419191891');
INSERT INTO `people_card` VALUES ('4444444', '410184199709210612', '23477834789347', '53454544545454', '0', '444444');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` int(11) NOT NULL COMMENT '角色授权表',
  `token` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `permission_description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`permission_id`),
  KEY `permission_role` (`role_id`),
  CONSTRAINT `permission_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for `receiving_address`
-- ----------------------------
DROP TABLE IF EXISTS `receiving_address`;
CREATE TABLE `receiving_address` (
  `receiving_address_id` int(11) NOT NULL,
  `district` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `receiver_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `detailed_address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `post_code` int(11) NOT NULL,
  `receiver_phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `is_default` int(11) NOT NULL,
  PRIMARY KEY (`receiving_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of receiving_address
-- ----------------------------
INSERT INTO `receiving_address` VALUES ('514201332', '浙江省杭州市余杭区', '岳秋林', '金家渡铭雅苑', '123456', '18069863726', '-1419191891', '1');
INSERT INTO `receiving_address` VALUES ('514231137', '上海市市辖区静安区', '岳秋林', '东方明珠', '542143', '18703622974', '-1419191891', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `role_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_type_code` int(11) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `sales_activity`
-- ----------------------------
DROP TABLE IF EXISTS `sales_activity`;
CREATE TABLE `sales_activity` (
  `sales_activity_id` int(11) NOT NULL,
  PRIMARY KEY (`sales_activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sales_activity
-- ----------------------------

-- ----------------------------
-- Table structure for `shipping_info`
-- ----------------------------
DROP TABLE IF EXISTS `shipping_info`;
CREATE TABLE `shipping_info` (
  `shipping_info_id` int(11) NOT NULL,
  `shipper_name` varchar(255) NOT NULL,
  `shipping_address` varchar(255) NOT NULL,
  `shipper_phone` varchar(11) NOT NULL,
  PRIMARY KEY (`shipping_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipping_info
-- ----------------------------
INSERT INTO `shipping_info` VALUES ('524018120', '王牌飞行员', '浙江杭州', '123456');

-- ----------------------------
-- Table structure for `shop_cart`
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart` (
  `shop_cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_sku_id` int(11) NOT NULL,
  `goods_num` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`shop_cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of shop_cart
-- ----------------------------
INSERT INTO `shop_cart` VALUES ('2', '520204828', '1', '-1419191891');
INSERT INTO `shop_cart` VALUES ('3', '520204828', '1', '-1419191891');
INSERT INTO `shop_cart` VALUES ('4', '520212360', '1', '-1419191891');
INSERT INTO `shop_cart` VALUES ('5', '520223227', '1', '-1419191891');
INSERT INTO `shop_cart` VALUES ('6', '520204828', '1', '-1419191891');

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `store_id` int(11) NOT NULL,
  `store_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `store_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('111111', 'adidas', 'fsdfs', '1', '1');
INSERT INTO `store` VALUES ('222222', '品牌服装店', 'cxzx', '1', '1');
INSERT INTO `store` VALUES ('333333', '潮流箱包', 'cxvcv', '1', '1');
INSERT INTO `store` VALUES ('444444', '数码商城', 'xxdd', '1', '1');

-- ----------------------------
-- Table structure for `store_goods_category`
-- ----------------------------
DROP TABLE IF EXISTS `store_goods_category`;
CREATE TABLE `store_goods_category` (
  `goods_category_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `store_goods_category_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  PRIMARY KEY (`store_goods_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store_goods_category
-- ----------------------------

-- ----------------------------
-- Table structure for `trade`
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `trade_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `payer_account_id` int(11) NOT NULL,
  `receiver_account_id` int(11) NOT NULL,
  `trade_num` int(11) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of trade
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_photo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_info_id` int(11) NOT NULL,
  `user_nickname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `real_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `birth_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birth_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `live_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_info_forienkey` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('D:\\linux\\file\\image\\517201554_people_card1.png', '0', '余额不足', '岳秋林', '1', '2019-5-16', '江苏省泰州市靖江市', null, '-1419191891');
INSERT INTO `user_info` VALUES (null, '2323', '12223', '2332', '32', '2019-04-16', '434', '3434', '444444');

-- ----------------------------
-- Table structure for `user_login_record`
-- ----------------------------
DROP TABLE IF EXISTS `user_login_record`;
CREATE TABLE `user_login_record` (
  `login_time` date NOT NULL,
  `login_position` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `login_ip` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `login_status` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `user_login_record_id` int(11) NOT NULL,
  PRIMARY KEY (`user_login_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_login_record
-- ----------------------------

-- ----------------------------
-- Table structure for `user_order`
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `goods_sku_id` int(11) NOT NULL,
  `order_code` int(11) NOT NULL COMMENT '订单编号',
  `order_status` int(11) NOT NULL,
  `create_time` date NOT NULL,
  `logistics_order_id` int(11) DEFAULT '0',
  `trade_id` int(11) DEFAULT '0',
  `buyer_message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receive_address_id` int(11) DEFAULT NULL,
  `goods_num` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_order` (`user_id`),
  KEY `logistics_order` (`logistics_order_id`),
  CONSTRAINT `user_order` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_order
-- ----------------------------
INSERT INTO `user_order` VALUES ('523213518', '-1419191891', '520223227', '523213518', '3', '2019-05-23', '0', '0', '无', '514201332', '1');
INSERT INTO `user_order` VALUES ('524103930', '-1419191891', '520204828', '524103930', '0', '2019-05-24', '0', '0', '无', '514201332', '1');
INSERT INTO `user_order` VALUES ('524104233', '-1419191891', '520204828', '524104233', '2', '2019-05-24', '0', '0', '无', '514201332', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `user_foreignkey` (`user_id`),
  KEY `role_foreignkey` (`role_id`),
  CONSTRAINT `role_foreignkey` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_foreignkey` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `pay_password` int(6) DEFAULT NULL,
  `user_id` int(20) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `phone_num` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email_num` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` date NOT NULL,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('654321', '-1419191891', 'yueyueyue', 'c335e1fba4ee05b9a0ab4e3ed353cd15', '18703622974', '3033732533@qq.com', '2019-05-12', null);
INSERT INTO `users` VALUES ('0', '444444', '你', 'f7d5e8ab1ff502ae976550ece0552490', '18069863726', '33333@qq.com', '2019-03-14', '2019-03-15');
INSERT INTO `users` VALUES ('0', '26740847', '品牌服装店', '9354a9177bf60623ce83c33e8a0155f5', '18069863726', '3033732533@qq.com', '2019-05-19', null);
INSERT INTO `users` VALUES ('0', '26784213', '潮流箱包店', '8fd4cc3cb569fcf75c1979c82c1b2b1c', '18069863726', '3033732533@qq.com', '2019-05-19', null);
INSERT INTO `users` VALUES ('0', '26795910', '数码商城', '417014f0bcdca27b8bddde0674230468', '18069863726', '3033732533@qq.com', '2019-05-19', null);
