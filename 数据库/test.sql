/*
Navicat MySQL Data Transfer

Source Server         : linuxDateBase
Source Server Version : 50725
Source Host           : 192.168.6.128:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-12 11:15:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `account_balance` int(11) NOT NULL,
  `bank_card_num` int(11) NOT NULL COMMENT '银行卡数量',
  `account_code` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `user_account` (`user_id`),
  CONSTRAINT `user_account` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for `address_city`
-- ----------------------------
DROP TABLE IF EXISTS `address_city`;
CREATE TABLE `address_city` (
  `address_city` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of address_city
-- ----------------------------

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
  `owner_id` int(11) NOT NULL COMMENT '所有者ID',
  `bank_card_code` int(18) NOT NULL COMMENT '银行卡编码',
  `account_id` int(11) NOT NULL,
  PRIMARY KEY (`bank_card_id`,`bank_card_code`),
  KEY `bankcard_people_key` (`owner_id`),
  KEY `account_bankcard_key` (`account_id`),
  CONSTRAINT `account_bankcard_key` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `bankcard_people_key` FOREIGN KEY (`owner_id`) REFERENCES `people_card` (`people_card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bank_card
-- ----------------------------

-- ----------------------------
-- Table structure for `browse_record`
-- ----------------------------
DROP TABLE IF EXISTS `browse_record`;
CREATE TABLE `browse_record` (
  `browse_record_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`browse_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of browse_record
-- ----------------------------

-- ----------------------------
-- Table structure for `business`
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `business_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of business
-- ----------------------------

-- ----------------------------
-- Table structure for `favorites_record`
-- ----------------------------
DROP TABLE IF EXISTS `favorites_record`;
CREATE TABLE `favorites_record` (
  `favorites_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `create_time` date NOT NULL,
  `user_id` date NOT NULL,
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
  `goods_monthly_sales` int(11) NOT NULL,
  `goods_comment_volume` int(11) NOT NULL,
  `goods_favorite_volume` int(11) NOT NULL,
  `goods_page_views` int(11) NOT NULL,
  `goods_total_sales` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `goods_sku_id_list` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `goods_category_id` int(11) NOT NULL,
  `create_time` date NOT NULL,
  `goods_mian_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `store_goods_key` (`store_id`),
  KEY `goods_category_key` (`goods_category_id`),
  CONSTRAINT `goods_category_key` FOREIGN KEY (`goods_category_id`) REFERENCES `goods_category` (`goods_category_id`),
  CONSTRAINT `store_goods_key` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------

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

-- ----------------------------
-- Table structure for `goods_comment`
-- ----------------------------
DROP TABLE IF EXISTS `goods_comment`;
CREATE TABLE `goods_comment` (
  `comment_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment_txt` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `comment_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` date NOT NULL,
  KEY `user_comment_key` (`user_id`),
  KEY `goods_comment_key` (`goods_id`),
  CONSTRAINT `goods_comment_key` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `user_comment_key` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_comment
-- ----------------------------

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
  `goods_image_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_image_path` int(11) NOT NULL,
  `goods_image_type` int(11) NOT NULL,
  PRIMARY KEY (`goods_image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_images
-- ----------------------------

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

-- ----------------------------
-- Table structure for `goods_property_relate`
-- ----------------------------
DROP TABLE IF EXISTS `goods_property_relate`;
CREATE TABLE `goods_property_relate` (
  `goods_property_relate_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_property_name_id` int(11) NOT NULL,
  `goods_property_value_id` int(11) NOT NULL,
  PRIMARY KEY (`goods_property_relate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_property_relate
-- ----------------------------

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

-- ----------------------------
-- Table structure for `goods_skill_activity`
-- ----------------------------
DROP TABLE IF EXISTS `goods_skill_activity`;
CREATE TABLE `goods_skill_activity` (
  `goods_skill_activity_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `skill_start_time` date NOT NULL,
  `skill_end_time` date NOT NULL,
  `goods_skill_price` double NOT NULL,
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
  `goods_sku_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_now_price` double NOT NULL,
  `goods_old_price` double NOT NULL,
  `goods_stroage_balance` int(11) NOT NULL,
  `goods_stroage_sale_volume` int(11) NOT NULL,
  PRIMARY KEY (`goods_sku_id`),
  KEY `goods_spu_sku_key` (`goods_id`),
  CONSTRAINT `goods_spu_sku_key` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_sku
-- ----------------------------

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
  KEY `order_logistics_key` (`logistics_order_id`),
  CONSTRAINT `order_logistics_key` FOREIGN KEY (`logistics_order_id`) REFERENCES `logistics_order` (`logistics_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of logistics_distribution_info
-- ----------------------------

-- ----------------------------
-- Table structure for `logistics_order`
-- ----------------------------
DROP TABLE IF EXISTS `logistics_order`;
CREATE TABLE `logistics_order` (
  `logistics_order_id` int(11) NOT NULL,
  `logistics_company_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `order_id` int(11) NOT NULL,
  `shipping_address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `logistics_order_code` int(11) NOT NULL,
  PRIMARY KEY (`logistics_order_id`),
  KEY `logistics_order_code` (`logistics_order_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of logistics_order
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  `order_info_id` int(11) NOT NULL,
  `order_code` int(11) NOT NULL COMMENT '订单编号',
  `status` int(11) NOT NULL,
  `create_time` date NOT NULL,
  `logistics_info_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`order_code`),
  KEY `user_order` (`user_id`),
  KEY `logistics_order` (`logistics_info_id`),
  CONSTRAINT `logistics_order` FOREIGN KEY (`logistics_info_id`) REFERENCES `logistics_order` (`logistics_order_id`),
  CONSTRAINT `user_order` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_info_id` int(11) NOT NULL,
  `buyer_message` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of order_info
-- ----------------------------

-- ----------------------------
-- Table structure for `people_card`
-- ----------------------------
DROP TABLE IF EXISTS `people_card`;
CREATE TABLE `people_card` (
  `people_card_id` int(11) NOT NULL,
  `card_num` int(18) NOT NULL,
  `card_front_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `card_back_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `card_status` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`people_card_id`),
  KEY `people_card_user_key` (`user_id`),
  CONSTRAINT `people_card_user_key` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of people_card
-- ----------------------------

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
  `district` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `receiver_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `detailed_address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `post_code` int(11) NOT NULL,
  `receiver_phone` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `is_default` int(11) NOT NULL,
  PRIMARY KEY (`receiving_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of receiving_address
-- ----------------------------

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
-- Table structure for `shop_cart`
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart` (
  `shop_cart_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_num` int(11) NOT NULL,
  `goods_unit_price` double NOT NULL,
  `goods_total_price` double NOT NULL,
  `user_id` double NOT NULL,
  PRIMARY KEY (`shop_cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of shop_cart
-- ----------------------------

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `store_id` int(11) NOT NULL,
  `store_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `business_id` int(11) NOT NULL,
  `store_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `goods_category_id` int(11) NOT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of store
-- ----------------------------

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
  `create_time` int(11) NOT NULL,
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of trade
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(20) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `phone_num` int(11) NOT NULL,
  `email_num` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` date NOT NULL,
  `update_time` date NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_info_id` int(11) NOT NULL,
  `user_nickname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `real_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gender` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `birth_address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `live_address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_info_id`),
  KEY `user_info_forienkey` (`user_id`),
  CONSTRAINT `user_info_forienkey` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for `user_login_record`
-- ----------------------------
DROP TABLE IF EXISTS `user_login_record`;
CREATE TABLE `user_login_record` (
  `user_login_redord_id` int(11) NOT NULL,
  `login_time` date NOT NULL,
  `login_position` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `login_ip` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `login_status` int(11) NOT NULL,
  PRIMARY KEY (`user_login_redord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_login_record
-- ----------------------------

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
  CONSTRAINT `user_foreignkey` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
