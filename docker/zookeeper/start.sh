#!/bin/bash

/opt/zookeeper/bin/zkServer.sh start

while true; do echo hello world; sleep 1; done