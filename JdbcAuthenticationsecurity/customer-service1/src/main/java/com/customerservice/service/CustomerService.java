package com.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.customerservice.entity.Customer;
import com.customerservice.entity.Product;

public interface CustomerService {
	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public Optional<Customer> deleteCustomerById(int id);
}
