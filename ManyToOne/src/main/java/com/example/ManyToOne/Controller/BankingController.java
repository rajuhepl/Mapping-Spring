package com.example.ManyToOne.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManyToOne.Entity.Bank;
import com.example.ManyToOne.Entity.Customer;
import com.example.ManyToOne.Service.BankingService;

@RestController
@RequestMapping("/banking")
public class BankingController {

	@Autowired
	private BankingService bs;

	@PostMapping("/banks")
	public Bank createBank(@RequestBody Bank bank) {
		return bs.saveBank(bank);
	}

	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return bs.saveCustomer(customer);
	}

	@GetMapping("/banks")
	public List<Bank> getAllBanks() {
		return bs.getAllBanks();
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return bs.getAllCustomers();
	}
}
