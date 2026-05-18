package com.example.mallmanagement.controller;

import com.example.mallmanagement.model.Customer;
import com.example.mallmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:3000")   // React permission
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // ADD CUSTOMER
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // GET ALL CUSTOMERS
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    // DELETE CUSTOMER
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}