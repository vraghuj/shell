#!/bin/bash

var_sql=sql-10
var_spr=spr-10
sql_name=sqldb-10
container_name=madamdb-10



docker build -f Dockerfile -t $var_sql .
docker build -f dockerfile -t $var_spr .
docker run -d --name=$sql_name $var_sql
docker ps
docker run -p 8080:8080 --name $container_name --link $sql_name:mysql -d $var_spr


docker ps


echo "Shell executed successfully"



