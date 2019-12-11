/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 15.0 		*/
/*  Created On : 11-12月-2019 11:33:33 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0
; 
/* Drop Tables */

DROP TABLE IF EXISTS `base_menu` CASCADE
;

DROP TABLE IF EXISTS `base_role` CASCADE
;

DROP TABLE IF EXISTS `base_role_menu` CASCADE
;

DROP TABLE IF EXISTS `base_user_role` CASCADE
;

DROP TABLE IF EXISTS `base_usr` CASCADE
;

/* Create Tables */

CREATE TABLE `base_menu`
(
	`ord` BIGINT NOT NULL COMMENT 'ord',
	`code` NVARCHAR(50) NULL COMMENT '编码',
	`menu_name` NVARCHAR(200) NOT NULL COMMENT '菜单名称',
	`deep` INT NOT NULL DEFAULT 1 COMMENT '菜单深度',
	`status` INT NOT NULL DEFAULT 0 COMMENT '状态（0--正常，1--停用）',
	`is_end_node` INT NOT NULL DEFAULT 1 COMMENT '是否叶子节点（1--是，0不是）',
	`menu_url` NVARCHAR(200) NOT NULL DEFAULT / COMMENT '菜单url',
	`creater` BIGINT NULL COMMENT '创建人',
	`create_time` DATETIME NULL COMMENT '创建时间',
	`update_user` BIGINT NULL COMMENT '修改人',
	`update_time` DATETIME NULL COMMENT '修改时间',
	CONSTRAINT `PK_base_menu` PRIMARY KEY (`ord` ASC)
)
COMMENT = '菜单表，存储菜单项和菜单url'

;

CREATE TABLE `base_role`
(
	`ord` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
	`code` NVARCHAR(50) NULL COMMENT '编码',
	`role_name` NVARCHAR(50) NOT NULL COMMENT '角色名',
	`status` INT NOT NULL DEFAULT 0 COMMENT '状态（0--正常，1--停用）',
	`sort` INT NULL DEFAULT 1 COMMENT '排序',
	`create_time` DATETIME(4) NOT NULL COMMENT '创建时间',
	`create_user` BIGINT NULL COMMENT '创建人',
	`update_time` DATETIME NULL COMMENT '修改时间',
	`update_user` BIGINT NULL COMMENT '修改人',
	CONSTRAINT `PK_base_role` PRIMARY KEY (`ord` ASC)
)
COMMENT = '角色表，存储角色信息'

;

CREATE TABLE `base_role_menu`
(
	`ord` BIGINT NOT NULL AUTO_INCREMENT,
	`role_id` BIGINT NULL,
	`menu_id` BIGINT NULL,
	`creater` BIGINT NULL,
	`create_time` DATETIME NULL,
	CONSTRAINT `PK_base_role_menu` PRIMARY KEY (`ord` ASC)
)
COMMENT = '角色菜单表,这张表里有即为有权限'

;

CREATE TABLE `base_user_role`
(
	`ord` BIGINT NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT NOT NULL,
	`role_id` BIGINT NOT NULL,
	`creater` BIGINT NULL,
	`create_time` DATETIME NULL,
	CONSTRAINT `PK_base_user_role` PRIMARY KEY (`ord` ASC)
)
COMMENT = '用户角色表'

;

CREATE TABLE `base_usr`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
	`code` NVARCHAR(50) NOT NULL COMMENT '用户编码',
	`user_name` NVARCHAR(200) NOT NULL COMMENT '用户名',
	`user_phone` NVARCHAR(200) NULL COMMENT '电话',
	`user_email` NVARCHAR(200) NULL COMMENT '邮箱',
	`user_password` NVARCHAR(200) NOT NULL COMMENT '密码',
	`status` INT NOT NULL DEFAULT 0 COMMENT '状态',
	`creater` BIGINT NULL COMMENT '创建人',
	`create_time` DATETIME NULL COMMENT '创建时间',
	`update_user` BIGINT NULL COMMENT '修改人',
	`update_time` DATETIME NULL COMMENT '修改时间',
	`last_login_ip` VARCHAR(100) NULL COMMENT '最后登录ip',
	`last_login_time` DATETIME NULL COMMENT '最后登录时间',
	`login_count` INT NULL COMMENT '登录次数',
	`is_lock_ip` INT NULL DEFAULT 0 COMMENT '是否锁定登录IP（0--不锁定）',
	`lock_ip1` NVARCHAR(100) NULL COMMENT '绑定的ip1',
	`lock_ip2` NVARCHAR(100) NULL COMMENT '绑定的ip2',
	`is_admin` INT NOT NULL DEFAULT 0 COMMENT '是否超级管理员（0--不是）',
	CONSTRAINT `PK_usr` PRIMARY KEY (`id` ASC)
)
COMMENT = '用户表，存储用户信息'

;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE `base_role_menu` 
 ADD INDEX `IXFK_base_role_menu_base_menu` (`menu_id` ASC)
;

ALTER TABLE `base_role_menu` 
 ADD INDEX `IXFK_base_role_menu_base_role` (`role_id` ASC)
;

ALTER TABLE `base_user_role` 
 ADD INDEX `IXFK_base_user_role_base_role` (`role_id` ASC)
;

ALTER TABLE `base_user_role` 
 ADD INDEX `IXFK_base_user_role_base_usr` (`user_id` ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE `base_role_menu` 
 ADD CONSTRAINT `FK_base_role_menu_base_menu`
	FOREIGN KEY (`menu_id`) REFERENCES `base_menu` (`ord`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `base_role_menu` 
 ADD CONSTRAINT `FK_base_role_menu_base_role`
	FOREIGN KEY (`role_id`) REFERENCES `base_role` (`ord`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `base_user_role` 
 ADD CONSTRAINT `FK_base_user_role_base_role`
	FOREIGN KEY (`role_id`) REFERENCES `base_role` (`ord`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `base_user_role` 
 ADD CONSTRAINT `FK_base_user_role_base_usr`
	FOREIGN KEY (`user_id`) REFERENCES `base_usr` (`id`) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1
; 