package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PassengerDeatils;

public interface PassengerDeatilsrepo extends JpaRepository<PassengerDeatils, Integer> {

}
