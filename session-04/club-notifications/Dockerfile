FROM openjdk:11-jre-slim

MAINTAINER Abel Martell

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
