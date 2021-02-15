package br.com.pw.user.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pw.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);

}
