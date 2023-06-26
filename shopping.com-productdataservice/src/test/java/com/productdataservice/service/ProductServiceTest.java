package com.productdataservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.productdataservice.entity.Details;
import com.productdataservice.entity.Products;
import com.productdataservice.repository.DetailsDao;
import com.productdataservice.repository.ProductsDao;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	@Mock
	private ProductsDao productsDao;
	
	@Mock
	private DetailsDao detailsDao;
	
	@InjectMocks
	private ProductService productServiceUnderTest=new ProductServiceImpl();
	
	
	/*
	 * @BeforeEach void setUp() throws Exception {
	 * 
	 * productServiceUnderTest=new ProductServiceImpl(); }
	 */
		/* @AfterEach void tearDown() throws Exception { } */
	 

	@Test
	public void getAllProducts(){
		
		productServiceUnderTest.getAllProducts();
		verify(productsDao).findAll();
		
	}

	@Test
	public void getProductByName() {
		
		productServiceUnderTest.getProductByName("mayank");
		verify(productsDao).findByName("mayank");
	}

	@Test
	public void getProductById() {
		
		productServiceUnderTest.getProductById(10);
		verify(productsDao).getReferenceById(10);
	}

	@Test
	@Disabled
	public void addProducts(){
		
	}

	@Test
	@Disabled
	public void updateProducts() {
		
	}

	@Test
	@Disabled
	public void updateDetails() {
		
	}

	@Test
	@Disabled
	public void deleteProducts() {
		
	}

}
