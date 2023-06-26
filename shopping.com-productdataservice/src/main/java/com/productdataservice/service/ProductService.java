package com.productdataservice.service;

import java.util.List;

import com.productdataservice.entity.Details;
import com.productdataservice.entity.Products;

public interface ProductService {

	public List<Products> getAllProducts();

	public Products getProductByName(String product_name);

	public Products getProductById(int product_id);

	public List<Products> addProducts(List<Products> products);

	public Products updateProducts(Products product);

	public Details updateDetails(int detail_id,Details details);

	public void deleteProducts(int product_id);

}
