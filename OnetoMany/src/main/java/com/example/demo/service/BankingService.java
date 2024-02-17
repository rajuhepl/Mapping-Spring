package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bank;
import com.example.demo.Entity.Customer;
import com.example.demo.Repository.BankRepository;
import com.example.demo.Repository.CustomerRepository;

@Service
public class BankingService {
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public Bank saveBank(Bank bank) {
		return bankRepository.save(bank);
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Bank> getAllBanks() {
		return bankRepository.findAll();
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
