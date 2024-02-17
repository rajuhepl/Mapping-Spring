package com.example.demo.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Task")
public class ProjectTask {
	// Task.java

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Long id;
	    @Column(name="taskname")
	    private String name;
	    
	  
	    
	    @ManyToOne(cascade = CascadeType.ALL	)
	    @JoinColumn(name = "person_id")
	    private Person p;

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

		public Person getProject() {
			return p;
		}

		public void setProject(Person project) {
			this.p = project;
		}

	    
	}


