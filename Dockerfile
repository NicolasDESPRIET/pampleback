#### Stage 1: Build the application
FROM openjdk:11 as build

COPY . .
RUN ./mvnw package -DskipTests

WORKDIR /target

EXPOSE 8105

CMD ["java", "-jar", "pampleback-0.0.1-SNAPSHOT.jar"]