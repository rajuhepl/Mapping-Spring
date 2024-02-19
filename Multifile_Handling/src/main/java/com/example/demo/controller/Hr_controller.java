package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Hrdepartment;
import com.example.demo.service.Hr_service;
import com.google.gson.Gson;


@RestController
public class Hr_controller {
	
	@Autowired
	Hr_service hrserv;
	
	
	@PostMapping("/adddetails")
	public String posthrdetails(@RequestParam("dep") String hrdept,@RequestPart("file") MultipartFile file) {	
		return hrserv.savedetails(new Gson().fromJson(hrdept, Hrdepartment.class),file);
	}
	
	@GetMapping("/readdetails/{pageno}/{pagesize}")
	public Page<Hrdepartment> getdeatils(@PathVariable int pageno,@PathVariable int pagesize){
		Page<Hrdepartment> hrpage = hrserv.display(pageno,pagesize);
		return hrpage;
	}
	

}
