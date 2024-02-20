package com.profile.common;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.profile.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JavaUtils {
    
	   @Value("${secret.key}")
	    private String SECRET_KEY;
	
	
	private static long expiryDuration = 86400;
	
	private static final String key = "gergregrwge";
	
	
	public String generateJwt(User user) { 
		
		long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);
		
		Claims claim = Jwts.claims();
		claim
		.setIssuer(user.getId().toString())
		.setIssuedAt(issuedAt)
		.setExpiration(expiryAt)
		.setSubject(user.getUsertype());
		
		
		claim.put("email",user.getEmail());
		claim.put("name", user.getName());
		
		
		return Jwts.builder()
				.setClaims(claim)
				.signWith(SignatureAlgorithm.HS512,SECRET_KEY)
				.compact();
	}
	public String generateToken(Authentication authentication) {
		
		long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;
		Date expiryAt = new Date(expiryTime);
		String username = authentication.getName();
		
		
		
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt( new Date())
				.setExpiration(expiryAt)
				.signWith(SignatureAlgorithm.HS512,key)
				.compact();
		System.out.println("New token :");
		System.out.println(token);
		return token;
	}
	
	public String getRoleFromToken(String token) throws Exception {
        return Verify(token).getSubject();
    }
	
	public String getEmailFromToken(String token) throws Exception {
        return Verify(token).get("email",String.class);
    }
	
	public Claims Verify (String auth) throws Exception {
		
		try {
		return	Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(auth).getBody();
		} catch (Exception e) {
			throw new AccessDeniedException("Access Denied");
		}
		
	}

	 private boolean isTokenExpired(String token) throws Exception {
			
			return isExpiration(token).before(new Date());
		}
	 private Date isExpiration(String token) throws Exception {
			
			return Verify(token).getExpiration();
		}
	public String extractUserName(String token) throws Exception {
		 return Verify(token).get("email",String.class);
	}

	public boolean isTokenValid(String token, UserDetails userdetail) throws Exception {
		final String username = extractUserName(token);
		return (username.equals(userdetail.getUsername())) && !isTokenExpired(token);
	
	}
   
public boolean validation (String token) throws Exception {
		
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
			return true;
		} catch (Exception e) {
			throw new AccessDeniedException("Access Denied" + e.fillInStackTrace());
		}
		
	}
	
}
