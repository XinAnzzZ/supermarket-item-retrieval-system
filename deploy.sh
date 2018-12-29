#!/bin/bash

# 此脚本用于重新部署本服务

# 进入到项目目录根目录下
cd /docker/java-service/supermarket-item-retrieval-system

# 拉取最新的代码
git pull origin master

# 重启 docker compose
docker-compose restart