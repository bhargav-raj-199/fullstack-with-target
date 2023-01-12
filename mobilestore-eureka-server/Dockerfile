FROM openjdk:17
EXPOSE 8761
COPY /target/mobilestore-eureka-server.jar eureka.jar
ENTRYPOINT [ "java","-jar","eureka.jar" ]