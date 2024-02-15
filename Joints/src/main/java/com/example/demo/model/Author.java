package com.example.demo.model;


import java.util.ArrayList;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "author")

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auth_id;

    private String name;

    @OneToMany( mappedBy="author",cascade = CascadeType.ALL)
    private List<Books> books = new ArrayList<>() ;

    
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Author(Long auth_id, String name) {
		super();
		this.auth_id = auth_id;
		this.name = name;
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Long getAuth_id() {
		return auth_id;
	}



	public void setAuth_id(Long auth_id) {
		this.auth_id = auth_id;
	}



	public List<Books> getBooks() {
		return books;
	}



	public void setBooks(List<Books> book) {
		this.books = book;
	}



	@Override
	public String toString() {
		return "Author [auth_id=" + auth_id + ", name=" + name + ", books=" + books + "]";
	}



	

	

	

    
}
