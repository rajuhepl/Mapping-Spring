package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Hrdepartment;

public interface Hr_repo extends JpaRepository<Hrdepartment, Integer> {

}
