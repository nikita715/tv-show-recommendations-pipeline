FROM gradle:8.10-jdk21 AS build

WORKDIR /app
COPY . .

RUN gradle clean shadowJar

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

ENV KAFKA_BOOTSTRAP_SERVERS="recommendations-pipeline-kafka:9092"
ENV SCHEMA_REGISTRY_URL="http://recommendations-pipeline-schema-registry:8081"

ENTRYPOINT ["java", "-jar", "app.jar"]
