FROM openjdk:17-jdk

ARG JAR_FILE=jul-api-main.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
