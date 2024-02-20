package com.profile.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import com.profile.Service.CustomUserDetailService;
import com.profile.common.JavaUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter{
    
	@Autowired
	private JavaUtils javautils;
	
	@Autowired
	private CustomUserDetailService customuserdetail;
	
	
	
	public JwtAuthenticationFilter(JavaUtils javautils, CustomUserDetailService customuserdetail) {
		super();
		this.javautils = javautils;
		this.customuserdetail = customuserdetail;
	}



	


	public JwtAuthenticationFilter() {
		super();
		// TODO Auto-generated constructor stub
	}






	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response, 
			FilterChain filterChain )
			throws ServletException, IOException {
		
		
		String token = generateJwtFromRequest(request);
		try {
			if(StringUtils.hasText(token) && javautils.validation(token)) {
				String username = javautils.extractUserName(token);
				UserDetails userdetail = customuserdetail.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authenticationtoken = new UsernamePasswordAuthenticationToken(
						userdetail , 
						null,
						userdetail.getAuthorities());
				
				authenticationtoken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request) );
				SecurityContextHolder.getContext().setAuthentication(authenticationtoken);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		filterChain.doFilter(request, response);
		
	}



	private String generateJwtFromRequest(HttpServletRequest request) {
		String Bearer = request.getHeader("AUTHORIZATION");
		if(StringUtils.hasText(Bearer) && Bearer.startsWith("Bearer ")) {
		return Bearer.substring(7,Bearer.length());
		}
		return null ;
	}

}
