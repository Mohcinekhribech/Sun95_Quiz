FROM postgres:latest

ENV POSTGRES_PASSWORD=1832003
ENV POSTGRES_DB=sunquiz
ENV POSTGRES_USER=postgres

EXPOSE 5432

FROM openjdk:21

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]