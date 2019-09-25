FROM openjdk:11-jdk
ADD target/mproduits-0.0.1-SNAPSHOT.jar mproduct.jar
EXPOSE 7832
ENTRYPOINT ["java","-jar","mproduct.jar"]