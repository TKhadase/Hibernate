package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection;

public class Approach2_load_updateMethod {

public static void main(String[] args) {
		
		Transaction tX =null;
		
		System.out.println("Approach2_load_updateMethod.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			tX = ses.beginTransaction();//start Transaction
			
			Product p1 = ses.load(Product.class, 11);
			p1.setQty(10);
			p1.setStatus("A");
			
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
