package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="bus")
public class Bus {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "busno")
    private int busno;
	
	@Column(name="busname")
    private String busname;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="bus_id")
    private List<BusSeats> bs;
	
	public int getBusno() {
		return busno;
	}
	public void setBusno(int busno) {
		this.busno = busno;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}
	public List<BusSeats> getBs() {
		return bs;
	}
	public void setBs(List<BusSeats> bs) {
		this.bs = bs;
	}
	
	
	
	
	
	

}
