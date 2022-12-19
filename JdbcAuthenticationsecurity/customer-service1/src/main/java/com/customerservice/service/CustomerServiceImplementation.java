package com.customerservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.customerservice.entity.Customer;
import com.customerservice.entity.Role;
import com.customerservice.entity.User;
import com.customerservice.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Role r = new Role();
		r.setName("user");
		User u = new User();
		u.setEmail(customer.getEmail());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(customer.getPhone());
		u.setPassword(encodedPassword);
		u.setRoles(Arrays.asList(r));
		customer.setUser(u);
		Customer c = customerRepository.save(customer);
		if (c == null) {
			// throw new CustomerRegistrationFailedException();
		}
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub

		return customerRepository.findById(id).get();
	}

	@Override
	public Optional<Customer> deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
