# Use an official Java image as the base
FROM openjdk:11-jdk

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory to /app

WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:resolve

# Copy the application code
COPY . .

# Build the application
RUN mvn clean package

# Expose the port the application will run on
EXPOSE 8080

# Set environment variables for the application
ENV MYSQL_HOST=mysqlcontainer
ENV MYSQL_PORT=3306
ENV MYSQL_DB_Name=base
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root

# Run the command to start the application
CMD ["java", "-jar", "target/Doctor_appointment-0.0.1-SNAPSHOT.jar"]
