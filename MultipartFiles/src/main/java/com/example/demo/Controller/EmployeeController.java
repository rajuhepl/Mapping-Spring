package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Models.Employee;
import com.example.demo.Service.FileStorageService;
import com.google.gson.Gson;

@RestController
public class EmployeeController {
	@Autowired
	FileStorageService filestorageService;
	
	@PostMapping("/addPhoto")
    public String saveEmployee(@RequestParam("emp") String employee,@RequestPart("file") MultipartFile file) {
       
		return filestorageService.saveEmp(new Gson().fromJson(employee, Employee.class),file);
    }
}
