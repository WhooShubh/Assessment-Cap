package com.capg;

public interface ProductsCRUD {

	void saveProduct(Products p);

	void updateProductName(int id, String name);

	void deleteProduct(int id);

	void findProduct(int id);

	void findAllProducts();
}