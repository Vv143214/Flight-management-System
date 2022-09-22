FROM openjdk:8-jdk-alpine

EXPOSE 8080

COPY FMS/target/*.jar .

ENTRYPOINT ["java"]

CMD ["-jar", "spring-boot-docker.jar"]


