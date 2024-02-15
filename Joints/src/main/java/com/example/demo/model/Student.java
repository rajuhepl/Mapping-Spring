package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "student")

public class Student {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "student_course",
	            joinColumns = @JoinColumn(name = "student_id"),
	            inverseJoinColumns = @JoinColumn(name = "course_id"))
	    private Set<Course> courses = new HashSet<>();

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

		public Set<Course> getCourses() {
			return courses;
		}

		public void setCourses(Set<Course> courses) {
			this.courses = courses;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", courses=" + courses + "]";
		}
	    
		

}
