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
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
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

-- 商品表

CREATE TABLE product (
  id          VARCHAR(32) PRIMARY KEY
  COMMENT '主键',
  name        VARCHAR(512) NOT NULL
  COMMENT '商品名称',
  price       DOUBLE       NOT NULL
  COMMENT '商品价格',
  stock       INT          NOT NULL
  COMMENT '库存',
  description VARCHAR(512) COMMENT '商品描述',
  status      TINYINT               DEFAULT '0'
  COMMENT '商品状态：0正常 1下架',
  category_id INT          NOT NULL
  COMMENT '类目编号',
  create_time TIMESTAMP    NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  update_time TIMESTAMP             DEFAULT current_timestamp
  COMMENT '更新时间',
  is_del      TINYINT      NOT NULL DEFAULT '0'
  COMMENT '是否删除：0正常 1已删除',
  INDEX idx_product(name, price, stock, description)
)
  COMMENT '商品表';

-- 插入商品
INSERT INTO product (id, name, price, stock, description, category_id)
VALUES ('dabwdibadobudnopwi',
        '联想笔记本电脑E540 ThinkPad',
        3999.99,
        10,
        '联想笔记本电脑，8GB超大运行内存，512GB SDD急速机械硬盘，搭载Win 10操作系统，让你爽上天！！',
        2),
       ('dnwoianpo57fes648g', '小米手机8 XiaoMi 8', 2999, 6, '小米手机，你值得拥有', 2),
       ('dnwoianpdaw57fes648g', '清风面巾纸 4包', 18.8, 83, '清风纸巾，不好吃', 2),
       ('dnwoianpdaw57fdwas648g', '篮球', 188.8, 20, '篮球', 5),
       ('dnwoiandaw57fdwas648g', '枕头 一对', 88.88, 23, '这是一个枕头', 3);

-- 类目表
CREATE TABLE product_category (
  id          INT PRIMARY KEY      AUTO_INCREMENT
  COMMENT '主键',
  name        VARCHAR(32) NOT NULL
  COMMENT '类目名称',
  create_time TIMESTAMP   NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  update_time TIMESTAMP            DEFAULT current_timestamp
  COMMENT '更新时间',
  is_del      TINYINT     NOT NULL DEFAULT '0'
  COMMENT '是否删除：0正常 1已删除',
  UNIQUE INDEX u_idx_name(name)
)
  COMMENT '商品类目表';

-- 插入一些数据
INSERT INTO product_category (name)
VALUES ('日用品'),
       ('数码产品'),
       ('床上用品'),
       ('厨房用品'),
       ('运动'),
       ('书籍'),
       ('家电'),
       ('零食'),
       ('生鲜');
