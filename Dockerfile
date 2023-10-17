FROM openjdk:17

WORKDIR /app

ARG JAR_FILE

COPY ${JAR_FILE} eazyschool.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/eazyschool.jar"]