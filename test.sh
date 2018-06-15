#!/bin/bash

var_sql=sql_imgs_1                # Variable holding sql dockerfile name.
var_spr=spring_imgs_1                # Variable holding spring-boot dockerfile name
sql_name=sql_conts_1          # Variable holding the sql container name.
container_name=spring_conts_1     # variable holding spring-boot container name



docker build -f Sqldockerfile -t $var_sql .    # Building the docker image from sql dockerfile
docker build -f dockerfile -t $var_spr .       # Building the docker image from spring-boot dockerfile
docker run -d --name=$sql_name $var_sql        # Running the mysql container in background.
docker ps                                      # To display the active running containers



#Running spring-boot container by mapping the container port 8080 to host port 8080 and linking the sql container to it.
docker run -p 8080:8080 --name $container_name --link $sql_name:mysql -d $var_spr 


#To Display the active running containers
docker ps
