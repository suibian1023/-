-- ----------------------------
-- 修改数据库表结构以匹配 Domain 类和 Mapper XML
-- 执行此脚本前请备份数据库！
-- ----------------------------

-- 1. 修改配队推荐表 (genshin_recommend_team)
-- 删除旧字段
ALTER TABLE `genshin_recommend_team` DROP COLUMN IF EXISTS `characters`;
ALTER TABLE `genshin_recommend_team` DROP COLUMN IF EXISTS `team_type`;
ALTER TABLE `genshin_recommend_team` DROP COLUMN IF EXISTS `description`;
ALTER TABLE `genshin_recommend_team` DROP COLUMN IF EXISTS `strategy`;
ALTER TABLE `genshin_recommend_team` DROP COLUMN IF EXISTS `difficulty`;

-- 添加新字段（与 Domain 类和 Mapper XML 一致）
ALTER TABLE `genshin_recommend_team` 
ADD COLUMN `char1_id` bigint(20) DEFAULT 0 COMMENT '1号位角色ID(主C)' AFTER `team_name`,
ADD COLUMN `char2_id` bigint(20) DEFAULT 0 COMMENT '2号位角色ID(副C)' AFTER `char1_id`,
ADD COLUMN `char3_id` bigint(20) DEFAULT 0 COMMENT '3号位角色ID(增伤/辅助)' AFTER `char2_id`,
ADD COLUMN `char4_id` bigint(20) DEFAULT 0 COMMENT '4号位角色ID(生存/盾奶)' AFTER `char3_id`,
ADD COLUMN `team_bonus` varchar(200) DEFAULT '' COMMENT '元素共鸣效果' AFTER `char4_id`,
ADD COLUMN `rotation` text COMMENT '输出手法/队伍简评' AFTER `team_bonus`;

-- 2. 修改武器推荐表 (genshin_recommend_weapon)
-- 删除旧字段
ALTER TABLE `genshin_recommend_weapon` DROP COLUMN IF EXISTS `weapon_name`;
ALTER TABLE `genshin_recommend_weapon` DROP COLUMN IF EXISTS `weapon_type`;
ALTER TABLE `genshin_recommend_weapon` DROP COLUMN IF EXISTS `rarity`;
ALTER TABLE `genshin_recommend_weapon` DROP COLUMN IF EXISTS `priority`;
ALTER TABLE `genshin_recommend_weapon` DROP COLUMN IF EXISTS `reason`;

-- 添加新字段（与 Domain 类和 Mapper XML 一致）
ALTER TABLE `genshin_recommend_weapon` 
ADD COLUMN `character_id` bigint(20) DEFAULT 0 COMMENT '角色ID' AFTER `id`,
ADD COLUMN `weapon_id` bigint(20) DEFAULT 0 COMMENT '推荐武器ID' AFTER `character_id`,
ADD COLUMN `recommend_degree` varchar(50) DEFAULT '' COMMENT '推荐梯度: T0专武/T1极佳/T2过渡' AFTER `weapon_id`,
ADD COLUMN `remark` varchar(500) DEFAULT '' COMMENT '备注' AFTER `recommend_degree`;

-- 完成！
