package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
////{productId: '55555', productName: 'Iphone', productPrice: '87777'}
public class Product {
	@Id
	private int id;
	private String name;
	private long price;
	
	
}
