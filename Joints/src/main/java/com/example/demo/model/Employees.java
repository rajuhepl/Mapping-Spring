package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Emp_no;
	
	@Column(name = "Name")
	private String emp_name;
	
	@Column(name="Email")
	private String emp_email;
	
		
	public int getEmp_no() {
		return Emp_no;
	}

	public void setEmp_no(int emp_no) {
		Emp_no = emp_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	@Override
	public String toString() {
		return "Employees [Emp_no=" + Emp_no + ", emp_name=" + emp_name + ", emp_email=" + emp_email + "]";
	}
   
	
	
}
