package com.productdataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productdataservice.entity.Details;

public interface DetailsDao extends JpaRepository<Details, Integer> {

}
