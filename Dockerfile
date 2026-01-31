# Use Java 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Build application
RUN ./mvnw clean package -DskipTests

# Run jar
CMD ["java", "-jar", "target/*.jar"]
