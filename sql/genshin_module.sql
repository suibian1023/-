-- ----------------------------
-- Genshin Impact 模块数据库表结构
-- ----------------------------

-- ----------------------------
-- 1、原神角色基础信息表
-- ----------------------------
DROP TABLE IF EXISTS `genshin_character`;
CREATE TABLE `genshin_character` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色唯一ID',
  `name` varchar(100) DEFAULT '' COMMENT '角色名称',
  `title` varchar(200) DEFAULT '' COMMENT '角色称号',
  `description` text COMMENT '角色描述',
  `weapon_type` varchar(50) DEFAULT '' COMMENT '武器类型编码',
  `weapon_text` varchar(50) DEFAULT '' COMMENT '武器类型名称',
  `body_type` varchar(50) DEFAULT '' COMMENT '体型编码',
  `gender` varchar(10) DEFAULT '' COMMENT '性别',
  `quality_type` varchar(50) DEFAULT '' COMMENT '品质编码',
  `rarity` int(11) DEFAULT 0 COMMENT '星级',
  `birthday_mmdd` varchar(10) DEFAULT '' COMMENT '生日月日',
  `birthday` varchar(20) DEFAULT '' COMMENT '生日',
  `element_type` varchar(50) DEFAULT '' COMMENT '元素编码',
  `element_text` varchar(50) DEFAULT '' COMMENT '元素名称',
  `affiliation` varchar(200) DEFAULT '' COMMENT '所属组织',
  `association_type` varchar(50) DEFAULT '' COMMENT '阵营类型',
  `region` varchar(100) DEFAULT '' COMMENT '地区',
  `substat_type` varchar(50) DEFAULT '' COMMENT '副属性编码',
  `substat_text` varchar(50) DEFAULT '' COMMENT '副属性名称',
  `constellation` varchar(100) DEFAULT '' COMMENT '命之座',
  `cv_chinese` varchar(100) DEFAULT '' COMMENT '中文CV',
  `cv_english` varchar(100) DEFAULT '' COMMENT '英文CV',
  `cv_japanese` varchar(100) DEFAULT '' COMMENT '日文CV',
  `cv_korean` varchar(100) DEFAULT '' COMMENT '韩文CV',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='原神角色基础信息表';

-- ----------------------------
-- 2、原神元素系统表
-- ----------------------------
DROP TABLE IF EXISTS `genshin_domain`;
CREATE TABLE `genshin_domain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `domain_name` varchar(100) DEFAULT '' COMMENT '领域名称',
  `domain_type` varchar(50) DEFAULT '' COMMENT '领域类型',
  `description` text COMMENT '描述',
  `reward_level` int(11) DEFAULT 0 COMMENT '奖励等级',
  `recommended_level` int(11) DEFAULT 0 COMMENT '推荐等级',
  `location` varchar(200) DEFAULT '' COMMENT '位置',
  `unlock_condition` varchar(500) DEFAULT '' COMMENT '解锁条件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='原神元素系统表';

-- ----------------------------
-- 3、原神敌人信息表
-- ----------------------------
DROP TABLE IF EXISTS `genshin_enemy`;
CREATE TABLE `genshin_enemy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '敌人ID',
  `name` varchar(100) DEFAULT '' COMMENT '敌人名称',
  `enemy_type` varchar(50) DEFAULT '' COMMENT '敌人类型',
  `description` text COMMENT '描述',
  `level` int(11) DEFAULT 0 COMMENT '等级',
  `hp` bigint(20) DEFAULT 0 COMMENT '生命值',
  `attack` bigint(20) DEFAULT 0 COMMENT '攻击力',
  `defense` bigint(20) DEFAULT 0 COMMENT '防御力',
  `element` varchar(50) DEFAULT '' COMMENT '元素属性',
  `weakness` varchar(200) DEFAULT '' COMMENT '弱点',
  `location` varchar(200) DEFAULT '' COMMENT '出现位置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='原神敌人信息表';

