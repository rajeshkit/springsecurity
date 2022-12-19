package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductServiceImplementation implements ProductService{
	Logger log=LoggerFactory.getLogger(ProductServiceImplementation.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override				//(5000,"Laptop",80000)
	public Product createProduct(Product product) {
		//log.debug("Product object is "+product);
									 //(5000,"Laptop",80000)
		Product p = productRepository.save(product);// it is going product repository persist product
													// we dont want to persist my pro data inside
													// the database
													// mocked ProductRepository in test case
		if(p==null) {
	//		log.warn("The product object is not save in the db");
		}
		//log.info("product object inserted in the db success");
		return p;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> list = productRepository.findAll(); //it will hit the db get all db products
		if(list.isEmpty()) {
			log.error("No product details in the db");
			log.debug("the list of orduct is"+list.size());
		}
		log.info("fetched some product"+list.size());
		return list;
	}

	@Override
	public Optional<Product> getProductByID(int productId) {
		// TODO Auto-generated method stub
	
		return productRepository.findById(productId);
	}

	@Override
	public Optional<Product> deleteProductById(int productID) {
		// TODO Auto-generated method stub
		return null;
	}

}
