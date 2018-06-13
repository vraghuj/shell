FROM java:8
VOLUME /tmp
ADD /target/pq-metrics-poc.war  pq-metrics-poc.war
RUN bash -c 'touch /pq-metrics-poc.war'
ENTRYPOINT ["java","-jar","/pq-metrics-poc.war"]
