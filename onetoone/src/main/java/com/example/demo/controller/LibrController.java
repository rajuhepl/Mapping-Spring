package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.Author;
import com.example.demo.service.LibrService;

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