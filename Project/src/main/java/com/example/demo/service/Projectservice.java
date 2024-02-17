//package com.example.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.Entity.Projectentity;
//import com.example.demo.repository.ProjectRepository;
//import com.example.demo.repository.TaskRepository;
//
//@Service
//public class Projectservice {
//	 @Autowired
//	 ProjectRepository pr;
//	 
//	 @Autowired
//	 TaskRepository taskrepository;
//
//	 
//	 
//	 
//	public Projectentity project(Projectentity T) {
//		
//		return pr.save(T);
//	}
//	 
//	} 

package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Projectentity;
import com.example.demo.dao.Projectdao;
import com.example.demo.dao.Taskdao;
import com.example.demo.dao.persondao;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TaskRepository;

@Service
public class Projectservice {
	@Autowired
	ProjectRepository pr;

	@Autowired
	TaskRepository taskrepository;

	public Projectentity project(Projectentity T) {

		return pr.save(T);
	}

	private Projectdao convertToDto(Projectentity pro) {
		Projectdao dto = new Projectdao();
		dto.setId(pro.getId());
		dto.setName(pro.getName());

		List<Taskdao> listSystem = new ArrayList<>();
		pro.getTasks().stream().forEach(s -> {
			Taskdao sDto = new Taskdao();
			sDto.setName(s.getName());
			sDto.setId(s.getId());
			persondao pdao = new persondao();
			pdao.setRole(s.getProject().getRole());

			sDto.setPd(pdao);

			listSystem.add(sDto);
			
			dto.setProjects(listSystem);

		});

		

		return dto;
	}

	// get
	public List<Projectdao> print() {
		return pr.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

}
