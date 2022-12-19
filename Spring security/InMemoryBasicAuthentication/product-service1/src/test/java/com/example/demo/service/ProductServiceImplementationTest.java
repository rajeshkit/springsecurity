package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@ExtendWith(MockitoExtension.class)
class ProductServiceImplementationTest {

	@InjectMocks
	private ProductServiceImplementation productService;
	@Mock
	private ProductRepository productRepository;
	
	
	
	@Test
	void testCreateProduct() {
		Product pro=new Product(5000,"Laptop",80000);
		//fake repository or mock repository -> Mockito;
		Mockito.when(productRepository.save(pro)).thenReturn(pro);
		Product actual=productService.createProduct(pro);
		// it will call the productservice.createProduct(pro)
		assertEquals(pro, actual);	
	}

	@Test
	void testGetAllProduct() {
		Product p1 = new Product(2000,"furniture",57456);
		Product p2 = new Product(2001,"sofa",5456);
		Product p3 = new Product(2002,"mixer",7456);
		List<Product> listOfProducts=new ArrayList<>();
		listOfProducts.add(p1);listOfProducts.add(p2);listOfProducts.add(p3);
		Mockito.when(productRepository.findAll()).thenReturn(listOfProducts);
		List<Product> actuals=productService.getAllProduct();
		assertEquals(listOfProducts, actuals);
		assertEquals(listOfProducts.size(), actuals.size());
		assertEquals(listOfProducts.get(0), actuals.get(0));
	}

	@Test
	void testGetProductByID() {
		Product p1 = new Product(2000,"furniture",57456);
		Optional<Product> optionalProduct=Optional.of(p1);
		Mockito.when(productRepository.findById(2000)).thenReturn(optionalProduct);
		Optional<Product> actuals=productService.getProductByID(2000);
		Product actualProduct = actuals.get();
		assertEquals(p1.getId(), actualProduct.getId());
		assertEquals(p1.getName(), actualProduct.getName());
		assertEquals(p1.getPrice(), actualProduct.getPrice());
	}
//
//	@Test
//	void testDeleteProductById() {
//		fail("Not yet implemented");
//	}

}
