# Package
FROM amazoncorretto:17.0.7-alpine
WORKDIR /QA-Backend
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
