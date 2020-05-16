FROM tomcat:9.0.34-jdk14-openjdk-oracle

MAINTAINER "Tim Schwaiba"

EXPOSE 8080
# Transfer our WAR


RUN rm -rf /usr/local/tomcat/webapps/*

COPY ./target/untitled.war /usr/local/tomcat/webapps/untitled.war
COPY ./target/untitled /usr/local/tomcat/webapps/untitled
CMD ["catalina.sh", "run"]


