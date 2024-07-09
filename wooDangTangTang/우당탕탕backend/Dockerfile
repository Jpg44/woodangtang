FROM azul/zulu-openjdk-alpine:17
LABEL authors="BHW"

RUN echo "Test..."
COPY build/libs/backend-0.0.1-SNAPSHOT.jar /app/backend.jar
COPY src/main/resources/application.yml /app/application.yml
ENTRYPOINT ["java", "-jar", "/app/backend.jar", "--spring.config.location=/app/application.yml"]