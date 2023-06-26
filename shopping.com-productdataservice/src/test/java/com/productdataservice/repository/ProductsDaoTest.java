package com.productdataservice.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.productdataservice.entity.Details;
import com.productdataservice.entity.Products;

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
@ExtendWith(MockitoExtension.class)
class ProductsDaoTest {

	@Mock
	private ProductsDao productsDao;

	@Test
	@Transactional
	@Rollback(true)
   // @Disabled
	void deleteData() {

		Products products = new Products(6, "Realme 5 pro", "Realme",
				"Front camera 16MP,Rear camera 48MP,8MP,2MP,2MP with 4300MAH battery", "Dimond Navy blue",
				"Realme 5 pro", "4GB & 64GB", 14999,
				new Details(7, "Realme", "RMX7620", "v11", "4G", "4GB", "64GB", "6.5", "wifi,bluetooth,screencast"));

		// when
		Products save = productsDao.save(products);
		 int prodId=save.getId();
		 log.info("delete product by id :{}",prodId);
	        // perform the call
	        productsDao.deleteById(prodId);
	        // verify the mocks
	        verify(productsDao, times(1)).deleteById(eq(prodId));
	}

	@Test
	@Transactional
	@Rollback(true)
	//@Disabled
	void findByNameTest() {

		// given

		Products products = new Products(6, "Realme 5 pro", "Realme",
				"Front camera 16MP,Rear camera 48MP,8MP,2MP,2MP with 4300MAH battery", "Dimond Navy blue",
				"Realme 5 pro", "4GB & 64GB", 14999,
				new Details(7, "Realme", "RMX7620", "v11", "4G", "4GB", "64GB", "6.5", "wifi,bluetooth,screencast"));

		// when
		Products save = productsDao.save(products);
		Products findByName = productsDao.findByName(save.getName());

		// then
		assertThat(products.getName()).isEqualTo(findByName.getName());
		

	}

}
