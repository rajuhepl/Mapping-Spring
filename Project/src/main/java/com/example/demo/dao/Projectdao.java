package com.example.demo.dao;

import java.util.List;

public class Projectdao {

	private Long id;
	private String name;
	
	private List<Taskdao> Projects;
	
	
	public List<Taskdao> getProjects() {
		return Projects;
	}
	public void setProjects(List<Taskdao> projects) {
		Projects = projects;
	}
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
	
	
	 
}
