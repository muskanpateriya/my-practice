package com.productdataservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productdataservice.entity.Details;
import com.productdataservice.entity.Products;
import com.productdataservice.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/allproducts")
	public List<Products> getAllProducts() {

		return productService.getAllProducts();
	}

	@GetMapping("/byname/{product_name}")
	public Products getProductByName(@PathVariable String product_name) {

		return productService.getProductByName(product_name);
	}

	@GetMapping("/byid/{product_id}")
	public Products getProductById(@PathVariable int product_id) {

		return productService.getProductById(product_id);
	}

	@PostMapping("/pro/add")
	public List<Products> addProducts(@RequestBody List<Products> products) {
		System.out.println(products);
		return productService.addProducts(products);
	}

	@PutMapping("/pro/update")
	public Products updateProducts(@RequestBody Products product) {
		return productService.updateProducts(product);
	}

	@PutMapping("/details/update/{detail_id}")
	public Details updateDetails(@PathVariable int detail_id, @RequestBody Details details) {
		return productService.updateDetails(detail_id, details);
	}

	@DeleteMapping("/delete/{product_id}")
	public String deleteProducts(@PathVariable int product_id) {
		productService.deleteProducts(product_id);
		return "Product deleted successfully...";
	}

}
