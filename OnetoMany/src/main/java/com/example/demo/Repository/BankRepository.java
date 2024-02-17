package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
