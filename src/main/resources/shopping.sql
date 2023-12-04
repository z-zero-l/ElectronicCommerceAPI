/*
 JookDB DUMP

 Source Server         : localhost_3306
 Source Server Type    : mysql
 Source Server Version : 8.0.21
 Source Host           : localhost:3306
 Source DBName         : shopping

 File Encoding         : UTF-8

 Date: 2023-12-04 15:24:06
*/

SET NAMES utf8mb4;
SET UNIQUE_CHECKS = 0;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `receiver` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收件人',
  `contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `province_code` int NOT NULL COMMENT '省份编码',
  `city_code` int NOT NULL COMMENT '城市编码',
  `district_code` int NOT NULL COMMENT '区县编码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `is_default` int NOT NULL DEFAULT '0' COMMENT '默认地址(0-非默认 1-是默认)',
  `detele_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除 1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户地址信息表';

INSERT INTO `t_address`(`id`,`user_id`,`receiver`,`contact`,`province_code`,`city_code`,`district_code`,`address`,`is_default`,`detele_flag`,`create_time`,`update_time`) VALUES (2,2,'Qw1ko','13562598415',0,0,0,'安徽',0,0,'2023-12-04 09:02:40','2023-12-04 09:03:17');
INSERT INTO `t_address`(`id`,`user_id`,`receiver`,`contact`,`province_code`,`city_code`,`district_code`,`address`,`is_default`,`detele_flag`,`create_time`,`update_time`) VALUES (5,1,'蔻蔻','18623955263',0,0,0,'江苏省南京市栖霞区羊山北路1号南京工业职业技术学院',0,0,'2023-12-04 09:02:40','2023-12-04 09:03:17');
INSERT INTO `t_address`(`id`,`user_id`,`receiver`,`contact`,`province_code`,`city_code`,`district_code`,`address`,`is_default`,`detele_flag`,`create_time`,`update_time`) VALUES (6,1,'蔻蔻','13198745896',0,0,0,'江苏省南京市玄武区',0,0,'2023-12-04 09:02:40','2023-12-04 09:03:17');
INSERT INTO `t_address`(`id`,`user_id`,`receiver`,`contact`,`province_code`,`city_code`,`district_code`,`address`,`is_default`,`detele_flag`,`create_time`,`update_time`) VALUES (7,22,'小姑凉','13165987452',0,0,0,'江苏省南京市栖霞区南京大学',0,0,'2023-12-04 09:02:40','2023-12-04 09:03:17');
INSERT INTO `t_address`(`id`,`user_id`,`receiver`,`contact`,`province_code`,`city_code`,`district_code`,`address`,`is_default`,`detele_flag`,`create_time`,`update_time`) VALUES (9,1,'施蔻蔻','13165983299',0,0,0,'江苏省南京市栖霞区南京大学',0,0,'2023-12-04 09:02:40','2023-12-04 09:03:17');

