package com.example.demo.Pojo;

import java.util.List;

import com.example.demo.model.Systemss;

public class CompanyDao {
	
	private long id;
	
	private String companyname;
	
	private List<SytemssDao> System;

	
	
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

	public List<SytemssDao> getSystem() {
		return System;
	}

	public void setSystem(List<SytemssDao> system) {
		System = system;
	}

	

	
	
	
	
	
	
}
