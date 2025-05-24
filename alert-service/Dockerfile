FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/alert-service-v1.jar app.jar
EXPOSE 8088
ENTRYPOINT [ "java","-jar","app.jar" ]