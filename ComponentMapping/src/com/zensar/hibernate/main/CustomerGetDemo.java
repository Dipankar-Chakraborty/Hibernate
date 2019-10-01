package com.zensar.hibernate.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class CustomerGetDemo {
public static void main(String[] args) {
	Configuration c = new Configuration().configure();
	SessionFactory f = c.buildSessionFactory();
	Session s = f.openSession();
	Transaction t = s.beginTransaction();
	Customer cust=s.get(Customer.class, 2);
	System.out.println(cust.getCustomerId());
	System.out.println(cust.getCustomerName());
	System.out.println(cust.getGender());
	System.out.println(cust.getAge());
	System.out.println(cust.getBirthDate());
	System.out.println(cust.getAddress());
	
	Name cn=cust.getCustomerName();
	System.out.println(cn);
	Blob customerPhoto = cust.getProfilePhoto();
	try {
		InputStream in = customerPhoto.getBinaryStream();
		FileOutputStream fout = new FileOutputStream(".\\resources\\newcustomer_img.jpg");
		int data=0;
		while((data=in.read())!=-1) {
			fout.write(data);
		}
		in.close();
		fout.close();
		Clob description = cust.getDescription();
		Reader r = description.getCharacterStream();
		PrintWriter pw = new PrintWriter("./resources/customerdbinfo.txt");
		int chardata = 0;
		while((chardata=r.read())!=-1) {
			pw.print((char)chardata);
		}
		r.close();
		pw.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	t.commit();
	s.close();
}
}
