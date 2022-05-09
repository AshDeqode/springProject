FROM openjdk:11

ADD target/springboot-mongo-docker.jar springboot-docker-demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
