FROM java:8

ADD target/*.jar idea-docker-deploy.jar

EXPOSE 8765

ENTRYPOINT ["java", "-jar", "idea-docker-deploy.jar"]