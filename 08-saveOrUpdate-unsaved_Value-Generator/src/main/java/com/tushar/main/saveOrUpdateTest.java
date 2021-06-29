package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection;

public class saveOrUpdateTest{

	public static void main(String[] args) {
		//same as 07-saveOrUpdate, only changes in mapping file: product.hbm.xml
		Transaction tX =null;
		
		System.out.println("saveOrUpdateTest.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			
			Product p1 = new Product();
			p1.setPID(16);
			p1.setPrice(148.0);
			p1.setProdname("Cleaner liquid");
			p1.setQty(10);
			p1.setStatus("A");
		
			tX = ses.beginTransaction();//start Transaction
			
			ses.saveOrUpdate(p1); // given SQL instruction
			
			tX.commit();//commit SQL instruction
			System.out.println("Record inserted/Updated");
			
		}catch(HibernateException e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			
			System.out.println("Record not inserted/Updated");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not inserted/Updated");
			e.printStackTrace();
		}

	}

}
