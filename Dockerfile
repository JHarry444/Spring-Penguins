FROM maven:3.6.3-openjdk-11-slim AS build-stage
COPY . /build
RUN apt update
RUN apt install wget -y
RUN wget https://chromedriver.storage.googleapis.com/90.0.4430.24/chromedriver_linux64.zip
RUN apt install unzip -y
RUN unzip chromedriver* -d /build
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt install ./google-chrome-stable_current_amd64.deb -y

WORKDIR /build
RUN ["mvn", "clean", "package", "-v"]

FROM openjdk:11-slim as run-time
WORKDIR /app
COPY --from=build-stage /build/target/spring-penguins-*.jar /app/spring-penguins.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-penguins.jar"]