package com.example.demo.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Models.Employee;
import com.example.demo.Repository.EmployeeRepository;
@Service
public class FileStorageService {
	
	@Autowired
	private EmployeeRepository empRepo;
	

	public String saveEmp(Employee employee2, MultipartFile multipartFile) {
		Employee employee = new Employee();
		try {
			employee.setPhoto(multipartFile.getBytes());
			employee.setEname(employee2.getEname());
			empRepo.save(employee);
			return "uploaded";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
	}


	
}
