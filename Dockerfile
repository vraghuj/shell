FROM mysql:5.6
MAINTAINER me
ENV MYSQL_DATABASE=lrt_mfstats \
    MYSQL_USER=root \
    MYSQL_ROOT_PASSWORD=root123
ADD lrt_mfstats.sql /docker-entrypoint-initdb.d
EXPOSE 3306
