FROM openjdk:11
VOLUME /tmp
ADD ./target/autorization-server-0.0.1-SNAPSHOT.jar autorization-server.jar
ENTRYPOINT ["java","-jar","/autorization-server.jar"]