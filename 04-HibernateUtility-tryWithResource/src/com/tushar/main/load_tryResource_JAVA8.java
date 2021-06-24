package com.tushar.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tushar.model.Product;
import com.tushar.utility.HibernateConfiguration;

public class load_tryResource_JAVA8 {

	public static void main(String[] args) {
		Integer pid = 12;
		
		System.out.println("main() started");
		
		try (SessionFactory factory = HibernateConfiguration.getSessionFactory();
				Session  ses = HibernateConfiguration.getSession(); ){
			Product prod = ses.load(Product.class, pid);
			System.out.println(prod);
		} // try
		catch (Exception e) {
			e.printStackTrace();
		} // catch
		
	}

}
