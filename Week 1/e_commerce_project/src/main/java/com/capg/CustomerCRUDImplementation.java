package com.capg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Component
public class CustomerCRUDImplementation implements CustomerCRUD {
	
	@Autowired
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	

	public void saveCustomer(Customer c) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(c);
		et.commit();
	}

	public void updateCustomerName(int id, String name) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c = em.find(Customer.class, id);

		if (c != null) {
			c.setName(name);

			et.begin();
			em.merge(c);
			et.commit();
		}
	}

	public void updateCustomerEmail(int id, String email) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c = em.find(Customer.class, id);

		if (c != null) {
			c.setEmail(email);

			et.begin();
			em.merge(c);
			et.commit();
		}
	}

	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c = em.find(Customer.class, id);

		if (c != null) {
			et.begin();
			em.remove(c);
			et.commit();
		}
	}

	public void findCustomer(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		Customer c = em.find(Customer.class, id);

		if (c != null) {
			System.out.println("ID: " + c.getCustomer_ID());
			System.out.println("Name: " + c.getName());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Address: " + c.getAddress());
		} else {
			System.out.println("Customer Not Found");
		}
	}

	public void findAllCustomers() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select c from Customer c");
		List<Customer> customers = query.getResultList();

		for (Customer c : customers) {
			System.out.println("ID: " + c.getCustomer_ID());
			System.out.println("Name: " + c.getName());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Address: " + c.getAddress());
			System.out.println("-------------------------");
		}
	}

}
