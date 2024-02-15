package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;

import com.example.demo.service.AuthorBookService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class AuthorBookController {
	
	@Autowired
	AuthorBookService service;

	

	@PostMapping("/addbooks")
	public String addbookstoauth ( @RequestBody Author auth ) {
		return service.addBookToAuthor(auth);
	}
	@GetMapping
	public List<Author> display (){
		return service.disp();
	}
	
	
}
