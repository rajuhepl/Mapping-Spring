package com.example.OneToManyTask1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OneToManyTask1.Entity.Author;
import com.example.OneToManyTask1.Entity.Book;
import com.example.OneToManyTask1.Service.LibService;

@RestController
@RequestMapping("/library")
public class LibController {

	@Autowired
	private LibService ls;

	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		return ls.saveAuthor(author);
	}

	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return ls.saveBook(book);
	}

	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		return ls.getAllAuthors();
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return ls.getAllBooks();
	}
}
