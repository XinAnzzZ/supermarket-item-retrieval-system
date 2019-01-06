-- 创建数据库
CREATE DATABASE IF NOT EXISTS sirs
  DEFAULT CHARSET utf8;

-- 使用数据库
USE sirs;

-- 创建用户表
CREATE TABLE user (
  id           VARCHAR(32) PRIMARY KEY
  COMMENT '主键：随机UUID',
  username     VARCHAR(16) UNIQUE NOT NULL
  COMMENT '用户名',
  password     VARCHAR(32)        NOT NULL
  COMMENT '密码',
  phone_number VARCHAR(11) UNIQUE
  COMMENT '手机号',
  email        VARCHAR(32) UNIQUE NOT NULL
  COMMENT '邮箱',
  create_time  DATETIME                    DEFAULT current_timestamp
  COMMENT '创建时间',
  is_del       VARCHAR(3)         NOT NULL DEFAULT 'NO'
  COMMENT '是否删除',
  KEY index_id(create_time, is_del),
  UNIQUE INDEX idx_username(username),
  UNIQUE INDEX idx_phone_number(phone_number),
  UNIQUE INDEX idx_email(email)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '用户表';

