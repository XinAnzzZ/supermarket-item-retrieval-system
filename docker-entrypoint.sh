#!/bin/bash

cd /usr/src/mymaven
mvn clean install -Dmaven.test.skip
cd ./target
java -jar -Dserver.port=9002 -Dspring.datasource.druid.password=xinan sirs-0.0.1-SNAPSHOT.jar