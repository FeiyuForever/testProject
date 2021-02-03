#!/bin/bash
appserver=Java_MavenProject
pid=`sudo -u root ps -ef|grep ${appserver} |grep -v grep|awk '{print $2}'`
if [ "$pid" != "" ]; then
  echo "kill ${appserver}: $pid"
  kill -9 $pid
else
  echo "${appserver} is not running."
fi
