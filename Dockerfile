FROM openjdk:18-jdk-alpine as base
WORKDIR /app
COPY . .
RUN ./mvnw clean package
COPY target/*.jar app.jar

FROM openjdk:18-jdk-alpine
COPY --from=base /app/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]