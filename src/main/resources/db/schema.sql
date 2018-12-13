DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username`        varchar(50)  NOT NULL COMMENT '用户名',
  `password`        varchar(255) NOT NULL COMMENT '加密后的密码',
  `salt`            varchar(255) NOT NULL COMMENT '加密使用的盐',
  `sex`             tinyint(1) COMMENT '性别，1：男，2：女',
  `email`           varchar(255) NOT NULL COMMENT '邮箱',
  `phone_number`    varchar(15)  NOT NULL COMMENT '手机号码',
  `status`          tinyint(1) NOT NULL COMMENT '状态，-1：逻辑删除，1：禁用，2：启用',
  `create_time`     bigint(20) NOT NULL COMMENT '创建时间',
  `last_login_time` bigint(20) DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='账户表';

DROP TABLE IF EXISTS `account_record`;
CREATE TABLE `account_record` (
  `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id`      bigint(20) NOT NULL COMMENT '账户Id',
  login_address     VARCHAR(255) COMMENT '登录地址',
  login_type        tinyint(1) NOT NULL COMMENT '登录类型，1：PC，2：手机',
  login_device_name VARCHAR(255) COMMENT '登录设备名称',
  `create_time`     bigint(20) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='账户记录表';
