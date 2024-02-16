package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
  CompanyService service;
	
	@PostMapping("/company")
	public String adddata(@RequestBody Company com) {
		return service.adddetails(com);
	}
	
	@GetMapping()
	public List<Company> display() {
		return service.print();
	}
	
	
}
