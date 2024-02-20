package com.profile.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String gender;
	private String email;
	private String Phoneno;
	private String username;
	
	
	private String usertype ;
	private String password;
	private boolean isActive = true;
	private Integer loginCount;
	private String ssoType;
	private Date  loginAt;
	private Date  createdAt;
	private Date  updatedAt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return Phoneno;
	}
	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	public String getSsoType() {
		return ssoType;
	}
	public void setSsoType(String ssoType) {
		this.ssoType = ssoType;
	}
	public Date getLoginAt() {
		return loginAt;
	}
	public void setLoginAt(Date loginAt) {
		this.loginAt = loginAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	public void OnSave() {
		Date currentDate = new Date();
		
		
			this.createdAt =  currentDate;
		
		this.updatedAt = currentDate;
	}
	
	@PostPersist
	public void OnUpdate() {
		Date currentDate = new Date();
		this.updatedAt = currentDate;
	}
	public User(String username, String usertype, String password) {
		super();
		this.username = username;
		this.usertype = usertype;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	}
	


