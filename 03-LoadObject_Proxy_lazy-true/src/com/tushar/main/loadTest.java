package com.tushar.main;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tushar.entity.Product;
import com.tushar.entity.iProd;

public class loadTest {

	public static void main(String[] args) {
		
		Configuration cfg =null;
		SessionFactory factory =null;
		Session ses =null;
		try {

			cfg = new Configuration();
			cfg.configure("/com/tushar/config/hibernate.cfg.xml");

			factory =cfg.buildSessionFactory();
			ses = factory.openSession();
			
			iProd prod= ses.load(Product.class, 02);
			System.out.println("Running Class :"+prod.getClass());
			System.out.println("Running Super Class:"+prod.getClass().getSuperclass());
			System.out.println("Running Interfaces:"+Arrays.toString(prod.getClass().getInterfaces()));
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			
			if(prod == null) {
				System.out.println("No Records found");
			}else {
				System.out.println("Product Details: ID:"+prod.getPID()+" Name:"+prod.getProdname()+", Price:"+prod.getPrice()+", Status:"+prod.getStatus()+", Qty:"+prod.getQty());
			}
			
			if(ses!=null)
				ses.close();
			if(factory!=null)
				factory.close();
			
			
		} catch (Exception e) {
			System.out.println("No Records found");
			e.printStackTrace();
		}
	}

}
