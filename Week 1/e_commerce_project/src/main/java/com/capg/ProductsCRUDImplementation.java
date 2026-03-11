package com.capg;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ProductsCRUDImplementation implements ProductsCRUD {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	

	public void saveProduct(Products p) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
	}

	public void updateProductName(int id, String name) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Products p = em.find(Products.class, id);

		if (p != null) {
			p.setName(name);
			et.begin();
			em.merge(p);
			et.commit();
		}
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Products p = em.find(Products.class, id);

		if (p != null) {
			et.begin();
			em.remove(p);
			et.commit();
		}
	}

	public void findProduct(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		Products p = em.find(Products.class, id);

		if (p != null) {
			System.out.println(p.getProduct_ID());
			System.out.println(p.getName());
		}
	}

	public void findAllProducts() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select p from Products p");
		List<Products> list = q.getResultList();

		for (Products p : list) {
			System.out.println(p.getProduct_ID());
			System.out.println(p.getName());
			System.out.println("-------------------");
		}
	}
	
}
