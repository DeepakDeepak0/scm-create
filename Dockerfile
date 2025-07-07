FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/scm-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java" , "-jar", "app-jar"]

