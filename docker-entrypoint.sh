#!/bin/bash

echo "redeploy"

cd /usr/src/mymaven
mvn clean install -Dmaven.test.skip
cd ./target
java -jar -Dserver.port=9002 supermarket-item-retrieval-system-0.0.1-SNAPSHOT.jar