FROM openjdk:8-jdk-alpine
MAINTAINER Narendra jaggi
VOLUME /tmp
COPY target/OrderService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","./app.jar"]