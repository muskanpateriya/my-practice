package com.productdataservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String brand;
	private String discription;
	private String colour;
	private String stylename;
	private String sizename;
	private int price;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "details_id",referencedColumnName = "id")
	private Details details;

	@Override
	public String toString() {
		return "Products [name=" + name + ", brand=" + brand + ", discription=" + discription + ", colour=" + colour
				+ ", stylename=" + stylename + ", sizename=" + sizename + ", price=" + price + ", details=" + details
				+ "]";
	}

}
