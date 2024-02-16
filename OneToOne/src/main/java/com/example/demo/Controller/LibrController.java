package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Author;
import com.example.demo.Service.LibrService;
 
@RestController
@RequestMapping("/library")
public class LibrController {
 
	@Autowired
	private LibrService ls;
 
	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		return ls.saveAuthor(author);
	}
 
	@PostMapping("/addresses")
	public Address createAddress(@RequestBody Address address) {
		return ls.saveAddress(address);
	}
 
	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		return ls.getAllAuthors();
	}
 
	@GetMapping("/addresses")
	public List<Address> getAllAddresses() {
		return ls.getAllAddresses();
	}
}