FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/spring-postgres-docker-1.0-SNAPSHOT.jar spring-postgres-docker.jar
ENTRYPOINT ["java", "-jar", "spring-postgres-docker.jar"]