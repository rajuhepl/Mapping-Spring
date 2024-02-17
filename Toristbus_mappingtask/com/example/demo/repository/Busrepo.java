package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Bus;

public interface Busrepo extends JpaRepository<Bus, Integer> {

}
