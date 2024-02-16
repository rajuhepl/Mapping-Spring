package com.example.ManyToOne.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ManyToOne.Entity.Bank;

public interface BankRepo extends JpaRepository<Bank, Long> {
}
