package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Pojo.CompanyDao;

import com.example.demo.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
  CompanyService service;
	
	@PostMapping("/company")
	public String adddata(@RequestBody CompanyDao com) {
		return service.adddetails(com);
	}
	
	@GetMapping("ByDto")
	public List<CompanyDao> display(@RequestParam int pageNo , @RequestParam int pageSize) {
		return service.print(pageNo, pageSize);
	}
	
	
}
