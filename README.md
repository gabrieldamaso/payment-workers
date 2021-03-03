
## Comandos Docker
#### Criar uma rede Docker
```
docker network create <nome-da-rede>
```
#### Baixar imagem do Dockerhub
```
docker pull <nome-da-imagem:tag>
```
#### Ver imagens
```
docker images
```
#### Rodar um container de uma imagem
```
docker run -p <porta-externa>:<porta-interna> --name <nome-do-container> --network <nome-da-rede> <nome-da-imagem:tag> 
```
#### Listar containers
```
docker ps
docker ps -a
```
#### Acompanhar logs do container em execução
```
docker logs -f <container-id>
```

## Criar rede docker para sistema hr
```
docker network create hr-net
```

## Postgresql
```
$ docker pull postgres:12-alpine

container postgress do workker 
$ docker run -p 5432:5432 --name worker-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_worker postgres:12-alpine
  
container postgress do user
$ docker run -p 5432:5432 --name user-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_user postgres:12-alpine
  
```


## config-server
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT ["java","-jar","/config-server.jar"]
``` 
```
mvnw clean package
docker build -t config-server:v1 .
docker run -p 8888:8888 --name config-server --network hr-net -e GITHUB_USER= -e GITHUB_PASS= config-server:v1
```

## eureka-server
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD ./target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]
``` 
```
mvnw clean package
docker build -t eureka-server:v1 .
docker run -p 8761:8761 --name eureka-server --network hr-net eureka-server:v1
```

## workerr
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/workerr-0.0.1-SNAPSHOT.jar workerr.jar
ENTRYPOINT ["java","-jar","/workerr.jar"]
``` 
```
mvnw clean package -DskipTests
docker build -t workerr:v1 .
docker run -P --network hr-net workerr:v1
```


## user
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/user-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java","-jar","/user.jar"]
``` 
```
mvnw clean package -DskipTests
docker build -t user:v1 .
docker run -P --network hr-net user:v1
```

## payment
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/payment-0.0.1-SNAPSHOT.jar payment.jar
ENTRYPOINT ["java","-jar","/payment.jar"]
``` 
```
mvnw clean package -DskipTests
docker build -t payment:v1 .
docker run -P --network hr-net payment:v1
```
