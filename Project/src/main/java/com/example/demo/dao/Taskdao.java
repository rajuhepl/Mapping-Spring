package com.example.demo.dao;

import com.example.demo.Entity.Person;

public class Taskdao {
	private Long id;
	private String name;
	
	private persondao pd;
	
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
	public persondao getPd() {
		return pd;
	}
	public void setPd(persondao pd) {
		this.pd = pd;
	}
	
	
	
}
