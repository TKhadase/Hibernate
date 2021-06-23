package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tushar.entity.Product;

public class Save_INSERT {

	public static void main(String[] args) {

		boolean bCommit = false;
		Transaction tx = null;
		Configuration cfg =null;
		SessionFactory factory =null;
		Session ses =null;
		
		try {
			// create Configuration object & specify cfg file
		 cfg = new Configuration();
			cfg.configure("/com/tushar/common/hibernate.cfg.xml");

			//create sessionFactory
			 factory = cfg.buildSessionFactory();

			//create session
			 ses = factory.openSession();

			Product prod = new Product();
			prod.setPID(02);
			prod.setProdname("HDD");
			prod.setPrice(2500.0);
			prod.setQty(11);
			prod.setStatus("A");
			
			//begin tx
			tx = ses.beginTransaction();

			//insert record
			ses.save(prod);
			System.out.println("Record saved");
			
			bCommit = true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			bCommit = false;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			bCommit = false;
		} finally {
			
			//tx mgmt
			if (bCommit) {
				tx.commit();
				System.out.println("Record Commit Done");
			} 
			else {
				if(tx !=null)
				tx.rollback();
				System.out.println("Record rollback Done");
			}

			ses.close();
			factory.close();
		}

	}

}
