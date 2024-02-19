package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Hrdepartment;
import com.example.demo.repository.Hr_repo;

@Service
public class Hr_service {
	@Autowired
	Hr_repo hrrepo;

	public String savedetails(Hrdepartment hrdept2, MultipartFile file) {
		Hrdepartment hrdept = new Hrdepartment();
		try {
			hrdept.setName(hrdept2.getName());
			hrdept.setPhoto(file.getBytes());
			hrdept.setEmail(hrdept2.getEmail());
			hrdept.setFilename(file.getOriginalFilename());
			hrrepo.save(hrdept);
			return " file uploaded sucess";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}

	}

	public Page<Hrdepartment> display(int pageno,int pagesize) {
		return hrrepo.findAll(PageRequest.of(pageno, pagesize));
	}

}
