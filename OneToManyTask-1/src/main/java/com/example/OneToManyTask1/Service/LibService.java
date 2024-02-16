package com.example.OneToManyTask1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OneToManyTask1.Entity.Author;
import com.example.OneToManyTask1.Entity.Book;
import com.example.OneToManyTask1.Repository.AuthorRepository;
import com.example.OneToManyTask1.Repository.BookRepository;

@Service
public class LibService {

	@Autowired
	private AuthorRepository ar;

	@Autowired
	private BookRepository br;

	public Author saveAuthor(Author author) {
		return ar.save(author);
	}

	public Book saveBook(Book book) {
		return br.save(book);
	}

	public List<Author> getAllAuthors() {
		return ar.findAll();
	}

	public List<Book> getAllBooks() {
		return br.findAll();
	}
}
