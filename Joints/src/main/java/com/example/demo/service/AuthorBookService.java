package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.model.Books;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;


@Service
public class AuthorBookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;
    
    

    public String addBookToAuthor(Author auth) {
    
  Author authin  = new Author(auth.getAuth_id(),auth.getName());
  List<Books> book = new ArrayList<>();
  for(Books bookin : auth.getBooks()) {
	  Books boo = new Books(bookin.getId(),bookin.getTitle());
	  boo.setAuthor(authin);
	  book.add(boo);
       }
        authin.setBooks(book);
    	authorRepository.save(authin);  

            return "Added sucessfully";
        
    }





	public List<Author> disp() {
		return authorRepository.findAll();
	}








	

       // Other business logic methods as needed
}
