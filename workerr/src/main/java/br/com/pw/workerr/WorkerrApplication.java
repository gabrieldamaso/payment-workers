package br.com.pw.workerr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WorkerrApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkerrApplication.class, args);
	}

}
