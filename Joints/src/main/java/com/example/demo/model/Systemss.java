package com.example.demo.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="systems")
public class Systemss {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sys_no;
	
	@Column(name="Brand")
	private String sys_brand;
	
	@Column(name="serial_no")
	private String sys_serialno;
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Employees employee;

	public int getSys_no() {
		return sys_no;
	}

	public void setSys_no(int sys_no) {
		this.sys_no = sys_no;
	}

	public String getSys_brand() {
		return sys_brand;
	}

	public void setSys_brand(String sys_brand) {
		this.sys_brand = sys_brand;
	}

	public String getSys_serialno() {
		return sys_serialno;
	}

	public void setSys_serialno(String sys_serialno) {
		this.sys_serialno = sys_serialno;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Systemss [sys_no=" + sys_no + ", sys_brand=" + sys_brand + ", sys_serialno=" + sys_serialno
				+ ", employee=" + employee + "]";
	}


	
	

}
