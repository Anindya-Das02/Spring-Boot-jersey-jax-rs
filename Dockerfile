# Installing java 11
FROM openjdk:11

ARG APP_HOME="/app/"

# Create '/app' directory
RUN mkdir ${APP_HOME}

# Copying the local jar to image into /app directory
COPY target/das-jersey-app-0.0.1-SNAPSHOT.jar ${APP_HOME}/das-jersey-app-0.0.1-SNAPSHOT.jar

# Move inside /app directory. Expose application port 8080
WORKDIR ${APP_HOME}
EXPOSE 8080

# Running the spring boot application
CMD ["java", "-jar", "das-jersey-app-0.0.1-SNAPSHOT.jar"]