FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/api-gateway-zull-0.0.1-SNAPSHOT.jar api-gateway-zull.jar
ENTRYPOINT ["java","-jar","/api-gateway-zull.jar"]