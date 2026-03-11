package com.capg;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {

	@Id
	private int product_ID;
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "category_id")  
    private Categories category;
	
	@ManyToMany(mappedBy = "products")
    private List<Orders> orders;
	
	Products(){}

	public int getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
