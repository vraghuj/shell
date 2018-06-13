#!/bin/bash

var_sql=sql-440
var_spr=spr-440
sql_name=sqldb-440
container_name=madamdb-440



docker build -f Sqldockerfile -t $var_sql .
docker build -f dockerfile -t $var_spr .
docker run -d --name=$sql_name $var_sql
docker ps
docker run -p 8080:8080 --name $container_name --link $sql_name:mysql -d $var_spr


docker ps
