FROM maven:3.9.4-eclipse-temurin-17 as build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM gcr.io/distroless/java17
WORKDIR /app
COPY --from=build /app/target/task-manager-ecs-0.0.1-SNAPSHOT.jar task-manager-ecs.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "task-manager-ecs.jar"]