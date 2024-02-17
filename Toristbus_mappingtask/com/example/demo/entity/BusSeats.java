package com.example.demo.entity;

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
@Table(name = "BusSeats")
public class BusSeats {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seat_id")
    private int seatid;

    @Column(name = "seat_no")
    private int seatno;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id")
    private PassengerDeatils pd;


	public int getSeatid() {
		return seatid;
	}

	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public PassengerDeatils getPd() {
		return pd;
	}

	public void setPd(PassengerDeatils pd) {
		this.pd = pd;
	}

	



}
