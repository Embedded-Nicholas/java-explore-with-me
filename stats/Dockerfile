FROM amazoncorretto:21
COPY server/target/*.jar stats.jar
ENTRYPOINT ["java","-jar","/stats.jar"]