package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Product;

public interface ProductService {
	public Product createProduct(Product product);
	public List<Product> getAllProduct();
	public Optional<Product> getProductByID(int productId);
	public Optional<Product> deleteProductById(int productID);
}