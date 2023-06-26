package com.productdataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productdataservice.entity.Details;
import com.productdataservice.entity.Products;
import com.productdataservice.repository.DetailsDao;
import com.productdataservice.repository.ProductsDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductsDao productsDao;

	@Autowired
	DetailsDao detailsDao;

	@Override
	public List<Products> getAllProducts() {
        log.info("Retriving all the products from the database");
		return productsDao.findAll();
	}

	@Override
	public Products getProductByName(String product_name) {
        
		log.info("Fetching product by product name: {}",product_name);
		return productsDao.findByName(product_name);
	}

	@Override
	public Products getProductById(int product_id) {

		log.info("Fetching product by product id: {}",product_id);
		return productsDao.getReferenceById(product_id);
	}

	@Override
	public List<Products> addProducts(List<Products> products) {

		/*
		 * System.out.println(products); return productsDao.saveAll(products);
		 */
		log.info("-----------Adding products into data base ------------ ");
		int size = products.size();
		for (int i = 0; i < size; i++) {
			Products product = products.get(i);
			log.info("product {} ",i+1);
			productsDao.save(product);
		}
		return products;
	}

	@Override
	public Products updateProducts(Products product) {
		// TODO Auto-generated method stub
		Products check = productsDao.getReferenceById(product.getId());
         
		log.info("updating existing product by id:{}",check);
		// Products table
		int id = product.getId();
		String name = product.getName();
		String brand = product.getBrand();
		String discription = product.getDiscription();
		String colour = product.getColour();
		String stylename = product.getStylename();
		String sizename = product.getSizename();
		int price = product.getPrice();

		// Details
		// int d_id = product.getDetails().getId();
		String d_brand = product.getDetails().getBrand();
		String modelname = product.getDetails().getModelname();
		String os = product.getDetails().getOs();
		String cellulartechnology = product.getDetails().getCellulartechnology();
		String ram = product.getDetails().getRam();
		String internalmemory = product.getDetails().getInternalmemory();
		String screensize = product.getDetails().getScreensize();
		String connectivitytechnology = product.getDetails().getConnectivitytechnology();

		System.out.println("******" + check + "********");
		if (check == null) {
			return null;
		} else {
			productsDao.update(id, name, brand, discription, colour, stylename, sizename, price, d_brand, modelname, os,
					cellulartechnology, ram, internalmemory, screensize, connectivitytechnology);

			return product;
		}
	}

	@Override
	public Details updateDetails(int details_id, Details details) {

		Details check = detailsDao.getReferenceById(details_id);

		return detailsDao.save(details);
	}

	@Override
	public void deleteProducts(int product_id) {

		Products product = productsDao.getReferenceById(product_id);
		int detail_id = product.getDetails().getId();
		System.out.println("detail_id :" + detail_id);
		try {
			productsDao.deleteById(product.getId());
			;
		} catch (Exception ex) {

			System.out.println("Data Not present..." + ex);
		}

	}

}
