package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Author;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.AuthorRepository;

@Service
public class LibrService {

	@Autowired
	private AuthorRepository aur;

	@Autowired
	private AddressRepository adr;

	public Author saveAuthor(Author author) {
		return aur.save(author);
	}

	public Address saveAddress(Address address) {
		return adr.save(address);
	}

	public List<Author> getAllAuthors() {
		return aur.findAll();
	}

	public List<Address> getAllAddresses() {
		return adr.findAll();
	}
}