package com.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.entity.Customer;
import com.customerservice.entity.Product;
import com.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/registration")
	public Customer createCustomer(@RequestBody Customer customer) {
		System.out.println("called create customer");
		return customerService.createCustomer(customer);
	}
	@GetMapping("/customers")
	public List<Customer> getAllCustomersCustomer() {
		return customerService.getAllCustomers();
	}
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable("id") int cId) {
		return customerService.getCustomerById(cId);
	}

}
