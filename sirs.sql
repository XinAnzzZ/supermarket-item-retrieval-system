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
  INDEX index_id(create_time),
  UNIQUE INDEX idx_username(username),
  UNIQUE INDEX idx_phone_number(phone_number),
  UNIQUE INDEX idx_email(email)
)
  COMMENT '用户表';

-- 创建角色表
CREATE TABLE role (
  id          INT PRIMARY KEY             AUTO_INCREMENT
  COMMENT '数据量小直接使用自增',
  role_name   VARCHAR(16) UNIQUE NOT NULL
  COMMENT '角色名称',
  description TEXT COMMENT '描述',
  create_time DATETIME           NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间',
  is_del      VARCHAR(3)         NOT NULL DEFAULT 'NO'
  COMMENT '是否删除',
  INDEX index_role(create_time),
  UNIQUE INDEX idx_role_name(role_name)
)
  COMMENT '角色表';

-- 用户角色表
CREATE TABLE user_role (
  id      VARCHAR(32) PRIMARY KEY
  COMMENT '主键',
  user_id VARCHAR(32) NOT NULL
  COMMENT '用户id',
  role_id INT         NOT NULL
  COMMENT '角色id',
  INDEX idx_user_role(user_id, role_id)
)
  COMMENT '用户角色表';