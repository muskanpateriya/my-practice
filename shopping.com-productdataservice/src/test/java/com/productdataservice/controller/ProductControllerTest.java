package com.productdataservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.productdataservice.entity.Details;
import com.productdataservice.entity.Products;
import com.productdataservice.service.ProductService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productServiceUnderTest;

	@Test
	public void testGetAllProducts() throws Exception {

		List<Products> value = new ArrayList<>();

		value.add(new Products(1, "Samsung Galaxy M32", "Samsung",
				"Front camera 16MP,Rear camera 48MP,8MP,2MP,2MP with 5000MAH battery", "Light blue",
				"Samsung galaxy M32", "4GB & 64GB", 11499, new Details(0, "Samsung", "Galaxy M32",
						"Android 11,One U3.1", "4G", "4GB", "64GB", "6.4", "GSM,wifi,bluetooth,screencast")));

		value.add(new Products(2, "Nothing", "Samsung",
				"Front camera 16MP,rear camera 50MP,50MP with headset, 4500mAH battery", "Black,white", "Nothing",
				"4GB & 64GB", 33999, new Details(0, "Nothing", "Nothing", "Qualcom snapdragon 778G + octa core 2.5GHz",
						"5G,4G,3G,2G", "8GB", "128GB", "6.5 Full HD OLED display", "GSM,wifi,bluetooth,screencast")));

		Mockito.when(productServiceUnderTest.getAllProducts()).thenReturn(value);

		String url = "/api/products/allproducts";
		mockMvc.perform(get(url)).andExpect(status().isOk());
	}

	@Test
	public void testGetProductByName() throws Exception {

		Products value = new Products(1, "Samsung Galaxy M32", "Samsung",
				"Front camera 16MP,Rear camera 48MP,8MP,2MP,2MP with 5000MAH battery", "Light blue",
				"Samsung galaxy M32", "4GB & 64GB", 11499, new Details(0, "Samsung", "Galaxy M32",
						"Android 11,One U3.1", "4G", "4GB", "64GB", "6.4", "GSM,wifi,bluetooth,screencast"));

		Mockito.when(productServiceUnderTest.getProductByName("Samsung Galaxy M32")).thenReturn(value);

		String url = "/api/products/byname/Samsung Galaxy M32";
		mockMvc.perform(get(url)).andExpect(status().isOk());

	}

	@Test
	public void testGetProductById() throws Exception {

		Products value = new Products(1, "Samsung Galaxy M32", "Samsung",
				"Front camera 16MP,Rear camera 48MP,8MP,2MP,2MP with 5000MAH battery", "Light blue",
				"Samsung galaxy M32", "4GB & 64GB", 11499, new Details(0, "Samsung", "Galaxy M32",
						"Android 11,One U3.1", "4G", "4GB", "64GB", "6.4", "GSM,wifi,bluetooth,screencast"));

		Mockito.when(productServiceUnderTest.getProductById(3)).thenReturn(value);

		String url = "/api/products/byid/0";
		mockMvc.perform(get(url)).andExpect(status().isOk());
	}

	@Test
	@Disabled
	public void testAddProducts() {

	}

	@Test
	@Disabled
	public void testUpdateProducts() {

	}

	@Test
	@Disabled
	public void testUpdateDetails() {

	}

	@Test
	@Disabled
	public void testDeleteProducts() {

	}

}
