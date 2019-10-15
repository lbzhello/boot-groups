# 采薇微服务系统

## 项目结构

```yaml
caiwei
  - caiwei-api 接口模块
    - user-api 用户接口
    - blog-api 博客接口
    - ... ...
  - caiwei-service 服务提供者
    - user-service 用户服务
    - blog-service 博客服务
    - ... ...
  - caiwei-web 服务消费者
  - caiwei-docker docker 服务器环境搭建及配置
  - caiwei-react react 前端
  - ... 项目无关
```

## 环境

#### 开发环境
- Docker 19.03.02 
- IDEA 2019.1.3
- java12  
- spring-boot 2.1.4
- dubbo 2.7.3

#### 服务器环境
- MySQL 8.0.17
- Zookeeper 3.5.5
- Nginx 1.17.4

## 启动

### 服务器

|#|端口|
|---|---|
|MySQL |3306|
|Zookeeper |2181|
|Nginx |80|

```bash
git clone https://github.com/lbzhello/caiwei.git
cd caiwei/caiwei-docker

docker pull zookeeper
# 这里为了练手，自己构建了 zookeeper 镜像, 当然也可以使用官方镜像
# 注意名字要和 caiwei-docker/docker-compose.yml 一致
docker build -f zookeeper/Dockerfile -t liubaozhu/zookeeper .

docker pull mysql

# nginx 可以不配置
docker pull nginx

docker-compose up -d
```

#### 后端

1. git clone https://github.com/lbzhello/caiwei.git
2. IDEA 打开 Maven 项目
3. 启动 caiwei-service 下面的各个服务提供者。
即各服务跟目录下命名 *ServiceApplication 的类。

4. 启动 caiwei-web 根目录下的 WebApplication 类，作为服务消费者。
默认端口 8080, api 可查看各 Controller。

5. 运行 caiwei-service 下各服务模块 resources/sql 目录下的 SQL 脚本。

注:  
可以运行 caiwei-web 模块 resources/sql 下的 SQL 脚本，创建一些测试数据。

如果只需要 rest api 启动前面的即可，下面配置可以启动 nginx 负载，
和 react + antd 前端页面。

#### 前端

```bash
# 条件
# 1. 按照上面的配置启动 nginx 容器
# 2. 按照上面的步骤启动 caiwei-web

cd caiwei/caiwe-react
yarn build
```

访问 80 端口
