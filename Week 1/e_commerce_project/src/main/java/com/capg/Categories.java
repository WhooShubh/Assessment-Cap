package com.capg;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categories {
	
	@Id
	private int category_ID;
	private String category_Name;
	private String category_Type;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Products> products;
	
	Categories()
	{}

	public int getCategory_ID() {
		return category_ID;
	}

	public void setCategory_ID(int category_ID) {
		this.category_ID = category_ID;
	}

	public String getCategory_Name() {
		return category_Name;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	public String getCategory_Type() {
		return category_Type;
	}

	public void setCategory_Type(String category_Type) {
		this.category_Type = category_Type;
	}	
}
