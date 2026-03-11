package com.capg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Component
public class CategoriesCRUDImplementation implements CategoriesCRUD{
	@Autowired
	static EntityManagerFactory emf;

	public void saveCategory(Categories c) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(c);
		et.commit();
	}

	public void updateCategoryName(int id, String name) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Categories c = em.find(Categories.class, id);

		if (c != null) {
			c.setCategory_Name(name);
			et.begin();
			em.merge(c);
			et.commit();
		}
	}

	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Categories c = em.find(Categories.class, id);

		if (c != null) {
			et.begin();
			em.remove(c);
			et.commit();
		}
	}

	public void findCategory(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		Categories c = em.find(Categories.class, id);

		if (c != null) {
			System.out.println(c.getCategory_ID());
			System.out.println(c.getCategory_Name());
			System.out.println(c.getCategory_Type());
		}
	}

	public void findAllCategories() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Categories c");
		List<Categories> list = q.getResultList();

		for (Categories c : list) {
			System.out.println(c.getCategory_ID());
			System.out.println(c.getCategory_Name());
			System.out.println("-------------------");
		}
	}

}
