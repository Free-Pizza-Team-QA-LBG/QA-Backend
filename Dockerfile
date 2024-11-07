# Package
FROM openjdk:17-jdk-alpine
WORKDIR /QA-Backend
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]