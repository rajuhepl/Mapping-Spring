package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService {
@Autowired
	 CompanyRepository repo;
	//post
	public String adddetails(Company com) {
		repo.save(com);
		return "Added";
	}
	
	public List<Company> print(){
		return repo.findAll();
	}
}
