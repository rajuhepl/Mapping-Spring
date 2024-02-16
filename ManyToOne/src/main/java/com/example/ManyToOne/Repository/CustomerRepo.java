package com.example.ManyToOne.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ManyToOne.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}