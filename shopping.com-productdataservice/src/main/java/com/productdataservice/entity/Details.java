package com.productdataservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String brand;
	private String modelname;
	private String os;
	private String cellulartechnology;
	private String ram;
	private String internalmemory;
	private String screensize;
	private String connectivitytechnology;

	@Override
	public String toString() {
		return "Details [brand=" + brand + ", modelname=" + modelname + ", os=" + os + ", cellulartechnology="
				+ cellulartechnology + ", ram=" + ram + ", internalmemory=" + internalmemory + ", screensize="
				+ screensize + ", connectivitytechnology=" + connectivitytechnology + "]";
	}

}
