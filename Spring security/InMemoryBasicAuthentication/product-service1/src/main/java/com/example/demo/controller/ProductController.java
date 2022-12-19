package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import io.swagger.annotations.Api;
@RestController  // Rest controller layer - initialize web container  - tomcat embedded webserver
@Api(value = "This is the api get a product details")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController{
	
	Logger log=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService ps;
	
	@PostMapping("/products/product")
	public Product createProduct(@RequestBody Product p) {
		log.info("the post request is recieved"+p.getName());
		log.warn("the validation is wrong");
		return ps.createProduct(p);
		
	}
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		log.info("The request came to the controller");
		return ps.getAllProduct();// mocked method call
		// it should not call the productservice
	}
	//         /product/"+productIdss
	@GetMapping("/products/product/{pid}")
	public Product getProductById(@PathVariable("pid") int pId) {
		System.out.println("product url /product/"+pId);
		
		return ps.getProductByID(pId).get();
	}
}