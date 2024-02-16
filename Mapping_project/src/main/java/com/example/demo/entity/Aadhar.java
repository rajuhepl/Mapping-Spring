package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Aadhar")
public class Aadhar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long aadharno;

	private Long no;

	public long getAadharno() {
		return aadharno;
	}

	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}
}
