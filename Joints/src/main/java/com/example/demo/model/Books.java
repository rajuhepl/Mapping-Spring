package com.example.demo.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "book")

public class Books {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;

	    @ManyToOne
	    @JoinColumn(name = "auth_id")
	    private Author author;
	    
	    
	    

		public Books() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Books(Long id, String title) {
			super();
			this.id = id;
			this.title = title;
			
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}

       
	

		public void setAuthor(Author author) {
			this.author = author;
		}




		

		
	    
	    
}
