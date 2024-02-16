package com.example.demo.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "companyname")
	private String companyname;
	
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "sysid")
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

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyname=" + companyname + ", System=" + System + "]";
	}
			


}
