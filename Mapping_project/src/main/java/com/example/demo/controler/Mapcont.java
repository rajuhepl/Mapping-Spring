package com.example.demo.controler;
import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Aadhar;
import com.example.demo.repo.Aadharrepo;

import com.example.demo.repo.Personrepo;

import java.util.List;


@RestController
public class Mapcont {
	@Autowired
	Personrepo prepo;
	
	@Autowired
	Aadharrepo arepo;
	
	@PostMapping("/Adddata")
	public String adddetails(@RequestBody List<Person> p) {
		prepo.saveAll(p);
		return "saved";
	}

	
	

}