-- ----------------------------
-- Table structure for t_business
-- ----------------------------
DROP TABLE IF EXISTS `t_business`;
CREATE TABLE `t_business` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_account` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `business_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺名称',
  `business_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺联系方式',
  `business_owner` int NOT NULL COMMENT '店主id',
  `business_profile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '店铺简介',
  `business_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺头像',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除 1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='店铺信息表';

INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (1,'BN2023051315472001','111111','OLAY玉兰油','13165398562',1,null,'\/images\/busImg\/169487610683302.jpg',0,'2023-05-20 15:47:16','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (2,'BN2023051315472002','111111','sk-II','19562415621',2,'SK-II是1975年在日本创立的护肤品牌，是日本皮肤专家将尖端科技运用到护肤品开发中的完美结晶，是在东亚以及东南亚等地区深受欢迎的护肤品牌。','\/images\/busImg\/sk-II.png',0,'2023-05-13 15:47:20','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (3,'BN2023052913491603','666666','爱马仕','18526456661',3,'爱马仕（Hermès）是法国奢侈品品牌，由蒂埃利·爱马仕（Thierry Hermès）于1837年在法国巴黎创立。拥有皮具和马具、女士丝制品、男士丝制品、女士成衣、男士成衣、鞋履、腰带、帽子、手套、珠宝、钟表、香水、美妆、家具和生活艺术、餐瓷、petit h十六大工艺部门。','\/images\/busImg\/爱马仕.png',3,'2023-05-29 13:49:16','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (4,'BN2023052913502504','666666','百雀羚','18625655625',4,'百雀羚创立于1931年，是中国历史最悠久的著名护肤品牌。经过90余年的科研创新与突破，百雀羚探索出「东方草本」与「功效科技」的完美融合，用前沿科技激发草本卓效护肤潜能，重新定义草本护肤。','\/images\/busImg\/百雀羚.png',0,'2023-05-29 13:50:25','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (5,'BN2023052913512005','666666','迪奥','18562226541',5,'克里斯汀·迪奥（Christian Dior），简称迪奥（Dior或CD），是法国时尚消费品牌，隶属于酩悦·轩尼诗-路易·威登集团。迪奥主要经营男女手袋、女装、男装、男女鞋履、首饰、香水、化妆品、童装等高档消费品。','\/images\/busImg\/迪奥.png',0,'2023-05-29 13:51:20','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (6,'BN2023052913520706','666666','古驰','18596542513',6,'古驰(Gucci)，1921年创立于意大利佛罗伦萨，是全球奢侈品品牌之一，借由其独特的创意和革新，以及精湛的意大利工艺闻名于世。古驰隶属于开云集团 (Kering Group)。开云集团旗下拥有众多极具影响力的精品、运动及生活方式品牌，是时装与配饰行业的领军者。古驰的产品包括时装、皮具、皮鞋、手表、领带、丝巾、香水、家居用品及宠物用品等，中文译作古驰。','\/images\/busImg\/古驰.png',0,'2023-05-29 13:52:07','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (7,'BN2023052913525207','666666','海蓝之谜','18562547891',7,'海蓝之谜（LA MER）是雅诗兰黛集团旗下的面霜品牌，创始人是MaxHuber、马克·斯胡伯。','\/images\/busImg\/海蓝之谜.png',0,'2023-05-29 13:52:52','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (8,'BN2023052913535308','666666','韩后','18562562565',8,'韩后，国产护肤品牌，成立于2008年，隶属于广州安欣化妆品股份有限公司。在其“天然为本”品牌理念下，韩后已进入到了全渠道增长的快速上升期，而立体化营销更是韩后之所以置身国内美妆产品一线行列的制胜关键。','\/images\/busImg\/韩后.png',0,'2023-05-29 13:53:53','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (9,'BN2023052913543309','666666','韩束','18596524175',9,'韩束，创立于2003年，属于上海上美化妆品股份有限公司旗下品牌，2015年，韩束成为领先的国货化妆品品牌。2021年，韩束全新定位“科学抗衰”， 提出全新口号“为年轻提供一份底气”，品牌专注各年龄段亚洲女性不断变化的抗衰需求，填补国货市场科学抗衰产品的空白。 双菌发酵成分TIRACLE是韩束的自主核心成份，已应用于产品中。','\/images\/busImg\/韩束.png',0,'2023-05-29 13:54:33','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (10,'BN2023052913553510','666666','whoo后','19562541421',10,'WHOO后是来自韩国的韩国顶级宫廷护肤名品，是属于LG生活健康的著名化妆品牌。 2003于韩国上市，源自宫廷的独秘配方，让广大的韩国女性为之疯狂与倾心。','\/images\/busImg\/whoo后.png',0,'2023-05-29 13:55:35','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (11,'BN2023052913560711','666666','纪梵希','15263415242',11,'纪梵希（Givenchy）是法国的高奢时装品牌，隶属于法国LVMH集团，主营高级服装定制、成衣、鞋履、皮革制品及饰品，由于贝尔·德·纪梵希（Hubert James Taffin de Givenchy）以自己名字在1953年创立。','\/images\/busImg\/纪梵希.png',0,'2023-05-29 13:56:07','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (12,'BN2023052913570612','666666','科颜氏','18564256320',12,'Kiehl\'s（科颜氏），1851年创立于纽约曼哈顿，Kiehl\'s（科颜氏）揉和了美容、药草、药学及医学等专业领域的知识背景，逐渐建立了其独特的形象，进而发展成全方位的药局，并推出第一个以Kiehl\'s （科颜氏） 命名的保养品；到了1960年代早期，Kiehl\'s（科颜氏）的药剂师们有着丰富的经验和专业知识，开始根据顾客需求研发出不同系列且男女皆适用的保养品；','\/images\/busImg\/科颜氏.png',0,'2023-05-29 13:57:06','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (13,'BN2023052913574513','666666','兰蔻','18595556210',13,'兰蔻1935年诞生于法国，是由Armand Petitjean（阿曼达·珀蒂让）创办的品牌。作为全球知名的高端化妆品品牌，兰蔻涉足护肤、彩妆、香水等多个产品领域，主要面向教育程度、收入水平较高，年龄在25～40岁的成熟女性 。','\/images\/busImg\/兰蔻.png',0,'2023-05-29 13:57:45','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (14,'BN2023052913582714','666666','兰芝','19563210250',14,'兰芝（Laneige）是韩国最大化妆品集团爱茉莉太平洋旗下品牌之一。','\/images\/busImg\/兰芝.png',0,'2023-05-29 13:58:27','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (15,'BN2023052913592315','666666','欧莱雅','17565241520',15,'欧莱雅集团是美妆品行业中的领导者，经营范围遍及130多个国家和地区，在全球拥有283家分公司、42家工厂、100多个代理商，以及5万多名的员工，是总部设于法国的跨国公司，也是财富全球500强企业之一。','\/images\/busImg\/欧莱雅.png',0,'2023-05-29 13:59:23','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (16,'BN2023052914000916','666666','欧诗漫','18777524224',16,'欧诗漫（OSM）隶属于欧诗漫控股集团有限公司，创始于1967，专研珍珠养殖、珍珠科技等领域已逾半个世纪，主要经营化妆品、保健品以及珠宝首饰等系列产品，致力于成为珍珠美肤科研领域的先驱者。','\/images\/busImg\/欧诗漫.png',0,'2023-05-29 14:00:09','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (17,'BN2023052914004817','666666','珀莱雅','17542632562',17,'珀莱雅是始于中国放眼于世界的具有国际化前沿的化妆品品牌，18年间潜心探索肌肤新生科技，严格甄选优质原料，不断创新发现科技护肤技术，为所有消费者提供科学、安全、见效快的前沿科学肌肤解决方案。','\/images\/busImg\/珀莱雅.png',0,'2023-05-29 14:00:48','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (18,'BN2023052914020018','666666','圣罗兰','19462302301',18,'圣罗兰（YSL，Yves Saint Laurent）是法国奢侈品牌，由伊夫·圣·罗兰于1962年在法国创立，主要经营时装、美妆产品、香水、包具、眼镜，配饰等系列产品  。','\/images\/busImg\/圣罗兰.png',0,'2023-05-29 14:02:00','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (19,'BN2023052914024819','666666','丸美','19586445226',19,'丸美公司成立于2002年，专注于眼部护理和生物抗衰老的研究，  并连续8年获得中国化妆品细分品牌排行榜认证——抗衰老品类TOP1。 建设有广州·东京·上海研发三擎科研中心 ，12大研究平台，致力于以全球领先技术为基点，研发高品质产品。','\/images\/busImg\/丸美.png',0,'2023-05-29 14:02:48','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (20,'BN2023052914040020','666666','香奈儿','18566554231',20,'香奈儿（Chanel）是法国奢侈品品牌，由可可·香奈儿（Coco Chanel，原名Gabrielle Bonheur Chanel ，中文名加布里埃·香奈儿）于1910年在法国创立，拥有时尚精品及配饰、香水彩妆及护肤品以及腕表\/ 高级珠宝三个大类的产品。','\/images\/busImg\/香奈儿.png',0,'2023-05-29 14:04:00','1900-01-01 00:00:00');
INSERT INTO `t_business`(`id`,`business_account`,`password`,`business_name`,`business_phone`,`business_owner`,`business_profile`,`business_avatar`,`delete_flag`,`create_time`,`update_time`) VALUES (21,'BN2023052914051821','666666','雅诗兰黛','18563256425',22,'雅诗·兰黛(ESTĒE LAUDER) 全球最大的护肤、化妆品和香水公司之一，与其创始人同名。','\/images\/busImg\/雅诗兰黛 .png',0,'2023-05-29 14:05:18','1900-01-01 00:00:00');

-- ----------------------------
-- Table structure for t_carousel
-- ----------------------------
DROP TABLE IF EXISTS `t_carousel`;
CREATE TABLE `t_carousel` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `img_url` varchar(255) NOT NULL COMMENT '图片地址',
  `href_url` varchar(255) NOT NULL COMMENT '链接地址',
  `location` int NOT NULL DEFAULT '1' COMMENT '位置(1-首页)',
  `sort` int NOT NULL DEFAULT '0' COMMENT '展示顺序(越小越靠前)',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除 1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='轮播图';

INSERT INTO `t_carousel`(`id`,`img_url`,`href_url`,`location`,`sort`,`delete_flag`,`create_time`,`update_time`) VALUES (1,'1','1',1,0,0,'2023-12-04 09:13:43','2023-12-04 09:13:43');

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `product_id` int NOT NULL COMMENT '商品id',
  `spec_id` int NOT NULL COMMENT '商品规格id',
  `quantity` int NOT NULL COMMENT '数量',
  `join_price` double(10,2) NOT NULL COMMENT '加入时商品价格',
  `selected` int NOT NULL DEFAULT '0' COMMENT '是否选中(0-未选中 1-已选中)',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除 1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='购物车';

INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (2,2,2,0,2,0.0,0,0,'2023-05-17 08:31:19','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (3,21,1,0,2,0.0,0,0,'2023-05-30 23:24:52','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (5,21,13,0,1,0.0,0,0,'2023-05-31 08:43:17','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (6,1,54,54,2,0.0,0,0,'2023-06-01 15:24:37','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (9,1,20,82,1,0.0,0,0,'2023-06-07 01:48:00','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (13,1,52,138,1,0.0,0,0,'2023-06-07 16:07:41','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (14,5,19,19,4,0.0,0,0,'2023-06-07 16:17:05','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (15,1,30,30,1,0.0,0,0,'2023-09-15 20:50:39','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (17,22,30,30,1,0.0,0,0,'2023-09-15 22:19:09','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (18,22,30,96,2,0.0,0,0,'2023-09-15 22:19:10','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (19,22,25,88,1,0.0,0,0,'2023-09-18 13:20:30','1900-01-01 00:00:00');
INSERT INTO `t_cart`(`cart_id`,`user_id`,`product_id`,`spec_id`,`quantity`,`join_price`,`selected`,`delete_flag`,`create_time`,`update_time`) VALUES (20,1,23,23,1,0.0,0,0,'2023-09-18 14:05:24','1900-01-01 00:00:00');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `category_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cate_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `cate_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类图标',
  `cate_color` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '颜色标识',
  `parent_id` int NOT NULL DEFAULT '0' COMMENT '父级id(0-一级分类)',
  `cate_level` int NOT NULL DEFAULT '1' COMMENT '分类层级(1-一级分类 2-二级分类)',
  `sort` int NOT NULL COMMENT '排序指数(排序越小越靠前)',
  `is_recommend` int NOT NULL DEFAULT '0' COMMENT '是否推荐(1-首页推荐)',
  `cate_profile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类简介',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除 1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='分类';

INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (1,'香水',null,'',25,2,0,0,null,0,'2023-05-19 08:31:42','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (2,'口红',null,'',26,2,0,0,null,0,'2023-05-19 08:32:00','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (3,'眼霜',null,'',28,2,0,0,null,0,'2023-05-19 08:32:15','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (4,'面霜',null,'',28,2,0,0,null,0,'2023-05-29 15:35:20','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (5,'防晒',null,'',28,2,0,0,null,0,'2023-05-29 15:35:41','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (6,'洁面',null,'',28,2,0,0,null,0,'2023-05-29 15:36:25','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (7,'面膜',null,'',28,2,0,0,null,0,'2023-05-29 15:36:36','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (8,'精华水',null,'',28,2,0,0,null,0,'2023-05-29 15:36:51','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (9,'化妆刷',null,'',26,2,0,0,null,0,'2023-05-29 15:37:18','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (10,'精华液',null,'',28,2,0,0,null,0,'2023-05-29 15:40:28','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (11,'腮红',null,'',26,2,0,0,null,0,'2023-05-29 15:40:46','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (12,'礼盒',null,'',28,2,0,0,null,0,'2023-05-29 15:41:08','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (13,'气垫',null,'',26,2,0,0,null,0,'2023-05-29 15:41:29','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (15,'唇釉',null,'',26,2,0,0,null,0,'2023-05-29 15:41:56','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (16,'粉底液',null,'',26,2,0,0,null,0,'2023-05-29 15:42:22','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (17,'精华',null,'',28,2,0,0,null,0,'2023-05-29 15:42:47','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (19,'精华乳',null,'',28,2,0,0,null,0,'2023-05-29 15:48:24','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (20,'散粉',null,'',26,2,0,0,null,0,'2023-05-29 18:20:21','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (22,'泥膜',null,'',27,2,0,0,null,0,'2023-05-30 22:45:26','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (24,'补水面膜',null,'',28,2,0,0,null,0,'2023-09-15 10:05:49','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (25,'香氛',null,'',0,1,0,0,null,0,'2023-09-15 10:05:49','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (26,'彩妆',null,'',0,1,0,0,null,0,'2023-09-15 10:05:49','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (27,'清洁',null,'',0,1,0,0,null,0,'2023-09-15 10:05:49','2023-09-15 10:10:49');
INSERT INTO `t_category`(`category_id`,`cate_name`,`cate_icon`,`cate_color`,`parent_id`,`cate_level`,`sort`,`is_recommend`,`cate_profile`,`delete_flag`,`create_time`,`update_time`) VALUES (28,'护肤',null,'',0,1,0,0,null,0,'2023-09-15 10:05:49','2023-09-15 10:10:49');

-- ----------------------------
-- Table structure for t_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `product_id` int NOT NULL COMMENT '商品id',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除 1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='收藏';

INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (1,1,1,0,'2023-05-30 11:24:32','2023-12-04 09:48:24');
INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (2,2,2,0,'2023-05-30 11:24:57','2023-12-04 09:48:24');
INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (3,3,3,0,'2023-05-30 11:25:06','2023-12-04 09:48:24');
INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (4,4,4,0,'2023-05-30 11:25:13','2023-12-04 09:48:24');
INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (5,1,2,0,'2023-05-30 16:16:37','2023-12-04 09:48:24');
INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (7,1,9,0,'2023-06-01 15:04:44','2023-12-04 09:48:24');
INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (8,1,41,0,'2023-06-01 15:11:46','2023-12-04 09:48:24');
INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (9,1,20,0,'2023-06-07 16:03:24','2023-12-04 09:48:24');
INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (10,1,52,0,'2023-06-07 16:03:41','2023-12-04 09:48:24');
INSERT INTO `t_collect`(`id`,`user_id`,`product_id`,`delete_flag`,`create_time`,`update_time`) VALUES (13,1,56,0,'2023-09-18 14:22:27','2023-12-04 09:48:24');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `product_id` int NOT NULL COMMENT '商品id',
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `to_comment_id` int NOT NULL DEFAULT '0' COMMENT '回复评论id(0-非回复)',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除 1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='评论';

INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (1,1,1,'已收到用了几天感觉很好，细腻光滑遮暇防晒效果非常好',0,0,'2023-05-19 08:32:55','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (2,2,2,'买的情人节礼物哈哈，物流特别快，顺丰，下单很快就收到了，还用一个红色礼盒装起来的，很漂亮！非常适合送人！送的小样也不错',0,0,'2023-05-19 08:33:26','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (3,3,3,'女票说是正品 并且当晚就说提亮肤色了 虽然不懂是不送真的好用 但是开心就好 要是包装盒上的生产日期不是用台湾的格式就更好了',0,0,'2023-05-30 11:05:57','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (4,4,4,'很好 肤质改善情况：很好 吸收效果：很好 保湿效果：很好',0,0,'2023-05-30 11:07:39','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (5,5,5,'油皮也爱的面霜，和神仙水搭配，简直夏日必备神器，永远的选择、非常nice',0,0,'2023-05-30 11:09:12','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (6,6,17,'很大气很用心的包装，质地像乳液一样，好推开，不油腻oo大品牌值得信赖，果然贵有贵的道理。包装精致，而且味道很好闻',0,0,'2023-05-30 11:09:57','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (7,7,23,'淡淡的玫瑰花香味很治愈，用起来的时候会觉得很放松，抗老效果好，紧致肌肤。',0,0,'2023-05-30 11:10:52','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (8,8,22,'yi送了一些小样，今天的快乐是兰蔻给的，每次需要涂润唇膏再涂口红！礼盒心情都是美美的！太好看了真的很爱，官方旗舰店买也太香了吧',0,0,'2023-05-30 11:12:36','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (9,9,8,'颜色特别自然，非常接近唇色',0,0,'2023-05-30 11:13:06','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (10,10,29,'Dior迪奥烈艳蓝金唇膏套装 花漾新年限量版 #999#720，现已收货，老婆很喜欢，作为新年礼物刚刚好。色号什么的都挺好，有需要的小伙伴们可以入手。',0,0,'2023-05-30 11:13:56','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (11,11,33,'整体评价：喜欢颜色，但是味道很奇怪，像是小时候妈**口红，没什么香味，一股油脂味道，但日期又比较新鲜，有点奇怪。 保湿效果：滋润不拔干 上嘴效果：颜色自然适合素颜',0,0,'2023-05-30 11:15:06','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (12,12,38,'涂上润润的，日常上班也可以用，不错呦！颜色比较偏粉色，要是能再红一点就好了，我比较喜欢红色。',0,0,'2023-05-30 11:15:49','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (13,13,6,'包装很好，第二天就送到了，本人一到夏天脸上就变成大油田，用其它水乳都感觉油腻，换了这个skll用了，感觉到很好用，用了有点油腻，几分钟后吸收了，脸就变得滑滑的，睡醒了起床脸没有这么油，用了白天在厨房里干活也没有这么油了，一千多一瓶，用了，好用，值得推荐',0,0,'2023-06-05 10:35:10','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (14,14,7,'整个家族show~mini可爱的小刷刷，包装也很精美，送给自己的新年礼物，开熏',0,0,'2023-06-05 10:39:54','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (15,15,8,'颜色特别自然，非常接近唇色',0,0,'2023-06-05 10:40:15','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (16,16,9,'整体评价：好 包装与外观：好看 持久情况：持久 上妆效果：是想象中的样子，氛围感气质腮红 我的肤质：大干皮',0,0,'2023-06-05 10:41:02','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (17,17,10,'喜欢爱马仕的包装，是给妈妈母亲节的私人订制。物流发货都很快，周五下的单，周日母亲节正好收到了。香水瓶是渐变的浅绿色，尼罗河的香味是那种很淡雅的，虽然持久性不是很强，大概在半天左右，但是还是很爱很爱，妈妈拿到后很惊喜。还附送了两小支香水。赞哦！',0,0,'2023-06-05 10:41:56','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (18,18,11,'包装完整，物流到国内就很快了，耐心等，味道好闻，很清爽，适合夏天',0,0,'2023-06-05 10:42:37','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (19,19,12,'第一次尝试迪奥新品睡莲洁面，真的有被大牌洗面奶震惊到！首先味道真的很好闻，很淡雅的香味！而且使用感也很舒服，很少量的洗面奶加点水用手揉搓就有绵密的泡沫，洗完不紧绷不假滑，对于我这个干皮来说洗完很干净的同时也很湿润，清洁力和保湿度都做的很好，日常涂个防晒和口红，没有卸妆直接用的睡莲洁面，也完全ok！',0,0,'2023-06-05 10:43:17','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (20,20,13,'母亲节送婆婆的 包装挺好 星光礼盒很漂亮 两个色号都比较经典不怕踩雷 哑光确实比丝绒润 更适合长辈 重点是婆婆喜欢',0,0,'2023-06-05 10:44:07','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (21,21,14,'整体评价：妆效不错，比较轻薄，遮瑕力也可以。送的东西很多，还是在天猫旗舰店买比去专柜划算。我选的简单包装都是满满的仪式感',0,0,'2023-06-05 10:45:10','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (22,10,1,'细腻光滑遮暇防晒效果非常好，真不错！',0,0,'2023-06-06 12:53:56','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (23,2,1,'使用的感觉特别好',0,0,'2023-06-06 12:54:04','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (24,1,2,'很久没买了，用来用去还是这个比较润些吧感觉！',0,0,'2023-06-06 12:55:26','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (25,10,2,'快递也快，包装很漂亮',0,0,'2023-06-06 12:55:37','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (26,2,3,'虽然不懂是不送真的好用 但是开心就好',0,0,'2023-06-06 12:59:41','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (27,2,5,'和神仙水搭配，简直夏日必备神器，永远的选择、非常nice',0,0,'2023-06-06 12:59:51','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (28,3,17,'质地像乳液一样，好推开，不油腻oo大品牌值得信赖',0,0,'2023-06-06 13:00:19','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (29,3,4,'很好 吸收效果：很好 保湿效果：很好',0,0,'2023-06-06 13:00:26','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (30,4,23,'用起来的时候会觉得很放松，抗老效果好，紧致肌肤。',0,0,'2023-06-06 13:00:43','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (31,4,38,'日常上班也可以用，不错呦！',0,0,'2023-06-06 13:00:51','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (32,4,5,'和神仙水搭配，简直夏日必备神器，永远的选择、非常nice',0,0,'2023-06-06 13:01:09','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (33,5,22,'今天的快乐是兰蔻给的',0,0,'2023-06-06 13:01:30','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (34,5,6,'脸就变得滑滑的，睡醒了起床脸没有这么油，',0,0,'2023-06-06 13:01:50','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (35,6,8,'颜色特别自然，非常接近唇色',0,0,'2023-06-06 13:02:14','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (36,6,9,'好看持久',0,0,'2023-06-06 13:02:21','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (37,7,29,'作为新年礼物刚刚好。色号什么的都挺好，有需要的小伙伴们可以入手。',0,0,'2023-06-06 13:02:39','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (38,7,8,'颜色特别自然，非常接近唇色',0,0,'2023-06-06 13:03:02','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (39,8,33,'特别好，值得购买',0,0,'2023-06-06 13:03:23','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (40,8,9,'特别好，值得购买',0,0,'2023-06-06 13:03:41','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (41,9,38,'特别好，值得购买',0,0,'2023-06-06 13:03:55','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (42,9,10,'特别好，值得购买',0,0,'2023-06-06 13:04:03','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (43,10,11,'特别好，值得购买',0,0,'2023-06-06 13:04:18','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (45,11,2,'特别好，值得购买',0,0,'2023-06-06 13:04:57','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (46,12,3,'特别好，值得购买',0,0,'2023-06-06 13:05:09','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (47,12,13,'特别好，值得购买',0,0,'2023-06-06 13:05:17','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (48,13,4,'特别好，值得购买',0,0,'2023-06-06 13:05:33','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (49,13,14,'特别好，值得购买',0,0,'2023-06-06 13:05:40','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (50,7,30,'符合商品描述',0,0,'2023-09-15 20:51:43','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (51,1,30,'润而不腻，不油',0,0,'2023-09-15 21:10:30','1900-01-01 00:00:00');
INSERT INTO `t_comment`(`comment_id`,`user_id`,`product_id`,`comment_content`,`to_comment_id`,`delete_flag`,`create_time`,`update_time`) VALUES (52,1,30,'不油腻，肤感很好，不泛红',0,0,'2023-09-15 21:46:27','1900-01-01 00:00:00');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `payment` decimal(20,2) NOT NULL COMMENT '实付金额',
  `consignee` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人联系方式',
  `province_code` int NOT NULL COMMENT '收货省份编码',
  `city_code` int NOT NULL COMMENT '收货城市编码',
  `district_code` int NOT NULL COMMENT '收货区县编码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货详细地址',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='订单';

INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (1,1,'DD202305190838561401',500.00,'123','18576953654',0,0,0,'南京',0,'2023-05-19 08:38:56','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (2,1,'DD202305301011252302',650.00,'coco','18325649653',0,0,0,'上海',0,'2023-05-30 10:11:25','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (3,1,'DD202305301027233603',555.00,'666','18236545526',0,0,0,'南京',0,'2023-05-30 10:27:23','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (4,4,'DD202305301029214204',666.00,'先生','13562549952',0,0,0,'南京',0,'2023-05-30 10:29:21','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (5,5,'DD202305301030215205',666.00,'奥特曼','14562359852',0,0,0,'南京',0,'2023-05-30 10:30:21','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (6,6,'DD202305301031106206',666.00,'111','18564526552',0,0,0,'南京',0,'2023-05-30 10:31:10','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (7,7,'DD202305301031567207',666.00,'aaa','17526459562',0,0,0,'南京',0,'2023-05-30 10:31:56','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (8,8,'DD202305301033508508',666.00,'123aaa','15624623555',0,0,0,'南京',0,'2023-05-30 10:33:50','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (9,9,'DD202305301034529409',666.00,'女生','15265553214',0,0,0,'南京',0,'2023-05-30 10:34:52','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (10,10,'DD202305301035290210',666.00,'女士','18956662532',0,0,0,'南京',0,'2023-05-30 10:35:29','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (11,11,'DD202306051458491211',666.00,'女士','15261536642',0,0,0,'南京',0,'2023-06-05 14:58:49','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (12,12,'DD202306051500342212',666.00,'女士','18325649652',0,0,0,'南京',0,'2023-06-05 15:00:34','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (13,13,'DD202306051501473113',666.00,'女士','18425626331',0,0,0,'南京',0,'2023-06-05 15:01:47','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (14,14,'DD202306051502324614',666.00,'女士','19652364266',0,0,0,'南京',0,'2023-06-05 15:02:34','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (15,15,'DD202306051503155515',666.00,'女士','15962456325',0,0,0,'南京',0,'2023-06-05 15:03:15','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (16,16,'DD202306051504006216',666.00,'女士','18565245552',0,0,0,'南京',0,'2023-06-05 15:04:00','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (17,17,'DD202306051504427917',666.00,'女士','15654558999',0,0,0,'南京',0,'2023-06-05 15:04:42','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (18,18,'DD202306051505258218',666.00,'女士','15623548852',0,0,0,'南京',0,'2023-06-05 15:05:25','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (19,19,'DD202306051506079119',666.00,'女士','15965425841',0,0,0,'南京',0,'2023-06-05 15:06:07','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (20,20,'DD202306051506400420',666.00,'女士','19526456284',0,0,0,'南京',0,'2023-06-05 15:06:40','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (21,21,'DD202306051507501621',666.00,'女士','13165398546',0,0,0,'南京',0,'2023-06-05 15:07:50','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (22,1,'DD16947822509351932',678.00,'宇航员','13158695869',0,0,0,'江苏省南京市栖霞区羊山北路1号南京工业职业技术大学',0,'2023-09-15 20:50:50','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (24,22,'DD16947876315052271',1017.00,'小姑凉','13165987452',0,0,0,'江苏省南京市栖霞区南京大学',0,'2023-09-15 22:20:31','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (25,1,'DD16950143118791383',1900.00,'蔻蔻','18623955263',0,0,0,'江苏省南京市栖霞区羊山北路1号南京工业职业技术学院',0,'2023-09-18 13:18:31','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (26,22,'DD16950144142742250',339.00,'小姑凉','13165987452',0,0,0,'江苏省南京市栖霞区南京大学',0,'2023-09-18 13:20:14','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (27,22,'DD16950144358742271',579.00,'小姑凉','13165987452',0,0,0,'江苏省南京市栖霞区南京大学',0,'2023-09-18 13:20:35','2023-09-18 15:54:38');
INSERT INTO `t_order`(`id`,`user_id`,`order_id`,`payment`,`consignee`,`phone`,`province_code`,`city_code`,`district_code`,`address`,`delete_flag`,`create_time`,`update_time`) VALUES (28,1,'DD16950236782361341',1900.00,'蔻蔻','18623955263',0,0,0,'江苏省南京市栖霞区羊山北路1号南京工业职业技术学院',0,'2023-09-18 15:54:38','2023-09-18 15:54:38');

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` int NOT NULL COMMENT '订单id',
  `product_id` int NOT NULL COMMENT '商品id',
  `amount` int NOT NULL COMMENT '数量',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `spec_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品规格名称',
  `product_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品详情图片',
  `price` decimal(10,2) NOT NULL COMMENT '实付款',
  `freight` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '运费',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  `cancel_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单取消原因',
  `status` int NOT NULL DEFAULT '0' COMMENT '订单项状态(0-待付款 1-待发货 2-待收货 3-待评价 4-已完成 5-已取消)',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除 1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `close_type` int DEFAULT NULL COMMENT '订单关闭类型(0-超时未支付 1-买家取消 2-退款关闭)',
  `cancel_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `send_time` datetime DEFAULT NULL COMMENT '发货时间',
  `receipt_time` datetime DEFAULT NULL COMMENT '收货时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='订单详情';

INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (1,1,1,1,'sk-II防晒','优品','',749.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-21 10:03:12','2023-05-30 10:36:12',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (2,2,5,1,'sk-II面霜','优品','',979.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-23 10:03:22','2023-05-30 10:10:24',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (3,3,17,1,'兰蔻防晒','优品','',949.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,'2023-06-06 22:11:45',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (4,4,23,1,'兰蔻面霜','优品','',1549.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-30 10:40:31','2023-05-30 10:40:34',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (5,5,22,1,'兰蔻口红','优品','',319.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-30 10:41:22','2023-05-30 10:41:25',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (6,6,8,1,'爱马仕口红','优品','',589.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-30 10:42:25','2023-05-30 10:44:45',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (7,7,29,1,'迪奥口红','优品','',380.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-30 10:43:23','2023-05-30 10:43:25',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (8,8,33,1,'古驰口红','优品','',239.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-30 10:45:19',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (9,9,38,1,'Whoo后口红','优品','',315.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-30 10:48:57','2023-05-30 10:49:00',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (10,4,38,1,'Whoo后口红','优品','',315.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-30 11:22:00','2023-05-30 11:22:03',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (11,10,1,1,'sk-II防晒','优品','',749.00,0.0,'',null,1,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (12,2,1,1,'sk-II防晒','优品','',749.00,0.0,'',null,1,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:08:21','2023-06-06 22:18:18',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (13,11,2,1,'sk-II洁面乳','优品','',500.00,0.0,'',null,1,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:10:04',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (14,12,3,1,'sk-II精华液','优品','',1260.00,0.0,'',null,1,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:10:35',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (15,13,4,1,'sk-II面膜','优品','',1190.00,0.0,'',null,1,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:11:12',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (16,14,5,1,'sk-II面霜','优品','',980.00,0.0,'',null,1,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:12:01',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (17,15,6,1,'sk-II神仙水','优品','',1690.00,0.0,'',null,1,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:12:44',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (18,16,7,1,'爱马仕化妆刷','优品','',680.00,0.0,'',null,1,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:13:17',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (19,17,8,1,'爱马仕口红','优品','',589.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:13:49',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (20,18,9,1,'爱马仕腮红','优品','',684.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:14:16',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (21,19,10,1,'爱马仕香水','优品','',640.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:14:45',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (22,20,11,1,'爱马仕香水口红礼盒','优品','',1250.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:15:27',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (23,21,12,1,'迪奥洁面乳','优品','',460.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 11:16:08','2023-06-06 11:16:09',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (24,1,2,1,'sk-II洁面乳','优品','',500.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 12:40:28','2023-06-06 12:40:30',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (25,2,3,1,'sk-II精华液','优品','',1260.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,'2023-06-06 22:13:36',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (26,3,4,1,'sk-II面膜','优品','',1190.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,'2023-06-06 22:14:49',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (27,4,5,1,'sk-II面霜','优品','',980.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (28,5,6,1,'sk-II神仙水','优品','',1690.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (29,6,7,1,'爱马仕化妆刷','优品','',680.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (30,7,8,1,'爱马仕口红','优品','',589.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (31,8,9,1,'爱马仕腮红','优品','',684.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (32,9,10,1,'爱马仕香水','优品','',640.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-06-06 12:45:15','2023-06-06 12:45:18',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (33,10,11,1,'爱马仕香水口红礼盒','优品','',1250.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (34,11,12,1,'迪奥洁面乳','优品','',460.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (35,12,13,1,'迪奥礼盒','优品','',1460.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (36,13,14,1,'迪奥气垫','优品','',370.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (37,22,30,1,'olay玉兰油面霜','塑颜空气感凝霜100g 轻盈','',339.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,'2023-09-15 20:51:01',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (38,22,30,1,'olay玉兰油面霜','塑颜空气感凝霜100g 保湿','',339.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,'2023-09-15 20:51:04',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (39,23,30,1,'olay玉兰油面霜','塑颜空气感凝霜100g 轻盈','',339.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-09-15 22:20:21',null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (42,25,54,2,'香奈儿精华液','奢华精萃密集焕活精华','',950.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,'2023-05-24 16:10:15','2023-06-01 16:08:03',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (43,26,30,1,'olay玉兰油面霜','塑颜空气感凝霜100g 轻盈','',339.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,'2023-09-18 13:24:12',null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (44,27,25,1,'兰蔻香水','max款60ml','',579.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);
INSERT INTO `t_order_item`(`id`,`order_id`,`product_id`,`amount`,`product_name`,`spec_name`,`product_image`,`price`,`freight`,`remark`,`cancel_reason`,`status`,`delete_flag`,`create_time`,`update_time`,`close_type`,`cancel_time`,`pay_time`,`send_time`,`receipt_time`,`finish_time`) VALUES (45,28,52,1,'香奈儿礼盒','炫亮魅力奢华规格','',1900.00,0.0,'',null,2,0,'2023-12-04 14:49:41','1900-01-01 00:00:00',null,null,null,null,null,null);

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `business_id` int NOT NULL COMMENT '所属店铺',
  `cate_sec_id` int NOT NULL DEFAULT '0' COMMENT '二级分类id',
  `product_profile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品简介',
  `product_cover` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品封面图片',
  `freight` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '运费',
  `product_status` int NOT NULL DEFAULT '0' COMMENT '商品状态(0-待上架 1-已上架 2-已下架)',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除，1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品表';

INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (1,'sk-II防晒',2,5,'SK-II轻润净透空气CC霜防晒霜遮瑕亲肤保湿skll sk2','',0.0,2,0,'2023-05-19 08:40:30','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (2,'sk-II洁面乳',2,6,'SK-II舒透洁面洗面奶温和洁净舒缓肌肤保湿skll sk2','',0.0,1,0,'2023-05-19 09:25:31','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (3,'sk-II精华液',2,10,'SK-II小灯泡美白精华修护精华液淡斑改善肌肤skllsk2','',0.0,1,0,'2023-05-28 19:24:36','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (4,'sk-II面膜',2,7,'SK-II前男友面膜贴片面膜10片保湿舒缓保湿sk2 skll','',0.0,1,0,'2023-05-28 21:24:59','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (5,'sk-II面霜',2,4,'SK-II大红瓶面霜50g护肤品抗皱紧致补水保湿skll sk2','',0.0,2,0,'2023-05-28 21:25:38','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (6,'sk-II神仙水',2,8,'SK-II神仙水精华液面部精华礼盒修护紧致保湿skll sk2','',0.0,1,0,'2023-05-23 01:12:37','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (7,'爱马仕化妆刷',3,9,'Hermes爱马仕唇刷口红刷便携彩妆工具化妆刷','',0.0,1,0,'2023-05-29 14:47:50','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (8,'爱马仕口红',3,2,'Hermes爱马仕瑰丽粉红系列瑰丽唇膏润唇礼物49','',0.0,1,0,'2023-05-29 14:51:09','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (9,'爱马仕腮红',3,11,'Hermes爱马仕瑰丽粉红系列丝滑腮红彩妆礼物','',0.0,1,0,'2023-05-29 14:52:25','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (10,'爱马仕香水',3,1,'Hermes爱马仕尼罗河花园香水清新中性香礼物香氛','',0.0,1,0,'2023-05-29 14:53:05','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (11,'爱马仕香水口红礼盒',3,12,'Hermes爱马仕大地香水润唇膏套装淡香氛唇膏礼盒','',0.0,1,0,'2023-05-29 14:53:54','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (12,'迪奥洁面乳',5,6,'全新Dior迪奥睡莲洁面深彻净洁舒缓保湿绵密亲肤','',0.0,1,0,'2023-05-29 14:54:05','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (13,'迪奥礼盒',5,12,'Dior迪奥臻选彩护礼盒 睡莲洁面唇膏粉底液套组','',0.0,1,0,'2023-05-29 14:55:45','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (14,'迪奥气垫',5,13,'Dior迪奥锁妆凝脂恒久气垫粉底控油持久遮瑕SPF','',0.0,1,0,'2023-05-29 14:56:06','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (15,'迪奥气泡水',5,8,'Dior迪奥花秘瑰萃玫瑰微凝珠精华水气泡水 保湿','',0.0,1,0,'2023-05-29 14:56:33','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (16,'兰蔻唇釉',13,15,'\r\n兰蔻菁纯小蛮腰柔雾唇釉持久显色雾面唇釉口红196','',0.0,1,0,'2023-05-29 14:57:00','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (17,'兰蔻防晒',13,5,'兰蔻菁纯防晒高倍隔离霜SPF50+长效保湿防晒乳UV','',0.0,1,0,'2023-05-29 14:57:42','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (18,'兰蔻粉底液',13,16,'兰蔻持妆粉底液 混油皮不闷痘不脱妆 持久控油','',0.0,1,0,'2023-05-29 14:59:07','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (19,'兰蔻洁面乳',13,6,'兰蔻极光洁面乳 氨基酸温和洁净混油皮洗面奶','',0.0,1,0,'2023-05-29 14:59:46','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (20,'兰蔻精华乳',13,19,'兰蔻菁纯精华凝乳 淡纹紧致抗老化改善暗沉','',0.0,1,0,'2023-05-29 15:00:13','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (21,'兰蔻精华水',13,8,'兰蔻菁纯精华水 锁水保湿修护滋润焕亮抗老化','',0.0,1,0,'2023-05-29 15:00:38','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (22,'兰蔻口红',13,2,'兰蔻菁纯口红小蛮腰丝绒雾面哑光唇膏196断货色','',0.0,1,0,'2023-05-29 15:01:08','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (23,'兰蔻面霜',13,4,'兰蔻菁纯面霜 保湿淡纹滋润紧致抗皱抗老化年轻','',0.0,1,0,'2023-05-29 15:01:35','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (24,'兰蔻气垫',13,13,'兰蔻菁纯气垫粉底液SPF50 自然持妆柔光服帖遮瑕','',0.0,1,0,'2023-05-29 15:02:06','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (25,'兰蔻香水',13,1,'兰蔻IDOLE是我香水 法式花果持久浓香浪漫礼盒','',0.0,1,0,'2023-05-29 15:02:33','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (26,'兰蔻小黑瓶',13,17,'兰蔻小黑瓶面部精华肌底液30ml 维稳修护保湿','',0.0,1,0,'2023-05-29 15:02:54','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (27,'兰蔻眼霜',13,3,'兰蔻菁纯眼霜 保湿滋润 抗皱抗老化淡纹紧致眼周','',0.0,1,0,'2023-05-29 15:03:18','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (28,'迪奥粉底液',5,16,'Dior迪奥新一代锁妆粉底液哑光油皮持妆不蹭妆','',0.0,1,0,'2023-05-29 15:10:29','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (30,'olay玉兰油面霜',1,4,'OLAY玉兰油超红瓶面霜胜肽修护抗老保湿乳液抗皱','',0.0,1,0,'2023-05-29 15:55:52','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (31,'olay抗糖小白瓶精华液',1,19,'Olay\/玉兰油光感小白瓶精华液30ml烟酰胺提亮精华水','',0.0,1,0,'2023-05-29 16:25:18','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (32,'百雀羚面霜',4,4,'百雀羚帧颜霜视黄醇淡纹修护抗皱抗初老精华霜面霜','',0.0,1,0,'2023-05-29 16:27:36','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (33,'古驰口红',6,2,'Gucci\/古驰倾色丝润唇膏小碎花口红25#508#203#滋润正品','',0.0,1,0,'2023-05-29 16:33:35','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (34,'古驰香水',6,1,'Gucci古驰花悦绽放女士香水50ml100ml茉莉香花香调淡香','',0.0,1,0,'2023-05-29 16:35:07','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (35,'海蓝之谜礼盒',7,12,'海蓝之谜精萃水乳套装 补水保湿修护紧致焕亮礼盒','',0.0,1,0,'2023-05-29 16:41:24','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (36,'韩后水乳',8,19,'韩后茶A肽水乳套装抗初老抗皱紧致补水保湿抗氧化护肤品','',0.0,1,0,'2023-05-29 16:43:46','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (37,'韩束水乳',9,19,'韩束红蛮腰水乳套装抗氧保湿提亮抗皱抗初老护肤品补水','',0.0,1,0,'2023-05-29 16:47:31','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (38,'Whoo后口红',10,2,'Whoo后拱辰享美奢华唇膏显色口红润泽唇色','',0.0,1,0,'2023-05-29 16:50:04','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (39,'纪梵希散粉',11,20,'纪梵希明星四宫格散粉四色定妆粉蜜粉透亮光彩','',0.0,1,0,'2023-05-29 18:18:51','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (40,'纪梵希粉底液',11,16,'纪梵希明星柔光粉底液细腻服帖干皮养肤水润光滑','',0.0,1,0,'2023-05-29 18:23:26','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (41,'纪梵希口红',11,2,'纪梵希全新小羊皮口红唇膏n500护唇通勤','',0.0,1,0,'2023-05-29 18:25:36','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (42,'纪梵希香水',11,1,'纪梵希心无禁忌香水高级浓香赫本女士橙花','',0.0,1,0,'2023-05-29 18:27:09','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (43,'纪梵希精华液',11,10,'纪梵希黑能臻萃精华保湿紧致舒缓护理','',0.0,1,0,'2023-05-29 18:31:28','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (44,'纪梵希面霜',11,4,'纪梵希黑能臻萃轻润面霜焕活淡化皱纹','',0.0,1,0,'2023-05-29 18:32:55','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (45,'科颜氏面膜',12,7,'科颜氏亚马逊白泥净肤面膜深层清洁净肤泥膜小样14ml','',0.0,1,0,'2023-05-29 18:34:58','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (46,'兰芝水乳',14,21,'兰芝致美黄金水乳视黄醇分层抗老淡纹紧致维稳修护','',0.0,1,0,'2023-05-29 18:37:12','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (47,'欧莱雅面膜',15,7,'欧莱雅葡萄籽鲜粹精华面膜女补水保湿提亮肌肤滋润面部贴片护肤品','',0.0,1,0,'2023-05-29 18:41:00','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (48,'欧诗漫水乳',16,21,'欧诗漫珍白因水乳套盒共创美白淡斑补水','',0.0,1,0,'2023-05-29 18:44:27','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (49,'珀莱雅精华液',17,10,'珀莱雅双抗精华液3.0抗氧化抗糖面部提亮补水保湿','',0.0,1,0,'2023-05-29 18:46:52','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (50,'圣罗兰口红',18,2,'YSL圣罗兰小金条口红 皮革哑光1966红棕色21','',0.0,1,0,'2023-05-29 18:49:38','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (51,'丸美眼霜',19,3,'丸美二代小红笔眼霜淡化黑眼圈细纹抗皱眼部滋润护肤','',0.0,1,0,'2023-09-14 18:51:00','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (52,'香奈儿礼盒',20,12,'CHANEL 香奈儿山茶花润泽明星套装 保湿补水礼盒','',0.0,1,0,'2023-05-29 18:53:33','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (53,'香奈儿精华水',20,18,'CHANEL香奈儿山茶花润泽微精华水气泡水持久滋润','',0.0,1,0,'2023-05-29 18:55:06','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (54,'香奈儿精华液',20,10,'CHANEL香奈儿一号红山茶花精华液抗初老抗氧淡纹','',0.0,1,0,'2023-09-14 18:56:43','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (55,'雅诗兰黛眼霜 ',21,3,'雅诗兰黛白金级紧颜眼霜 抗皱紧致提眼角淡化细纹','',0.0,1,0,'2023-05-29 18:58:33','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (56,'雅诗兰黛粉底液',21,16,'雅诗兰黛DW持妆粉底液 油皮亲妈持久遮瑕控油防晒','',0.0,1,0,'2023-09-12 19:00:26','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (57,'雅诗兰黛粉底液',21,16,'雅诗兰黛持妆粉底液','',0.0,1,0,'2023-05-29 18:58:33','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (58,'123',21,16,'123','',0.0,2,0,'2023-06-07 14:06:55','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (59,'123456',21,16,'123','',0.0,2,0,'2023-06-07 14:07:22','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (60,'OLAY玉兰油双小白瓶',1,17,'OLAY玉兰油双小白瓶抗糖淡斑组合面部精华液美白提亮','',0.0,1,0,'2023-09-15 14:59:39','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (61,'OLAY玉兰油淡斑小白瓶',1,17,'OLAY玉兰油淡斑小白瓶淡斑美白提亮','',0.0,2,0,'2023-09-15 15:39:40','1900-01-01 00:00:00');
INSERT INTO `t_product`(`product_id`,`product_name`,`business_id`,`cate_sec_id`,`product_profile`,`product_cover`,`freight`,`product_status`,`delete_flag`,`create_time`,`update_time`) VALUES (62,'OLAY玉兰油抗糖小白瓶面膜',1,7,'OLAY玉兰油抗糖小白瓶面膜补水保湿美白提亮去黄气改善暗沉','',0.0,2,0,'2023-09-15 15:43:51','1900-01-01 00:00:00');

-- ----------------------------
-- Table structure for t_product_carousel_image
-- ----------------------------
DROP TABLE IF EXISTS `t_product_carousel_image`;
CREATE TABLE `t_product_carousel_image` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int NOT NULL COMMENT '商品id',
  `img_url` varchar(255) NOT NULL COMMENT '图片地址',
  `sort` int NOT NULL DEFAULT '0' COMMENT '图片排序(越小越靠前)',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除，1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品轮播图';


-- ----------------------------
-- Table structure for t_product_detail_image
-- ----------------------------
DROP TABLE IF EXISTS `t_product_detail_image`;
CREATE TABLE `t_product_detail_image` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int NOT NULL COMMENT '商品id',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片地址',
  `sort` int NOT NULL DEFAULT '0' COMMENT '排序(越小越靠前)',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除，1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品详情图片';


-- ----------------------------
-- Table structure for t_product_spec
-- ----------------------------
DROP TABLE IF EXISTS `t_product_spec`;
CREATE TABLE `t_product_spec` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int NOT NULL COMMENT '商品id',
  `spec_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品规格名称',
  `list_price` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '标价',
  `sell_price` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '售价',
  `stock` int NOT NULL COMMENT '库存',
  `spec_img` varchar(255) NOT NULL COMMENT '商品规格图片',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除，1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品规格';

INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (1,1,'基本款、30g',0.0,0.0,100,'',0,'2023-05-19 08:41:16','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (2,2,'泡沫型120g',0.0,0.0,88,'',0,'2023-05-30 08:27:30','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (3,3,'小银瓶30ml',0.0,0.0,100,'',0,'2023-05-30 08:27:44','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (4,4,'贴片式10片',0.0,0.0,100,'',0,'2023-05-30 08:27:54','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (5,5,'大红瓶50g',0.0,0.0,125,'',0,'2023-05-30 08:28:01','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (6,6,'经典神仙水230ml',0.0,0.0,100,'',0,'2023-05-30 08:28:11','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (7,7,'唇妆系列唇刷',0.0,0.0,125,'',0,'2023-05-30 08:28:22','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (8,8,'瑰丽粉红系列瑰丽唇膏8g',0.0,0.0,100,'',0,'2023-05-30 08:28:30','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (9,9,'丝滑腮红6g',0.0,0.0,88,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (10,10,'尼罗河淡香水30ml',0.0,0.0,125,'',0,'2023-05-30 08:28:53','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (11,11,'橘彩星光礼盒',0.0,0.0,100,'',0,'2023-05-30 08:29:05','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (12,12,'正常规格150ml',0.0,0.0,88,'',0,'2023-05-30 08:29:14','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (13,13,'FLD+RD+LAMOUSSE正常规格',0.0,0.0,125,'',0,'2023-05-30 08:29:26','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (14,14,'凝脂恒久气垫粉底14g',0.0,0.0,100,'',0,'2023-05-30 08:29:39','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (15,15,'花秘瑰萃玫瑰微凝珠',0.0,0.0,88,'',0,'2023-05-30 08:29:53','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (16,16,'菁纯柔雾染唇液',0.0,0.0,125,'',0,'2023-05-30 08:30:07','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (17,17,'柔皙深护防晒30ml',0.0,0.0,100,'',0,'2023-05-30 08:30:18','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (18,18,'持妆轻透粉底液',0.0,0.0,88,'',0,'2023-05-30 08:30:30','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (19,19,'净澈焕肤洁面乳125ml',0.0,0.0,125,'',0,'2023-05-30 08:31:20','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (20,20,'新菁纯臻颜精华凝乳15ml',0.0,0.0,88,'',0,'2023-05-30 08:31:28','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (21,21,'菁纯臻颜玫瑰柔肤水30ml',0.0,0.0,125,'',0,'2023-05-30 08:31:35','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (22,22,'菁纯柔雾哑光基本款3.5g',0.0,0.0,56,'',0,'2023-05-30 08:31:44','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (23,23,'全新塑颜紧致焕白霜50ml',0.0,0.0,100,'',0,'2023-05-30 08:31:58','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (24,24,'联名款 基本款13g',0.0,0.0,56,'',0,'2023-05-30 08:32:06','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (25,25,'基本款25ml',0.0,0.0,100,'',0,'2023-05-30 08:32:15','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (26,26,'全新精华肌底液30ml',0.0,0.0,56,'',0,'2023-05-30 08:49:30','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (27,27,'肌底精华焕亮眼霜15ml',0.0,0.0,100,'',0,'2023-05-30 08:49:37','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (28,28,'凝脂恒久哑光30ml',0.0,0.0,100,'',0,'2023-05-30 08:49:46','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (29,29,'烈艳蓝金唇膏3.5g',0.0,0.0,10056,'',0,'2023-05-30 08:49:56','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (30,30,'塑颜空气感凝霜100g 轻盈',0.0,0.0,100,'',0,'2023-05-30 09:02:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (31,31,'亮洁皙颜祛斑精华液40ml',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (32,32,'帧颜淡纹修护精华霜(焕新配方)100g',0.0,0.0,56,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (33,33,'限量版蓝碎花 ',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (34,34,'花悦绽放女士香水50ml',0.0,0.0,56,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (35,35,'精萃水乳套装 ',0.0,0.0,56,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (36,36,'韩后茶酵类视黄醇110ml',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (37,37,'多肽组合110ml',0.0,0.0,56,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (38,38,'天气丹花5g',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (39,39,'明星四宫格散粉12g',0.0,0.0,44,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (40,40,'【HOT】1-N80 30ml',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (41,41,'【hot 伯爵玫瑰】3.4g',0.0,0.0,44,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (42,42,'香水EDP35ml',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (43,43,'黑能臻萃精华30ml',0.0,0.0,44,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (44,44,'黑能臻萃轻润面霜50ml',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (45,45,'水洗式125ml',0.0,0.0,44,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (46,46,'致美紧颜焕采水乳',0.0,0.0,44,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (47,47,'清润葡萄籽鲜粹面膜15片',0.0,0.0,44,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (48,48,'双源透白套装',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (49,49,'双抗精华+红宝石精华100ml',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (50,50,'细管纯口红',0.0,0.0,88,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (51,51,'多维紧致倍护精华眼霜20g',0.0,0.0,44,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (52,52,'炫亮魅力正常规格',0.0,0.0,88,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (53,53,'奢华精萃密集焕活精华40ml',0.0,0.0,88,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (54,54,'奢华精萃密集焕活精华',0.0,0.0,100,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (55,55,'特润修护15ml',0.0,0.0,88,'',0,'2023-05-30 08:28:40','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (56,56,'基本款防晒类30ml',0.0,0.0,10,'',0,'2023-05-30 09:30:42','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (57,1,'豪华款、60g',0.0,0.0,20,'',0,'2023-06-05 10:55:54','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (58,2,'泡沫型400g',0.0,0.0,120,'',0,'2023-06-05 10:57:12','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (59,3,'大银瓶60ml',0.0,0.0,65,'',0,'2023-06-05 10:57:42','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (60,5,'超大瓶100ml',0.0,0.0,45,'',0,'2023-06-05 10:58:14','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (61,5,'超大红瓶150g',0.0,0.0,28,'',0,'2023-06-05 10:58:57','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (62,6,'经典神仙水500ml',0.0,0.0,65,'',0,'2023-06-05 10:59:30','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (63,6,'轻奢神仙水1000ml',0.0,0.0,20,'',0,'2023-06-05 11:00:10','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (64,4,'贴片式100片',0.0,0.0,64,'',0,'2023-06-05 11:01:13','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (65,7,'唇妆系列唇刷max',0.0,0.0,32,'',0,'2023-06-05 11:02:18','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (66,8,'瑰丽粉红系列瑰丽唇膏20g',0.0,0.0,32,'',0,'2023-06-05 11:02:41','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (67,9,'丝滑腮红12g',0.0,0.0,34,'',0,'2023-06-05 11:03:14','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (68,9,'丝滑腮红50g',0.0,0.0,36,'',0,'2023-06-05 11:03:38','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (69,10,'尼罗河淡香水60ml',0.0,0.0,25,'',0,'2023-06-05 11:04:02','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (70,10,'尼罗河淡香水120ml',0.0,0.0,34,'',0,'2023-06-05 11:04:16','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (71,11,'橘彩星光礼盒MAX',0.0,0.0,98,'',0,'2023-06-05 11:04:44','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (72,12,'中等规格300ml',0.0,0.0,123,'',0,'2023-06-05 11:05:23','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (73,12,'超大规格5000ml',0.0,0.0,32,'',0,'2023-06-05 11:05:53','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (74,13,'ADC+RD+LAMOUSSE奢华规格',0.0,0.0,46,'',0,'2023-06-05 11:06:14','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (75,14,'凝脂恒久气垫粉底50g',0.0,0.0,42,'',0,'2023-06-05 11:07:01','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (76,14,'凝脂恒久气垫粉底100g',0.0,0.0,43,'',0,'2023-06-05 11:07:20','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (77,15,'花秘瑰萃菊花微凝珠',0.0,0.0,64,'',0,'2023-06-05 11:07:44','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (78,16,'菁纯柔雾染唇液max',0.0,0.0,52,'',0,'2023-06-05 11:08:13','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (79,17,'柔皙深护防晒60ml',0.0,0.0,52,'',0,'2023-06-05 11:08:41','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (80,18,'持妆轻透粉底液max',0.0,0.0,45,'',0,'2023-06-05 11:09:31','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (81,19,'净澈焕肤洁面乳300ml',0.0,0.0,86,'',0,'2023-06-05 11:09:58','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (82,20,'新菁纯臻颜精华凝乳50ml',0.0,0.0,46,'',0,'2023-06-05 11:10:22','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (83,21,'菁纯臻颜玫瑰柔肤水60ml',0.0,0.0,54,'',0,'2023-06-05 11:15:05','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (84,21,'菁纯臻颜玫瑰柔肤水200ml',0.0,0.0,23,'',0,'2023-06-05 11:15:20','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (85,22,'菁纯柔雾哑光max款7g',0.0,0.0,54,'',0,'2023-06-05 11:16:11','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (86,23,'全新塑颜紧致焕白霜100ml',0.0,0.0,52,'',0,'2023-06-05 11:17:07','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (87,24,'联名款 豪华款30g',0.0,0.0,51,'',0,'2023-06-05 11:17:53','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (88,25,'max款60ml',0.0,0.0,42,'',0,'2023-06-05 11:26:39','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (89,26,'全新精华肌底液超大瓶100ml',0.0,0.0,23,'',0,'2023-06-05 11:27:28','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (90,27,'肌底精华焕亮眼霜60ml',0.0,0.0,24,'',0,'2023-06-05 11:28:13','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (91,27,'肌底精华焕亮眼霜100ml',0.0,0.0,62,'',0,'2023-06-05 11:28:24','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (92,28,'凝脂恒久哑光60ml',0.0,0.0,42,'',0,'2023-06-05 11:28:57','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (93,28,'凝脂恒久亮光45ml',0.0,0.0,36,'',0,'2023-06-05 11:29:16','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (94,29,'烈艳蓝金唇膏7g',0.0,0.0,52,'',0,'2023-06-05 11:29:52','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (95,29,'黑金唇膏12g',0.0,0.0,25,'',0,'2023-06-05 11:30:20','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (96,30,'塑颜空气感凝霜100g 保湿',0.0,0.0,36,'',0,'2023-06-05 11:30:48','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (97,31,'亮洁皙颜祛斑精华液80ml',0.0,0.0,20,'',0,'2023-06-05 11:32:13','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (98,32,'帧颜淡纹修护精华霜(焕新配方)150g',0.0,0.0,30,'',0,'2023-06-05 11:32:57','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (99,32,'帧颜淡纹修护精华霜(焕新配方)200g',0.0,0.0,20,'',0,'2023-06-05 11:33:20','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (100,33,'限量版蓝碎花 MAX',0.0,0.0,52,'',0,'2023-06-05 11:33:50','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (101,34,'花悦绽放女士香水150ml',0.0,0.0,20,'',0,'2023-06-05 11:34:18','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (102,34,'花悦绽放女士香水100ml',0.0,0.0,30,'',0,'2023-06-05 11:34:42','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (103,35,'精萃水乳套装 max',0.0,0.0,11,'',0,'2023-06-05 11:34:50','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (104,36,'韩后茶酵类视黄醇180ml',0.0,0.0,11,'',0,'2023-06-05 11:34:59','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (105,36,'韩后茶酵类视黄醇350ml',0.0,0.0,11,'',0,'2023-06-05 11:35:10','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (106,37,'多肽组合110ml',0.0,0.0,11,'',0,'2023-06-05 11:35:17','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (107,37,'多肽组合110ml',0.0,0.0,11,'',0,'2023-06-05 11:35:23','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (108,37,'多肽组合110ml',0.0,0.0,11,'',0,'2023-06-05 11:35:28','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (109,38,'天气丹花5g',0.0,0.0,11,'',0,'2023-06-05 11:35:34','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (110,38,'天气丹花5g',0.0,0.0,11,'',0,'2023-06-05 11:35:39','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (111,39,'明星四宫格散粉24g',0.0,0.0,11,'',0,'2023-06-05 11:35:47','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (112,39,'明星四宫格散粉36g',0.0,0.0,11,'',0,'2023-06-05 11:35:51','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (113,40,'【HOT】1-N80 45ml',0.0,0.0,11,'',0,'2023-06-05 11:36:01','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (114,40,'【HOT】1-N80 60ml',0.0,0.0,11,'',0,'2023-06-05 11:36:05','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (115,41,'【hot 伯爵玫瑰】7g',0.0,0.0,11,'',0,'2023-06-05 11:36:11','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (116,41,'【hot 伯爵玫瑰】10g',0.0,0.0,11,'',0,'2023-06-05 11:36:15','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (117,42,'香水EDP50ml',0.0,0.0,11,'',0,'2023-06-05 11:36:21','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (118,42,'香水EDP100mlMAX',0.0,0.0,11,'',0,'2023-06-05 11:36:26','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (119,43,'黑能臻萃精华50ml',0.0,0.0,43,'',0,'2023-06-05 11:40:21','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (120,43,'黑能臻萃精华80ml',0.0,0.0,43,'',0,'2023-06-05 11:40:21','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (121,44,'黑能臻萃轻润面霜100ml',0.0,0.0,22,'',0,'2023-06-05 11:58:07','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (122,44,'黑能臻萃轻润面霜200ml',0.0,0.0,22,'',0,'2023-06-05 11:58:27','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (123,45,'水洗式150ml',0.0,0.0,22,'',0,'2023-06-05 11:58:33','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (124,45,'水洗式200ml',0.0,0.0,22,'',0,'2023-06-05 11:58:39','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (125,46,'致美紧颜焕采水乳MIN',0.0,0.0,22,'',0,'2023-06-05 11:58:45','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (126,46,'致美紧颜焕采水乳MAX',0.0,0.0,22,'',0,'2023-06-05 11:58:52','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (127,47,'清润葡萄籽鲜粹面膜30片',0.0,0.0,22,'',0,'2023-06-05 11:59:00','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (128,47,'清润葡萄籽鲜粹面膜50片',0.0,0.0,22,'',0,'2023-06-05 11:59:08','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (129,48,'双源透白套装MIN',0.0,0.0,22,'',0,'2023-06-05 11:59:17','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (130,48,'双源透白套装MAX',0.0,0.0,22,'',0,'2023-06-05 11:59:24','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (131,49,'双抗精华+红宝石精华170ml',0.0,0.0,22,'',0,'2023-06-05 11:59:31','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (132,49,'双抗精华+红宝石精华230ml',0.0,0.0,22,'',0,'2023-06-05 11:59:45','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (133,50,'细管纯口红1.5g',0.0,0.0,22,'',0,'2023-06-05 11:59:51','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (134,50,'细管纯口红7g',0.0,0.0,22,'',0,'2023-06-05 11:59:57','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (135,51,'多维紧致倍护精华眼霜50g',0.0,0.0,22,'',0,'2023-06-05 12:00:02','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (136,51,'多维紧致倍护精华眼霜80g',0.0,0.0,22,'',0,'2023-06-05 12:00:08','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (137,52,'炫亮魅力奢华规格',0.0,0.0,22,'',0,'2023-06-05 12:00:14','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (138,52,'炫亮魅力超大规格',0.0,0.0,22,'',0,'2023-06-05 12:00:19','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (139,53,'奢华精萃密集焕活精华70ml',0.0,0.0,22,'',0,'2023-06-05 12:00:25','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (140,53,'奢华精萃密集焕活精华100ml',0.0,0.0,22,'',0,'2023-06-05 12:00:30','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (141,54,'奢华精萃密集焕活精华MIN',0.0,0.0,22,'',0,'2023-06-05 12:00:36','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (142,54,'奢华精萃密集焕活精华MAX',0.0,0.0,22,'',0,'2023-06-05 12:00:42','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (143,55,'特润修护50ml',0.0,0.0,22,'',0,'2023-06-05 12:00:47','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (144,55,'特润修护100ml',0.0,0.0,22,'',0,'2023-06-05 12:00:51','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (145,56,'基本款防晒类30ml',0.0,0.0,22,'',0,'2023-06-05 12:00:57','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (146,56,'奢华款防晒类60ml',0.0,0.0,22,'',0,'2023-06-05 12:01:02','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (147,56,'超大款防晒类100ml',0.0,0.0,10,'',0,'2023-06-05 12:06:09','2023-12-04 14:07:10');
INSERT INTO `t_product_spec`(`id`,`product_id`,`spec_name`,`list_price`,`sell_price`,`stock`,`spec_img`,`delete_flag`,`create_time`,`update_time`) VALUES (149,18,'持妆控油粉底液',0.0,0.0,100,'',0,'2023-09-15 22:12:50','2023-12-04 14:07:10');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `gender` int DEFAULT NULL COMMENT '性别(0-男 1-女)',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `profile` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个人简介',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `province_code` int DEFAULT NULL COMMENT '省份编码',
  `city_code` int DEFAULT NULL COMMENT '城市编码',
  `district_code` int DEFAULT NULL COMMENT '区县编码',
  `delete_flag` int NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删除 1-已删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户信息表';

INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (1,'coco','蔻蔻','aaaaaa',1,'1321965842@qq.com','13195698563',null,'快乐宇航员','\/images\/userImg\/169501971411702.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (2,'Qw1ko','李分分','cccccc',0,'222222@qq.com','18325649653',null,'一只小鸟','\/images\/userImg\/2.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (3,'Augety','赵的的','11bb22',1,'525252@qq.com','18236545526',null,'呀呀呀呀呀','\/images\/userImg\/3.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (4,'Nemophilist','张飞','666666',0,'1563452@qq.com','13562549952',null,'美好的一天来了','\/images\/userImg\/4.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (5,'Manchi111','赵云','aaaaaa',1,'15264233@qq.com','14562359852',null,'明天很光明','\/images\/userImg\/5.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (6,'Astronaut','蔡文姬','aaaaaa',1,'15624562@qq.com','18564526552',null,'明天很光明','\/images\/userImg\/6.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (7,'爱、已没落','妲己','111222',1,'452652666@qq.com','17526459562',null,'明天很光明','\/images\/userImg\/7.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (8,'抬头看看天空','王少军','111888',1,'516426623@qq.com','15624623555',null,'明天很光明','\/images\/userImg\/8.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (9,'我一直都在','项羽','111aaa',1,'541655122@qq.com','15265553214',null,'明天很光明','\/images\/userImg\/9.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (10,'烈酒故人','张小巧','111xxx',1,'651523453@qq.com','18956662532',null,'明天很光明','\/images\/userImg\/10.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (11,'幻城','王达乔','112266',1,'5264266522@qq.com','15261536642',null,'明天很光明','\/images\/userImg\/11.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (12,'稚初','张达笑','111111',1,'4521625232@qq.com','18325649652',null,'明天很光明','\/images\/userImg\/12.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (13,'sunshine* 安好','李给力','111111',1,'4851622655@qq.com','18425626331',null,'明天很光明','\/images\/userImg\/13.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (14,'再吵再闹','李花','111111',1,'2564152652@qq.com','19652364266',null,'明天很光明','\/images\/userImg\/14.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (15,'牵你。左手','李菊花','111111',1,'25634156222@qq.com','15962456325',null,'明天很光明','\/images\/userImg\/15.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (16,'快到碗里来','王大锤','111111',1,'56231462@qq.com','18565245552',null,'明天很光明','\/images\/userImg\/16.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (17,'我会发光耶','张玫瑰','111111',1,'1562456@qq.com','15654558999',null,'明天很光明','\/images\/userImg\/17.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (18,'桃桃桃 ','张大先','111111',1,'552615566@qq.com','15623548852',null,'明天很光明','\/images\/userImg\/18.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (19,'要有多坚强','李十九','111111',1,'526415622@qq.com','15965425841',null,'明天很光明','\/images\/userImg\/19.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (20,'古城小巷','李登辉','111111',1,'5264895155@qq.com','19526456284',null,'明天很光明','\/images\/userImg\/20.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (22,'小姑凉','顾顾','111111',1,'gugu@163.com','19697956324',null,'小姑凉','\/images\/userImg\/169501868642302.jpg',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');
INSERT INTO `t_user`(`user_id`,`user_name`,`account`,`password`,`gender`,`email`,`phone`,`birthday`,`profile`,`avatar`,`province_code`,`city_code`,`district_code`,`delete_flag`,`create_time`,`update_time`) VALUES (24,'卡拉','123','kalala',1,null,'15906329587',null,null,'\/images\/userImg\/momo.png',null,null,null,0,'1900-01-01 00:00:00','1900-01-01 00:00:00');

SET UNIQUE_CHECKS = 1;
SET FOREIGN_KEY_CHECKS = 1;
