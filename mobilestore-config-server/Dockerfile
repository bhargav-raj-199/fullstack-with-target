FROM openjdk:17
EXPOSE 8888
COPY /target/mobilestore-config-server.jar config.jar
ENTRYPOINT [ "java","-jar","config.jar" ]