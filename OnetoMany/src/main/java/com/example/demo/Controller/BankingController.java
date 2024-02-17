package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Bank;
import com.example.demo.Entity.Customer;
import com.example.demo.service.BankingService;
@RestController
@RequestMapping("/banking")
public class BankingController {

    @Autowired
    BankingService bankingService;

    @PostMapping("/banks")
    public Bank createBank(@RequestBody Bank bank) {
        return bankingService.saveBank(bank);
    }
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return bankingService.saveCustomer(customer);
    }
    @GetMapping("/banks")
    public List<Bank> getAllBanks() {
        return bankingService.getAllBanks();
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return bankingService.getAllCustomers();
    }
}
 
