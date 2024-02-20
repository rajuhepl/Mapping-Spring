package com.profile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profile.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	  User findOneByEmailIgnoreCaseAndPassword(String Email, String password);

	  User findByUsername(String username);
	
}
