# Use Java 21 runtime
FROM eclipse-temurin:21-jdk-jammy

# Set working dir
WORKDIR /app

# Copy built jar into container
COPY target/tasks-api-0.0.1-SNAPSHOT.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
