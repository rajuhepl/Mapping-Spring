package com.example.demo.Entity;

import java.util.ArrayList;
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
@Table(name="project")
public class Projectentity {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Long id;
	    @Column(name="proname")
	    private String name;
	    
	    @OneToMany( cascade = CascadeType.ALL)
	    @JoinColumn(name="Projectentity_id")
	    private List<ProjectTask> tasks = new ArrayList<>();

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

		public List<ProjectTask> getTasks() {
			return tasks;
		}

		public void setTasks(List<ProjectTask> tasks) {
			this.tasks = tasks;
		}

	    
	}


