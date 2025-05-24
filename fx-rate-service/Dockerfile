FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/fx-rate-service-v1.jar app.jar
EXPOSE 8087
ENTRYPOINT [ "java","-jar","app.jar" ]