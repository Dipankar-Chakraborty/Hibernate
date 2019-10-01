package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class DbOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		//Singleton and heavy weight session factory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession();//represents database connection and light weight
		Transaction t = s.beginTransaction();
		//Insert new record
		//Product p = new Product(1004,"Fridge","Whirlpool",15000);
		//s.save(p);
		//get record according to primary key
//		try {
//		Product p = s.get(Product.class, 1006);
//		//Product p = s.load(Product.class, 1005);//load returns exception when data is not present and get returns null
//		if(p.equals(null)) {
//		System.out.println("Data is not present");
//		}
//		else {
//			System.out.println(p);
//		}
//		}catch(NullPointerException e) {
//			System.out.println(e);
//		}
//		try {
//			Product p = s.get(Product.class, 1005);
//		if(p.equals(null)) {
//			throw new NullPointerException();
//			}
//			else {
//				p.setPrice((float) (p.getPrice()*1.5));
//				s.update(p);
//				System.out.println("Successfully executed");
//				System.out.println("Current Price: "+p.getPrice());
//			}
//			}catch(NullPointerException e) {
//				System.out.println("Data is not present");
//			}
		
		//Delete Record
		try {
			Product p = s.get(Product.class, 1005);
		if(p.equals(null)) {
			throw new NullPointerException();
			}
			else {
				s.delete(p);
			}
			}catch(NullPointerException e) {
				System.out.println("Data is not present");
			}
		t.commit();
		s.close();
		
	}

}
