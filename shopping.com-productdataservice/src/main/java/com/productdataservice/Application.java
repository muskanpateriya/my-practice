package com.productdataservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.productdataservice.entity.Details;
import com.productdataservice.entity.Products;
import com.productdataservice.service.ProductService;

@SpringBootApplication
@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	 * @Bean CommandLineRunner commandLineRunner(ProductService productService) {
	 * 
	 * return args -> {
	 * 
	 * List<Products> products = new ArrayList<>(); // product 1 products.add(new
	 * Products(6, "Realme 5 pro", "Realme",
	 * "Front camera 16MP,Rear camera 48MP,8MP,2MP,2MP with 4300MAH battery",
	 * "Dimond Navy blue", "Realme 5 pro", "4GB & 64GB", 14999, new Details(7,
	 * "Realme", "RMX7620", "v11", "4G", "4GB", "64GB", "6.5",
	 * "wifi,bluetooth,screencast")));
	 * 
	 * // Product 2 products.add(new Products(0, "Samsung Galaxy M32", "Samsung",
	 * "Front camera 16MP,Rear camera 48MP,8MP,2MP,2MP with 5000MAH battery",
	 * "Light blue", "Samsung galaxy M32", "4GB & 64GB", 11499, new Details(0,
	 * "Samsung", "Galaxy M32", "Android 11,One U3.1", "4G", "4GB", "64GB", "6.4",
	 * "GSM,wifi,bluetooth,screencast")));
	 * 
	 * // product 3 products.add(new Products(0, "Nothing", "Samsung",
	 * "Front camera 16MP,rear camera 50MP,50MP with headset, 4500mAH battery",
	 * "Black,white", "Nothing", "4GB & 64GB", 33999, new Details(0, "Nothing",
	 * "Nothing", "Qualcom snapdragon 778G + octa core 2.5GHz", "5G,4G,3G,2G",
	 * "8GB", "128GB", "6.5 Full HD OLED display",
	 * "GSM,wifi,bluetooth,screencast")));
	 * 
	 * productService.addProducts(products); };}
	 */
	

}
