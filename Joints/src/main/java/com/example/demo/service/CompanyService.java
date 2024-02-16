package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Pojo.CompanyDao;

import com.example.demo.Pojo.SytemssDao;
import com.example.demo.model.Company;
import com.example.demo.model.Employees;
import com.example.demo.model.Systemss;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService {
@Autowired
	 CompanyRepository repo;


private CompanyDao convertToDto(Company comp) {
    CompanyDao dto = new CompanyDao();
    dto.setId(comp.getId());
    dto.setCompanyname(comp.getCompanyname());
    
    List<SytemssDao> listSystem = new ArrayList<>();
    comp.getSystem().stream().forEach(s -> {
    	SytemssDao sDto = new SytemssDao();
        sDto.setSys_brand(s.getSys_brand());
        sDto.setSys_no(s.getSys_no());
        sDto.setSys_serialno(s.getSys_serialno());
        
       
      sDto.setEmp_no(s.getEmployee().getEmp_no());
       
      sDto.setEmp_name(s.getEmployee().getEmp_name());
      sDto.setEmp_email(s.getEmployee().getEmp_email());
      
       
        listSystem.add(sDto);
       
       
        
    });
    
    dto.setSystem(listSystem);
  
    return dto;
}


private Systemss convertToEntity(SytemssDao sDto) {
    Systemss s = new Systemss();
    s.setSys_brand(sDto.getSys_brand());
    s.setSys_no(sDto.getSys_no());
    s.setSys_serialno(sDto.getSys_serialno());
    
    Employees emp = new Employees();
    emp.setEmp_no(sDto.getEmp_no());
    emp.setEmp_name(sDto.getEmp_name());
    emp.setEmp_email(sDto.getEmp_email());
    
    s.setEmployee(emp);
    
    return s;
}
private Company convertToEntity(CompanyDao cDto) {
    Company com = new Company();
    com.setId(cDto.getId());
    com.setCompanyname(cDto.getCompanyname());
    List<Systemss> systems = cDto.getSystem().stream().map(this::convertToEntity).collect(Collectors.toList());
    com.setSystem(systems);


   
    
    return com;
}


	//post
	public String adddetails(CompanyDao comDao) {
		 Company company = convertToEntity(comDao);
	       repo.save(company);
		return "Added";
	}
	//get
	public List<CompanyDao> print(){
		return repo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
	}

	
	
}
