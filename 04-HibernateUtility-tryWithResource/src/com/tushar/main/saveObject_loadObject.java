package com.tushar.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HibernateConfiguration;

public class saveObject_loadObject {

	public static void main(String[] args) {
		boolean bTX = false;
		Transaction tx = null;
		Integer pid = 13;
		Session ses = null;
		SessionFactory factory = null;
		System.out.println("main() started");

		try {

			factory = HibernateConfiguration.getSessionFactory();
			ses = HibernateConfiguration.getSession();

			Product prodSet = new Product();
			prodSet.setPID(pid);
			prodSet.setPrice(114.0);
			prodSet.setProdname("mouse");
			prodSet.setQty(1);
			prodSet.setStatus("A");

			tx = ses.beginTransaction();
			ses.save(prodSet);
			bTX = true;
		} // try
		catch (Exception e) {
			bTX = false;
			e.printStackTrace();
		} // catch
		finally {

			if (bTX) {
				tx.commit();
			} else {
				tx.rollback();
			}
		} // finally
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		try {
			Product prod = ses.load(Product.class, pid);
			System.out.println(prod);
		} // try
		catch (Exception e) {
			e.printStackTrace();
		} // catch
		finally {
			HibernateConfiguration.closeSession(ses);
			HibernateConfiguration.closeSessionFactory();
		} // finally

	}// main

}// class
