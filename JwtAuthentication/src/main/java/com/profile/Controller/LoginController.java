package com.profile.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profile.DTO.AuthResponseDto;
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
	
	@Autowired
	private AuthenticationManager authenticateManager ;
	
	
	/*
	 * public LoginController(LoginService logservice, JavaUtils javautils,
	 * AuthenticationManager authenticatemanager) { super(); this.logservice =
	 * logservice; this.javautils = javautils; this.authenticatemanager =
	 * authenticatemanager; }
	 */

	@PostMapping("/signup")
	public String signup (@RequestBody SignUpDto signupDto) {
		return logservice.signup(signupDto);
		
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponseDto> login (@RequestBody LoginRequestDto loginDto) {
		Authentication auth = new authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()));
		 SecurityContextHolder.getContext().setAuthentication(auth);
		String token = javautils.generateJwt(auth);
		return new ResponseEntity<>(new AuthResponseDto(token),HttpStatus.OK);
		
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
