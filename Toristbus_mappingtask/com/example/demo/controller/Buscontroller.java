package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bus;
import com.example.demo.repository.BusSeatsrepo;
import com.example.demo.repository.Busrepo;
import com.example.demo.repository.PassengerDeatilsrepo;


@RestController
public class Buscontroller {
	
	@Autowired
	Busrepo br;
	
	@Autowired
	BusSeatsrepo bsr;
	
	@Autowired
	PassengerDeatilsrepo pdr;
	
	@PostMapping("/getDetails")
	public String postMethodName(@RequestBody Bus b) {
		br.save(b);
		return "saved sucessfully";
	}
	

}
