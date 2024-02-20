package com.profile.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profile.DTO.LoginRequestDto;
import com.profile.DTO.SignUpDto;
import com.profile.DTO.UserInfo;
import com.profile.Repository.UserRepository;
import com.profile.common.JavaUtils;
import com.profile.model.User;

@Service
public class LoginService {
   
	@Autowired
	public UserRepository userrepo;
	
	@Autowired
	private JavaUtils javautils;

	
	//GetMapping
	public List<UserInfo> userdata() {
		List<User> users = userrepo.findAll();
		  List<UserInfo> userlist =  new ArrayList<>();
		for (User user : users) {
		        UserInfo userinfo = new UserInfo(); // Create a new UserInfo object for each user
		        
		        userinfo.setName(user.getName());
		        userinfo.setEmail(user.getEmail());
		        userinfo.setGender(user.getGender());
		        userinfo.setPhoneno(user.getPhoneno());
		        userinfo.setPassword(decryptPassword(user.getPassword()));
		        
		        userlist.add(userinfo);
		    }
		
		return userlist;
		
	}
	
	//Signup code
	public String signup(SignUpDto signupDto) {
		
		
		User UserEntity = new  User();
		UserEntity.setName(signupDto.getName());
		UserEntity.setEmail(signupDto.getEmail());
		UserEntity.setGender(signupDto.getGender());
		UserEntity.setPhoneno(signupDto.getPhoneno());
		UserEntity.setPassword(encryptPassword(signupDto.getPassword()));
		UserEntity.setUsertype(signupDto.getUsertype());
		userrepo.save(UserEntity);
		
		String token = javautils.generateJwt(UserEntity);
		
		return token;
	}
     
	//Login access code
	public String login(LoginRequestDto loginDto) {
		
		User user = userrepo.findOneByEmailIgnoreCaseAndPassword(loginDto.getEmail(),encryptPassword(loginDto.getPassword()));
		if(user == null) {
			return "user not found";
		}
		
		String token = javautils.generateJwt(user);
		return token;
	}
	
	
	public static String encryptPassword(String password) { 
		// Encode the password bytes using Base64       
		byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes());         
		return new String(encodedBytes);     }
	
	
	public static String decryptPassword(String encodedPassword) {    
		// Decode the Base64 encoded password bytes       
		byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword.getBytes());       
		return new String(decodedBytes);     }


}
