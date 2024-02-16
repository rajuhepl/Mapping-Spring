package com.example.ManyToOne.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ManyToOne.Entity.Bank;
import com.example.ManyToOne.Entity.Customer;
import com.example.ManyToOne.Repository.BankRepo;
import com.example.ManyToOne.Repository.CustomerRepo;

@Service
public class BankingService {

	@Autowired
	private BankRepo br;

	@Autowired
	private CustomerRepo cr;

	public Bank saveBank(Bank bank) {
		return br.save(bank);
	}

	public Customer saveCustomer(Customer customer) {
		return cr.save(customer);
	}

	public List<Bank> getAllBanks() {
		return br.findAll();
	}

	public List<Customer> getAllCustomers() {
		return cr.findAll();
	}
}
