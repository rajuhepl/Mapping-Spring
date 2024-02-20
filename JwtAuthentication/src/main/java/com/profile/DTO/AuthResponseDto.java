package com.profile.DTO;

public class AuthResponseDto {

	 private String accesstoken;
	 private String tokentype = "Bearer ";
	 
	public AuthResponseDto(String accesstoken) {
		super();
		this.accesstoken = accesstoken;
	}

	public String getAccesstoken() {
		return accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}

	public String getTokentype() {
		return tokentype;
	}

	public void setTokentype(String tokentype) {
		this.tokentype = tokentype;
	}
	 
	 
}
