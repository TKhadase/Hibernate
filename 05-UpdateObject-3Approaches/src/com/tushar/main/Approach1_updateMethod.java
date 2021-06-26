package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection;

public class Approach1_updateMethod {

	public static void main(String[] args) {
		
		Transaction tX =null;
		
		System.out.println("Approach1_updateMethod.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			
			Product p1 = new Product();
			p1.setPID(10);
			p1.setPrice(100.0);
			p1.setProdname("Nova Trimmer");
			p1.setQty(0);
			p1.setStatus("NA");
			
			tX = ses.beginTransaction();//start Transaction
			ses.update(p1); // given SQL instruction
			tX.commit();//commit SQL instruction
			System.out.println("Record Updated");
			
		}catch(HibernateException e) {
			if(tX!=null || tX.getRollbackOnly() || tX.getStatus()!=null)
				tX.rollback();
			
			System.out.println("Record not Updated");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null || tX.getRollbackOnly() || tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not Updated");
			e.printStackTrace();
		}

	}

}
