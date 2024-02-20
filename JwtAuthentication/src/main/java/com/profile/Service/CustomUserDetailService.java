package com.profile.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.profile.Repository.UserRepository;
import com.profile.model.User;

@Service
public class CustomUserDetailService {
	 private UserRepository userRepository;

	    @Autowired
	    public CustomUserDetailService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username);
	        return (UserDetails) new User(user.getUsername(), user.getPassword(), user.getUsertype());
	    }


}
