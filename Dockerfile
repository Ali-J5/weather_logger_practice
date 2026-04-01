#To run this java app, docker must do these step by step

# Step 1: Install java 21 so computer can run the code
FROM eclipse-temurin:21-jdk

# Step 2: Set a folder to hold and run the app in
WORKDIR /app

# Step 3: Copy the compiled Java file (the JAR) into the container
COPY target/microservice-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Tell the container to expose port 8080. Allows and unblocks traffic on port 8080
EXPOSE 8080

# Step 5: Open terminal, Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]