-- ----------------------------
-- 4、原神敌人调查表
-- ----------------------------
DROP TABLE IF EXISTS `genshin_enemy_investigation`;
CREATE TABLE `genshin_enemy_investigation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '调查ID',
  `enemy_id` bigint(20) DEFAULT 0 COMMENT '敌人ID',
  `investigation_date` varchar(20) DEFAULT '' COMMENT '调查日期',
  `investigator` varchar(100) DEFAULT '' COMMENT '调查员',
  `findings` text COMMENT '调查发现',
  `status` varchar(20) DEFAULT '' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='原神敌人调查表';

-- ----------------------------
-- 5、原神敌人奖励表
-- ----------------------------
DROP TABLE IF EXISTS `genshin_enemy_reward`;
CREATE TABLE `genshin_enemy_reward` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '奖励ID',
  `enemy_id` bigint(20) DEFAULT 0 COMMENT '敌人ID',
  `reward_type` varchar(50) DEFAULT '' COMMENT '奖励类型',
  `reward_name` varchar(100) DEFAULT '' COMMENT '奖励名称',
  `quantity` int(11) DEFAULT 0 COMMENT '数量',
  `drop_rate` decimal(5,2) DEFAULT 0.00 COMMENT '掉落率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='原神敌人奖励表';

-- ----------------------------
-- 6、原神推荐圣遗物表
-- ----------------------------
DROP TABLE IF EXISTS `genshin_recommend_artifact`;
CREATE TABLE `genshin_recommend_artifact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '推荐ID',
  `character_id` bigint(20) DEFAULT 0 COMMENT '角色ID',
  `artifact_set` varchar(100) DEFAULT '' COMMENT '圣遗物套装',
  `main_stat` varchar(100) DEFAULT '' COMMENT '主属性',
  `sub_stats` varchar(500) DEFAULT '' COMMENT '副属性',
  `priority` int(11) DEFAULT 0 COMMENT '优先级',
  `reason` text COMMENT '推荐理由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='原神推荐圣遗物表';

-- ----------------------------
-- 7、原神推荐队伍表
-- ----------------------------
DROP TABLE IF EXISTS `genshin_recommend_team`;
CREATE TABLE `genshin_recommend_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '队伍ID',
  `team_name` varchar(100) DEFAULT '' COMMENT '队伍名称',
  `characters` varchar(500) DEFAULT '' COMMENT '角色列表',
  `team_type` varchar(50) DEFAULT '' COMMENT '队伍类型',
  `description` text COMMENT '队伍描述',
  `strategy` text COMMENT '作战策略',
  `difficulty` varchar(20) DEFAULT '' COMMENT '难度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='原神推荐队伍表';

-- ----------------------------
-- 8、原神推荐武器表
-- ----------------------------
DROP TABLE IF EXISTS `genshin_recommend_weapon`;
CREATE TABLE `genshin_recommend_weapon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '推荐ID',
  `character_id` bigint(20) DEFAULT 0 COMMENT '角色ID',
  `weapon_name` varchar(100) DEFAULT '' COMMENT '武器名称',
  `weapon_type` varchar(50) DEFAULT '' COMMENT '武器类型',
  `rarity` int(11) DEFAULT 0 COMMENT '星级',
  `priority` int(11) DEFAULT 0 COMMENT '优先级',
  `reason` text COMMENT '推荐理由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='原神推荐武器表';

-- ----------------------------
-- 9、原神用户收藏表
-- ----------------------------
DROP TABLE IF EXISTS `genshin_user_favorite`;
CREATE TABLE `genshin_user_favorite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收藏ID',
  `user_id` bigint(20) DEFAULT 0 COMMENT '用户ID',
  `favorite_type` varchar(50) DEFAULT '' COMMENT '收藏类型',
  `favorite_id` bigint(20) DEFAULT 0 COMMENT '收藏对象ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='原神用户收藏表';

-- ----------------------------
-- 10、天赋消耗表
-- ----------------------------
DROP TABLE IF EXISTS `talent_costs`;
CREATE TABLE `talent_costs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `character_id` bigint(20) DEFAULT 0 COMMENT '角色ID',
  `talent_type` varchar(50) DEFAULT '' COMMENT '天赋类型',
  `level` int(11) DEFAULT 0 COMMENT '等级',
  `mora_cost` bigint(20) DEFAULT 0 COMMENT '摩拉消耗',
  `materials` text COMMENT '所需材料',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='天赋消耗表';
