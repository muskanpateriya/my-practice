package com.productdataservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.productdataservice.entity.Products;

public interface ProductsDao extends JpaRepository<Products, Integer> {

	@Transactional
	@Modifying
	@Query(value = "update products,details set products.brand=:v3,products.colour=:v5,products.discription=:v4,products.name=:v2,products.price=:v8,products.sizename=:v7,products.stylename=:v6,details.brand=:v10,details.cellulartechnology=:v13,details.internalmemory=:v15,details.modelname=:v11,details.os=:v12,details.screensize=:v16,details.ram=:v14,details.connectivitytechnology=:v17 from products p, details d where p.details_id=d.id and p.id=:v1;", nativeQuery = true)
	void update(@Param("v1") int id,@Param("v2") String name,@Param("v3") String brand,@Param("v4") String discription,
			@Param("v5") String colour,@Param("v6") String stylename,@Param("v7") String sizename,
			@Param("v8") int price,@Param("v10") String d_brand,@Param("v11") String modelname, 
			@Param("v12") String os,@Param("v13") String cellulartechnology,@Param("v14") String ram,
			@Param("v15") String internalmemory,@Param("v16") String screensize,@Param("v17") String connectivitytechnology);

	@Query(value = "DELETE products FROM products p JOIN details d ON p.details_id = d.id WHERE p.id=:id", nativeQuery = true)
	void deleteData(@Param("id") int product_id);

	Products findByName(String product_name);

}
