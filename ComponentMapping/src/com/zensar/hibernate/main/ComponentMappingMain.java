package com.zensar.hibernate.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class ComponentMappingMain {
	public static void main(String[] args) {
		Configuration c = new Configuration().configure();
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession();
		Transaction t = s.beginTransaction();
		Name name = new Name();
		name.setFirstName("Dipankar");
		name.setMiddleName(" ");
		name.setLastName("Chakraborty");
		Customer cus = new Customer();
		cus.setCustomerId(2);
		cus.setCustomerName(name);
		cus.setGender("Male");
		cus.setAge(22);
		cus.setAddress("Kolkata");
		cus.setBirthDate(LocalDate.of(1997, 04, 30));

		try {
			File photo = new File(".\\resources\\customer_img.jpg");
			FileInputStream fin = new FileInputStream(photo);
			Blob customerphoto = BlobProxy.generateProxy(fin, photo.length());
			cus.setProfilePhoto(customerphoto);
			File f1= new File(".\\resources\\customerinfo.txt");
			FileReader fr = new FileReader(f1);
			Clob description = ClobProxy.generateProxy(fr,f1.length());
			cus.setDescription(description);
			s.save(cus);
			t.commit();
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
