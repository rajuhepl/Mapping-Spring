package com.profile.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profile.DTO.LoginRequestDto;
import com.profile.DTO.SignUpDto;
import com.profile.DTO.UserInfo;
import com.profile.Service.LoginService;
import com.profile.common.JavaUtils;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	public LoginService logservice;
	
	@Autowired
	private JavaUtils javautils;
	
	@PostMapping("/signup")
	public String signup (@RequestBody SignUpDto signupDto) {
		return logservice.signup(signupDto);
		
	}

	@PostMapping("/login")
	public String login (@RequestBody LoginRequestDto loginDto) {
		return logservice.login(loginDto);
		
	}
	@GetMapping("/privateapi")
	public List<UserInfo> authorization(@RequestHeader(name="auth")String auth) throws Exception {
		
	
		
		javautils.Verify(auth);
		
		return logservice.userdata();
	}
	@GetMapping("/privateai")
	public String test(){
				
		return "accessed";
	}


}
