package com.capg;

public interface CustomerCRUD {
	void saveCustomer(Customer c);

	void updateCustomerName(int id, String name);

	void updateCustomerEmail(int id, String email);

	void deleteCustomer(int id);

	void findCustomer(int id);

	void findAllCustomers();
}
