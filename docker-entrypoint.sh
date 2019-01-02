#!/bin/bash

cd /usr/src/mymaven
mvn clean install -Dmaven.test.skip
cd ./target
java -jar -Dserver.port=9002 -Dspring.datasource.druid.password=xinan supermarket-item-retrieval-system-0.0.1-SNAPSHOT.jar