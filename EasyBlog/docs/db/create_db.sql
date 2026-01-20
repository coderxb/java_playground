CREATE TABLE `juser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) NOT NULL COMMENT '用户邮箱',
  `password` varchar(200) DEFAULT NULL COMMENT '密码-MD5加密',
  `name` varchar(50) DEFAULT '' COMMENT '用户名称',
  `en_name` varchar(50) DEFAULT NULL COMMENT '英文名称',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `website` varchar(100) DEFAULT '' COMMENT '个人站点',
  `position` varchar(200) DEFAULT NULL,
  `isvalid` tinyint(4) DEFAULT '1' COMMENT '是否有效 1-无效， 2-有效',
  `version` int(11) DEFAULT '0' COMMENT '记录版本',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博文用户表';

CREATE TABLE `tag` (
  `id` int(11) NOT NULL COMMENT '自增ID',
  `name` varchar(255) DEFAULT NULL COMMENT '标签名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `titile` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `art_id` bigint(20) DEFAULT NULL COMMENT '博文ID',
  `author_id` int(11) DEFAULT NULL COMMENT '用户ID-作者',
  `version` int(11) DEFAULT '0' COMMENT '记录版本',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_artid` (`art_id`) USING BTREE,
  KEY `fk_authorid` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博文表';

CREATE TABLE `art_tag_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `art_id` bigint(20) DEFAULT NULL COMMENT '博文ID',
  `tag_id` int(11) DEFAULT NULL COMMENT '标签ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `fk_artid` (`art_id`) USING BTREE,
  KEY `fk_tagid` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博文与标签关联表';

CREATE TABLE `article_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `art_id` bigint(20) DEFAULT NULL COMMENT '文章ID',
  `content` text COMMENT '文章内存',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_artid` (`art_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博文内容表';


