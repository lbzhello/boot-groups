#!/usr/bin/env bash

# author lbzhello@qq.com
# create 2019-10-09
# nginx docker 构建脚本

# 安装依赖
sudo apt install curl gnupg2 ca-certificates lsb-release

# 添加 apt 包
echo "deb http://nginx.org/packages/ubuntu `lsb_release -cs` nginx" \
    | sudo tee /etc/apt/sources.list.d/nginx.list