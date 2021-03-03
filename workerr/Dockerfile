FROM openjdk:11
VOLUME /tmp
ADD ./target/workerr-0.0.1-SNAPSHOT.jar workerr.jar
ENTRYPOINT ["java","-jar","/workerr.jar"]