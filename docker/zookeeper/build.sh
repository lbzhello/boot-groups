#!/bin/bash

workdir=/home/zookeeper
zk_path=/opt/zookeeper
mkdir -p ${zk_path}

curl -o $workdir/zookeeper.tar.gz https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/current/apache-zookeeper-3.5.5-bin.tar.gz
tar -zxf $workdir/zookeeper.tar.gz -C ${zk_path} --strip-components 1

cp $workdir/zoo.cfg $zk_path/conf/