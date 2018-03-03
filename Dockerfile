FROM openjdk:8-jdk-alpine
ADD target/ePrescriptions-0.0.1-SNAPSHOT.jar ePrescriptions-0.0.1-SNAPSHOT.jar
EXPOSE 8080:9080
ENTRYPOINT ["java", "-jar", "ePrescriptions-0.0.1-SNAPSHOT.jar"]