#!/bin/bash


DB_USER='root';
DB_PASSWD='root123';
DB_HOST='172.17.0.2'
DB_NAME='lrt_mfstats';
TABLE='20180507_tfp_gaps_index';


#mysql commands



while true
do

mysql --user=$DB_USER --password=$DB_PASSWD $DB_NAME -h $DB_HOST -e "INSERT INTO $TABLE VALUES (UNIX_TIMESTAMP(now()) ,'cert_pa','cert_pa',FLOOR(1 + (RAND() * 9999)),FLOOR(1 + (RAND() * 9999)),FLOOR(1 + (RAND() * 9999)))"
mysql --user=$DB_USER --password=$DB_PASSWD $DB_NAME -e "DO SLEEP(10)"

done
