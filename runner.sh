#!/bin/bash

sleep 40s &&  # Making the script sleep for 40sec and Run the following commands after sleep

DB_USER='root';         # Variable holding the username of  mysql
DB_PASSWD='root123';    # Variable holding the Password of  mysql 
DB_HOST='172.17.0.2';    # Mysql container IP as Host to connect.
DB_NAME='lrt_mfstats';  # Database Name in the mysql
TABLE='20180507_tfp_gaps_index';    # Table in the database.


#mysql commands


# Running a while loop infintely to insert the data 
while true
do
#Inserting data into table
mysql --user=$DB_USER --password=$DB_PASSWD $DB_NAME -h $DB_HOST -e "INSERT INTO $TABLE VALUES (UNIX_TIMESTAMP(now()) ,'cert_pa','cert_pa',FLOOR(1 + (RAND() * 9999)),FLOOR(1 + (RAND() * 9999)),FLOOR(1 + (RAND() * 9999)))"

# Pause the insertion of data into the table for 10 sec
sleep 10s  

done
