FROM openjdk:11
ADD target/ReadingIsGood-1.0.0.jar ReadingIsGood-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ReadingIsGood-1.0.0.jar"]
