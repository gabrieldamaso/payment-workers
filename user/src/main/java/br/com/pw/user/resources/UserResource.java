package br.com.pw.user.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pw.user.entities.User;
import br.com.pw.user.repositorys.UserRepository;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private static Logger logger = LoggerFactory.getLogger(UserResource.class);
	
	private final UserRepository userRepository;

	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User user = userRepository.findById(id).get();
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		
		User user = userRepository.findByEmail(email);
		
		return ResponseEntity.ok(user);
	}
	
}
