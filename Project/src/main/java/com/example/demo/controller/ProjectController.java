package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Projectentity;
import com.example.demo.dao.Projectdao;
import com.example.demo.service.Projectservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/projecttask")
public class ProjectController {

	@Autowired
	Projectservice projectservice;

	@PostMapping("/project")
	public Projectentity emp(@RequestBody Projectentity T) {
		return projectservice.project(T);
	}

	@GetMapping("/getDao")
	public List<Projectdao> getDao() {
		return projectservice.print();
	}

}
