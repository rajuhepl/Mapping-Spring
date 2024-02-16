package com.example.demo.Pojo;

import java.util.List;

import com.example.demo.model.Systemss;

public class Company {
	
	private long id;
	
	private String companyname;
	
	private List<Systemss> System;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public List<Systemss> getSystem() {
		return System;
	}

	public void setSystem(List<Systemss> system) {
		System = system;
	}

	
	
	
	
	
	
}
