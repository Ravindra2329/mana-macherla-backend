# Use Java 17 with Maven included
FROM maven:3.9.6-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build Spring Boot application
RUN mvn clean package -DskipTests

# Run the app
CMD ["java", "-jar", "target/*.jar"]
