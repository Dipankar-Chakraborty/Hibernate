package com.zensar.hibernate.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

//Hibernate Query Language(Object Oriented Query Language)
public class HQLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		//Singleton and heavy weight session factory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession();//represents database connection and light weight
		Transaction t = s.beginTransaction();
		//Query q = s.createQuery("from Product");//jpa(java persistant api) query
		//Query q = s.createQuery("from Product p where p.price>5000 AND p.price<50000");
		//Query q = s.createQuery("from Product p where p.price between 5000 and 50000");
		//Query q = s.createQuery("from Product p where p.brand like's%' ");
		//Query q = s.createQuery("from Product p where p.name='laptop' ");
		/*
		 * Query q = s.createQuery("select p.name,p.price from Product p ");
		 * List<Object[]> objects = q.getResultList(); for(Object[] object: objects) {
		 * for(Object cp: object) { System.out.print(cp+ "\t"); } System.out.println();
		 * }
		 */
		/*List<Product> products = q.getResultList();
		for(Product cp:products) {
			System.out.println(cp);
		}*/
		Query q = s.createQuery("select max(p.price) from Product p");
		Float maxPrice = (Float) q.getSingleResult();
		System.out.println(maxPrice);
		Query q1 = s.createQuery("select min(p.price) from Product p");
		Float minPrice = (Float) q1.getSingleResult();
		System.out.println(minPrice);
		Query q2 = s.createQuery("select sum(p.price) from Product p");
		double sumPrice = (double) q2.getSingleResult();
		System.out.println(sumPrice);
		Query q3 = s.createQuery("select avg(p.price) from Product p");
		double avgPrice = (double) q3.getSingleResult();
		System.out.println(avgPrice);
		//Deprecated
		Criteria cr = s.createCriteria(Product.class);
		List<Product> products = cr.list();
		for(Product cp: products)
		{
			System.out.println(cp);
		}
		t.commit();
		s.close();
	}

}
