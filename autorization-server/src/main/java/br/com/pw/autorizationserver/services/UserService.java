package br.com.pw.autorizationserver.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pw.autorizationserver.entities.User;
import br.com.pw.autorizationserver.feignclients.UserFeignClient;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserFeignClient userFeignClient; 
	
	public User findByEmail(String email) {
		
		User user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("email not found: " + email);
			throw new IllegalArgumentException("Email nao existe: " + email);
		}
		logger.info("email OK found: " + email);
		return user;
	}
	
	
}
