package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection;

public class Approach1_deleteMethod {

	public static void main(String[] args) {
		
		Transaction tX =null;
		
		System.out.println("Approach1_deleteMethod.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			
			Product p1 = new Product();
			p1.setPID(10);
		
			tX = ses.beginTransaction();//start Transaction
			
			ses.delete(p1); // given SQL instruction
			
			tX.commit();//commit SQL instruction
			System.out.println("Record deleted");
			
		}catch(HibernateException e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			
			System.out.println("Record not deleted");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not deleted");
			e.printStackTrace();
		}

	}

}
