package com.capg;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Delivery {

	@Id
	private int delivery_ID;
	private String type;
	private String status;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Orders> orders;
	
	Delivery(){}

	public int getDelivery_ID() {
		return delivery_ID;
	}

	public void setDelivery_ID(int delivery_ID) {
		this.delivery_ID = delivery_ID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}
