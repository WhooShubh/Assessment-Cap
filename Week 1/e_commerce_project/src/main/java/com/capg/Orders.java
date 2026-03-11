package com.capg;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	private int order_ID;
	private String order_Date;
	
	@ManyToOne
    @JoinColumn(name = "customer_id") 
    private Customer customer;
	
	@ManyToOne
    @JoinColumn(name = "delivery_id")  
    private Delivery delivery;
	
	 @ManyToMany
	    @JoinTable(
	        name = "order_products",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "product_id")
	    )
	    private List<Products> products;
	
	Orders(){}

	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public String getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(String order_Date) {
		this.order_Date = order_Date;
	}
}
