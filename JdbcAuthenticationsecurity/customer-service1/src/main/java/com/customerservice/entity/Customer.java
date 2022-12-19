package com.customerservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	private int id;
	@Column(insertable = true, length = 10, precision = 3,unique = true)
	private String name;
	private String email;
	private String phone;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
}	
