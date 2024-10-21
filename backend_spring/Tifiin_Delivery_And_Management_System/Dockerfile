# Stage 1: Build the JAR file
# Use Eclipse Temurin (OpenJDK) as the base image
FROM eclipse-temurin:21-jdk AS build

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and any other Maven configuration files
COPY pom.xml .

# Download project dependencies (this step is cached unless pom.xml changes)
RUN mvn dependency:go-offline -B

# Copy the entire project source code
COPY . .

# Build the project and create the JAR file
RUN mvn clean package -DskipTests

# Stage 2: Create a minimal container to run the Spring Boot app
# Use OpenJDK 21 as the base image for running the application
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the 'build' stage
COPY --from=build /app/target/Tifiin_Delivery_And_Management_System-0.0.1-SNAPSHOT.jar /app/Tifiin_Delivery_And_Management_System-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8081

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/Tifiin_Delivery_And_Management_System-0.0.1-SNAPSHOT.jar"]

