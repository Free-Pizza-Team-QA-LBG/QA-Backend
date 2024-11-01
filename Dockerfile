# Maven build
FROM maven:3.8.6 AS build
WORKDIR /QA-Backend
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Package
FROM openjdk:17-jdk-alpine
WORKDIR /QA-Backend
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
