#!/bin/bash
export LD_LIBRARY_PATH=/feiyu
nohup java -jar -server -Xms256M -Xmx512M -XX:PermSize=64M -XX:MaxPermSize=256M Java_MavenProject-1.0-SNAPSHOT.jar > Java_MavenProject.log 2>&1 &