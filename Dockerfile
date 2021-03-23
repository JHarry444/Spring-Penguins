FROM maven:3.6.3-openjdk-11-slim AS build-stage
COPY . /build
WORKDIR /build
RUN mvn package

FROM openjdk:11-slim as run-time
WORKDIR /app
COPY --from=build-stage /build/target/spring-penguins-*.jar /app/spring-penguins.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-penguins.jar"]