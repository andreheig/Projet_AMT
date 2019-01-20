FROM openjdk:8-jdk-alpine

ADD data /opt/src/
WORKDIR /opt/src/

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","swagger-spring-1.0.0.jar"]



