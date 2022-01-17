FROM openjdk:11
ADD target/ReadingIsGood-2.5.6.jar ReadingIsGood-2.5.6.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ReadingIsGood-2.5.6.jar"]
