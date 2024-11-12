FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/franchise-api-0.0.1-SNAPSHOT.jar /app/franchise-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "franchise-api.jar"]