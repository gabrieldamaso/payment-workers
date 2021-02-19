package br.com.pw.autorizationserver.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pw.autorizationserver.entities.User;
import br.com.pw.autorizationserver.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

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


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		if(user == null) {
			logger.error("email not found: " + username);
			throw new UsernameNotFoundException("Email nao existe: " + username);
		}
		logger.info("email OK found: " + username);
		return user;
	}
	
	
}
