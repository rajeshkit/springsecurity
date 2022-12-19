package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
@WebMvcTest(ProductController.class)
class ProductControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean 
	private ProductService productService;
	
//	@Test
//	void testCreateProduct() throws Exception {
//		
//	}

	@Test
	void testGetAllProducts() throws Exception {
		Product p1 = new Product(2000,"furniture",57456);
		Product p2 = new Product(2001,"sofa",5456);
		Product p3 = new Product(2002,"mixer",7456);
		List<Product> listOfProducts=new ArrayList<>();
		listOfProducts.add(p1);listOfProducts.add(p2);listOfProducts.add(p3);
		Mockito.when(productService.getAllProduct()).thenReturn(listOfProducts);
		mvc.perform(
				get("/products")
				.with(user("rajesh").password("rajesh")) //in memory authentication
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				).andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id",is(2000)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].name",is("furniture")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].price",is(57456)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[1].id",is(2001)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[1].name",is("sofa")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[1].price",is(5456)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[2].id",is(2002)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[2].name",is("mixer")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[2].price",is(7456)));
	}

	@Test
	void testGetProductById() throws Exception {
		Product p1 = new Product(2000,"furniture",57456);
		Optional<Product> optionalProduct=Optional.of(p1);
		Mockito.when(productService.getProductByID(2000)).thenReturn(optionalProduct);
		mvc.perform(
				get("/products/product/2000")
				.with(user("rajesh").password("rajesh")) //in memory authentication
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				).andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id",is(2000)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name",is("furniture")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price",is(57456)));
	}

}
