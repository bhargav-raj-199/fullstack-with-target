FROM openjdk:17
EXPOSE 9000
COPY /target/mobilestore-gateway.jar gateway.jar
ENTRYPOINT [ "java","-jar","gateway.jar" ]