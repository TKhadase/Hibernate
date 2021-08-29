package com.tushar.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class delete_Test {

	public static void main(String[] args) {

		Transaction tx=null;
		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {

			Query query =ses.createQuery("FROM Product");
			List<Product> list =query.getResultList();
			list.forEach(System.out::println);
			
			Product prod= ses.get(Product.class, 14);
			if(prod ==null){
				System.out.println("Product not available");
			}else
			{
				 tx =ses.beginTransaction();
				ses.delete(prod);
				tx.commit();
				System.out.println("Product deleted");
				
			}
			
			
		}//try
		catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
				tx.rollback();
			}
			}//catch
		 catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
				tx.rollback();
			}
			}//catch

	}//main

}//class