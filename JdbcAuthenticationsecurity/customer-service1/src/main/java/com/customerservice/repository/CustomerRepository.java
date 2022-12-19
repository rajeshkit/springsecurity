package com.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customerservice.entity.Customer;
import com.customerservice.entity.User;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
