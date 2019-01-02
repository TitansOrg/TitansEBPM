/*
Navicat MySQL Data Transfer

Source Server         : ArisPub
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : arispub

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-01-02 19:37:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aris_assignment`
-- ----------------------------
DROP TABLE IF EXISTS `aris_assignment`;
CREATE TABLE `aris_assignment` (
`id`  varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'newid()' ,
`obj_def_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`model_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`, `model_id`, `obj_def_id`),
UNIQUE INDEX `idx_aris_assignmentind1` (`obj_def_id`, `model_id`) USING BTREE ,
INDEX `idx_aris_assignmentind2` (`obj_def_id`) USING BTREE ,
INDEX `idx_aris_assignmentind3` (`model_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_attr_name`
-- ----------------------------
DROP TABLE IF EXISTS `aris_attr_name`;
CREATE TABLE `aris_attr_name` (
`attribute_index`  decimal(12,0) NULL DEFAULT NULL ,
`attribute_type`  decimal(12,0) NULL DEFAULT NULL ,
`attribute_name`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`belong_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`symbol_type`  decimal(12,0) NULL DEFAULT NULL ,
`orig_attribute_type`  decimal(12,0) NULL DEFAULT NULL ,
`attribute_typeguid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`attribute_id`  decimal(12,0) NOT NULL ,
`attribute_key`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`attribute_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_attrocc`
-- ----------------------------
DROP TABLE IF EXISTS `aris_attrocc`;
CREATE TABLE `aris_attrocc` (
`id`  varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'newid()' ,
`model_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`occ_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`fs_sheet_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`attr_type_num`  decimal(12,0) NULL DEFAULT NULL ,
`type_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`flags`  decimal(12,0) NULL DEFAULT NULL ,
`port`  decimal(7,0) NULL DEFAULT NULL ,
`alignment`  decimal(7,0) NULL DEFAULT NULL ,
`order_num`  decimal(7,0) NULL DEFAULT NULL ,
`x_offset`  decimal(12,0) NULL DEFAULT NULL ,
`y_offset`  decimal(12,0) NULL DEFAULT NULL ,
`size_x`  decimal(12,0) NULL DEFAULT NULL ,
`size_y`  decimal(12,0) NULL DEFAULT NULL ,
`rotation`  decimal(7,0) NULL DEFAULT NULL ,
PRIMARY KEY (`id`, `model_id`),
UNIQUE INDEX `idx_aris_attroccind1` (`occ_id`, `attr_type_num`, `type_guid`) USING BTREE ,
INDEX `idx_aris_attroccind2` (`model_id`) USING BTREE ,
INDEX `idx_aris_attroccind3` (`occ_id`) USING BTREE ,
INDEX `idx_aris_attroccind4` (`fs_sheet_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_definition`
-- ----------------------------
DROP TABLE IF EXISTS `aris_definition`;
CREATE TABLE `aris_definition` (
`id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'newid()' ,
`discriminator`  decimal(12,0) NULL DEFAULT NULL ,
`last_updated`  decimal(22,0) NULL DEFAULT NULL ,
`global_id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type_num`  decimal(12,0) NULL DEFAULT NULL ,
`group_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`from_obj_def_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`to_obj_def_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`link`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`ref_global_id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`data`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`meta_file`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`reorg`  decimal(12,0) NULL DEFAULT NULL ,
`sub_type_num`  decimal(12,0) NULL DEFAULT NULL ,
`def_symbol_num`  decimal(12,0) NULL DEFAULT NULL ,
`symbol_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`lock_owner`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_definitionind1` (`global_id`) USING BTREE ,
INDEX `idx_aris_definitionind2` (`ref_global_id`) USING BTREE ,
INDEX `idx_aris_definitionind3` (`group_id`) USING BTREE ,
INDEX `idx_aris_definitionind4` (`from_obj_def_id`) USING BTREE ,
INDEX `idx_aris_definitionind5` (`to_obj_def_id`) USING BTREE ,
INDEX `idx_aris_definitionind6` (`lock_owner`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_definition_attr`
-- ----------------------------
DROP TABLE IF EXISTS `aris_definition_attr`;
CREATE TABLE `aris_definition_attr` (
`id`  varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'newid()' ,
`discriminator`  decimal(12,0) NULL DEFAULT NULL ,
`attr_type_num`  decimal(12,0) NULL DEFAULT NULL ,
`type_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`language_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`parent_item_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`plain_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_tnf_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`styled_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`plain_tnf_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`styled_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`long_value`  decimal(22,0) NULL DEFAULT NULL ,
`double_value`  decimal(20,0) NULL DEFAULT NULL ,
`blob_value`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_definition_attrind1` (`parent_item_id`, `attr_type_num`, `language_id`, `type_guid`) USING BTREE ,
INDEX `idx_aris_definition_attrind2` (`plain_text_fragment`) USING BTREE ,
INDEX `idx_aris_definition_attrind3` (`plain_tnf_fragment`) USING BTREE ,
INDEX `idx_aris_definition_attrind4` (`language_id`, `attr_type_num`, `type_guid`, `plain_tnf_fragment`, `discriminator`, `parent_item_id`) USING BTREE ,
INDEX `idx_aris_definition_attrind5` (`language_id`) USING BTREE ,
INDEX `idx_aris_definition_attrind6` (`parent_item_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_fsnode`
-- ----------------------------
DROP TABLE IF EXISTS `aris_fsnode`;
CREATE TABLE `aris_fsnode` (
`id`  varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'newid()' ,
`fs_sheet_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`language_id`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`font_height`  decimal(12,0) NULL DEFAULT NULL ,
`font_width`  decimal(12,0) NULL DEFAULT NULL ,
`font_escapement`  decimal(12,0) NULL DEFAULT NULL ,
`font_orientation`  decimal(12,0) NULL DEFAULT NULL ,
`font_weight`  decimal(12,0) NULL DEFAULT NULL ,
`font_italic`  decimal(5,0) NULL DEFAULT NULL ,
`font_underline`  decimal(5,0) NULL DEFAULT NULL ,
`font_strikeout`  decimal(5,0) NULL DEFAULT NULL ,
`font_charset`  decimal(5,0) NULL DEFAULT NULL ,
`font_outprec`  decimal(5,0) NULL DEFAULT NULL ,
`font_clipprec`  decimal(5,0) NULL DEFAULT NULL ,
`font_quality`  decimal(5,0) NULL DEFAULT NULL ,
`font_pitchandfam`  decimal(5,0) NULL DEFAULT NULL ,
`font_color`  decimal(12,0) NULL DEFAULT NULL ,
`font_facename`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
INDEX `idx_aris_fsnodeind1` (`fs_sheet_id`) USING BTREE ,
INDEX `idx_aris_fsnodeind2` (`language_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_fssheet`
-- ----------------------------
DROP TABLE IF EXISTS `aris_fssheet`;
CREATE TABLE `aris_fssheet` (
`id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`global_id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_default`  decimal(3,0) NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_fssheetind1` (`global_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_fssheet_attr`
-- ----------------------------
DROP TABLE IF EXISTS `aris_fssheet_attr`;
CREATE TABLE `aris_fssheet_attr` (
`id`  varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'newid()' ,
`discriminator`  decimal(12,0) NULL DEFAULT NULL ,
`attr_type_num`  decimal(12,0) NULL DEFAULT NULL ,
`type_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`language_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`parent_item_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`plain_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_tnf_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`styled_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`plain_tnf_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`styled_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`long_value`  decimal(22,0) NULL DEFAULT NULL ,
`double_value`  decimal(20,0) NULL DEFAULT NULL ,
`blob_value`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_fssheet_attrind1` (`parent_item_id`, `attr_type_num`, `language_id`, `type_guid`) USING BTREE ,
INDEX `idx_aris_fssheet_attrind2` (`plain_text_fragment`) USING BTREE ,
INDEX `idx_aris_fssheet_attrind3` (`plain_tnf_fragment`) USING BTREE ,
INDEX `idx_aris_fssheet_attrind4` (`language_id`) USING BTREE ,
INDEX `idx_aris_fssheet_attrind5` (`parent_item_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_group_attr`
-- ----------------------------
DROP TABLE IF EXISTS `aris_group_attr`;
CREATE TABLE `aris_group_attr` (
`id`  varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'newid()' ,
`discriminator`  decimal(12,0) NULL DEFAULT NULL ,
`attr_type_num`  decimal(12,0) NULL DEFAULT NULL ,
`type_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`language_id`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`parent_item_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`plain_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_tnf_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`styled_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`plain_tnf_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`styled_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`long_value`  decimal(22,0) NULL DEFAULT NULL ,
`double_value`  decimal(20,0) NULL DEFAULT NULL ,
`blob_value`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_group_attrind1` (`parent_item_id`, `attr_type_num`, `language_id`, `type_guid`) USING BTREE ,
INDEX `idx_aris_group_attrind2` (`parent_item_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_grouptbl`
-- ----------------------------
DROP TABLE IF EXISTS `aris_grouptbl`;
CREATE TABLE `aris_grouptbl` (
`id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`parent_group_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`global_id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`last_updated`  decimal(22,0) NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_grouptblind1` (`global_id`) USING BTREE ,
INDEX `idx_aris_grouptblind2` (`parent_group_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_lane`
-- ----------------------------
DROP TABLE IF EXISTS `aris_lane`;
CREATE TABLE `aris_lane` (
`id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`model_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`pen_width`  decimal(12,0) NULL DEFAULT NULL ,
`pen_style`  decimal(12,0) NULL DEFAULT NULL ,
`pen_color`  decimal(12,0) NULL DEFAULT NULL ,
`brush_type`  decimal(12,0) NULL DEFAULT NULL ,
`brush_color2`  decimal(12,0) NULL DEFAULT NULL ,
`brush_color`  decimal(12,0) NULL DEFAULT NULL ,
`start_border`  decimal(12,0) NULL DEFAULT NULL ,
`end_border`  decimal(12,0) NULL DEFAULT NULL ,
`type_num`  decimal(12,0) NULL DEFAULT NULL ,
`orientation`  decimal(12,0) NULL DEFAULT NULL ,
`global_id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_laneind1` (`global_id`) USING BTREE ,
INDEX `idx_aris_laneind2` (`model_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_lane_attr`
-- ----------------------------
DROP TABLE IF EXISTS `aris_lane_attr`;
CREATE TABLE `aris_lane_attr` (
`id`  varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'newid()' ,
`discriminator`  decimal(12,0) NULL DEFAULT NULL ,
`attr_type_num`  decimal(12,0) NULL DEFAULT NULL ,
`type_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`language_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`parent_item_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`plain_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_tnf_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`styled_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`plain_tnf_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`styled_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`long_value`  decimal(22,0) NULL DEFAULT NULL ,
`double_value`  decimal(20,0) NULL DEFAULT NULL ,
`blob_value`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_lane_attrind1` (`parent_item_id`, `attr_type_num`, `language_id`, `type_guid`) USING BTREE ,
INDEX `idx_aris_lane_attrind2` (`plain_text_fragment`) USING BTREE ,
INDEX `idx_aris_lane_attrind3` (`plain_tnf_fragment`) USING BTREE ,
INDEX `idx_aris_lane_attrind4` (`language_id`) USING BTREE ,
INDEX `idx_aris_lane_attrind5` (`parent_item_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_model`
-- ----------------------------
DROP TABLE IF EXISTS `aris_model`;
CREATE TABLE `aris_model` (
`id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`last_updated`  decimal(22,0) NULL DEFAULT NULL ,
`global_id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type_num`  decimal(12,0) NULL DEFAULT NULL ,
`group_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`flags`  decimal(12,0) NULL DEFAULT NULL ,
`scale`  decimal(7,0) NULL DEFAULT NULL ,
`max_z_order`  decimal(12,0) NULL DEFAULT NULL ,
`print_scale`  decimal(7,0) NULL DEFAULT NULL ,
`grid_size`  decimal(7,0) NULL DEFAULT NULL ,
`background_color`  decimal(12,0) NULL DEFAULT NULL ,
`attr_handling`  decimal(7,0) NULL DEFAULT NULL ,
`ref_global_id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`biz_model_id`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`arc_radius`  decimal(12,0) NULL DEFAULT NULL ,
`curve_radius`  decimal(12,0) NULL DEFAULT NULL ,
`typ_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`lock_owner`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_modelind1` (`global_id`) USING BTREE ,
INDEX `idx_aris_modelind2` (`ref_global_id`) USING BTREE ,
INDEX `idx_aris_modelind3` (`group_id`) USING BTREE ,
INDEX `idx_aris_modelind4` (`biz_model_id`) USING BTREE ,
INDEX `idx_aris_modelind5` (`lock_owner`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_model_attr`
-- ----------------------------
DROP TABLE IF EXISTS `aris_model_attr`;
CREATE TABLE `aris_model_attr` (
`id`  varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'newid()' ,
`discriminator`  decimal(12,0) NULL DEFAULT NULL ,
`attr_type_num`  decimal(12,0) NULL DEFAULT NULL ,
`type_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`language_id`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`parent_item_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`plain_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_tnf_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`styled_text_fragment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`plain_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`plain_tnf_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`styled_text_clob`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`long_value`  decimal(22,0) NULL DEFAULT NULL ,
`double_value`  decimal(20,0) NULL DEFAULT NULL ,
`blob_value`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_aris_model_attrind1` (`parent_item_id`, `attr_type_num`, `language_id`, `type_guid`) USING BTREE ,
INDEX `idx_aris_model_attrind2` (`plain_text_fragment`) USING BTREE ,
INDEX `idx_aris_model_attrind3` (`plain_tnf_fragment`) USING BTREE ,
INDEX `idx_aris_model_attrind4` (`language_id`) USING BTREE ,
INDEX `idx_aris_model_attrind5` (`parent_item_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `aris_occ`
-- ----------------------------
DROP TABLE IF EXISTS `aris_occ`;
CREATE TABLE `aris_occ` (
`id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`discriminator`  decimal(12,0) NULL DEFAULT NULL ,
`model_id`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`union_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`z_order`  decimal(12,0) NULL DEFAULT NULL ,
`definition_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`flags`  decimal(12,0) NULL DEFAULT NULL ,
`hints`  decimal(12,0) NULL DEFAULT NULL ,
`position_x`  decimal(12,0) NULL DEFAULT NULL ,
`position_y`  decimal(12,0) NULL DEFAULT NULL ,
`size_x`  decimal(12,0) NULL DEFAULT NULL ,
`size_y`  decimal(12,0) NULL DEFAULT NULL ,
`type_num`  decimal(12,0) NULL DEFAULT NULL ,
`symbol_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`pen_width`  decimal(12,0) NULL DEFAULT NULL ,
`pen_style`  decimal(12,0) NULL DEFAULT NULL ,
`pen_color`  decimal(12,0) NULL DEFAULT NULL ,
`brush_type`  decimal(12,0) NULL DEFAULT NULL ,
`brush_color2`  decimal(12,0) NULL DEFAULT NULL ,
`brush_color`  decimal(12,0) NULL DEFAULT NULL ,
`alignment`  decimal(7,0) NULL DEFAULT NULL ,
`external_guid`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`seq_num`  decimal(12,0) NULL DEFAULT NULL ,
`from_obj_occ_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`to_obj_occ_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`points`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`data`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`biz_occ_id`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`src_arrow`  decimal(12,0) NULL DEFAULT NULL ,
`tgt_arrow`  decimal(12,0) NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
INDEX `idx_aris_occind1` (`model_id`) USING BTREE ,
INDEX `idx_aris_occind2` (`union_id`) USING BTREE ,
INDEX `idx_aris_occind3` (`definition_id`) USING BTREE ,
INDEX `idx_aris_occind4` (`from_obj_occ_id`) USING BTREE ,
INDEX `idx_aris_occind5` (`to_obj_occ_id`) USING BTREE ,
INDEX `idx_aris_occind6` (`biz_occ_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=56

;

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
`id`  decimal(22,0) NOT NULL ,
`name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`url`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NULL' ,
`percode`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NULL' ,
`parentid`  decimal(22,0) NULL DEFAULT NULL ,
`parentids`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NULL' ,
`sortstring`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NULL' ,
`available`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `sys_post`
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`post_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dept_id`  bigint(20) NOT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1336

;

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`available`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' ,
`dept_id`  bigint(20) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
`id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`sys_role_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`sys_permission_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`usercode`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`username`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`password`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  date NULL DEFAULT NULL ,
`update_time`  date NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=29

;

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
`id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`role_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Auto increment value for `sys_dept`
-- ----------------------------
ALTER TABLE `sys_dept` AUTO_INCREMENT=56;

-- ----------------------------
-- Auto increment value for `sys_post`
-- ----------------------------
ALTER TABLE `sys_post` AUTO_INCREMENT=1336;

-- ----------------------------
-- Auto increment value for `sys_role`
-- ----------------------------
ALTER TABLE `sys_role` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `sys_user`
-- ----------------------------
ALTER TABLE `sys_user` AUTO_INCREMENT=29;
