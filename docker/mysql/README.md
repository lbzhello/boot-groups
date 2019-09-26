## MySql docker 使用

#### 启动 MySql

```bash
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag

# e.g. 
docker run --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql
```

#### Client 连接 MySql

```bash
docker run -it --network some-network --rm mysql mysql -h some-mysql -u example-user -p
```
