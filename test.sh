#!/bin/bash

var_sql=sql-441                # Variable holding sql dockerfile name.
var_spr=spr-441                # Variable holding spring-boot dockerfile name
sql_name=sqldb-441             # Variable holding the sql container name.
container_name=madamdb-441     # variable holding spring-boot container name



docker build -f Sqldockerfile -t $var_sql .    # Building the docker image for the sql dockerfile
docker build -f dockerfile -t $var_spr .       # Building the docker image for the spring-boot dockerfile
docker run -d --name=$sql_name $var_sql        # Running the mysql container in background.
docker ps                                      # To display the active running containers



#Mapping the container port 8080 to host port 8080 and linking the sql and spring-boot containers and running them.
docker run -p 8080:8080 --name $container_name --link $sql_name:mysql -d $var_spr 


#To Display the active running containers
docker ps
