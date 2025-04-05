# Start from a Java 17 JDK base image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy build output from your machine into container
COPY build/libs/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
