package br.com.pw.payment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class appconfig {
	
	@Bean
	public RestTemplate registerRestTemplate() {
		return new RestTemplate();
	}

}
