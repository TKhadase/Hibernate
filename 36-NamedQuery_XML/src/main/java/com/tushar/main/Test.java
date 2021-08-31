package com.tushar.main;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class Test {

	public static void main(String[] args) {

		System.out.println("Test.main() STARTED ");

		try { 
			SessionFactory factory = HBConnection_improved.getSessionFactory();
			Session ses = HBConnection_improved.getSession();
			
			Query query = ses.getNamedQuery("HQL_GET_PRODUCT");
			List<Product> list = query.getResultList();
			list.forEach( product -> {
				System.out.println(product);
			});
			
		} catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
		}

	}

}
