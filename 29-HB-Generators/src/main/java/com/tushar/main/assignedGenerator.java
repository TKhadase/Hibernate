package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class assignedGenerator{

	public static void main(String[] args) {
		
		Transaction tX =null;
		
		System.out.println("assignedGenerator.main() STARTED");
		
		try(SessionFactory factory =HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();
				)
		{
			
			Product p1 = new Product();
			//p1.setPID(14); //when asssigned Generator cfg <generator class="assigned"></generator> is used.
			
			/*for <generator class="increment"></generator>
			 *  no need to specify id Val. Suitable for MultiThreaded env. but not for Clustered env
			 */
			
			/*for <generator class="identity"></generator>
			 *  no need to specify id Val. Suitable for MultiThreaded env.  &  Clustered env also
			 */
			
			p1.setPrice(5244.0);
			p1.setProdname("Screw box");
			p1.setQty(2);
			p1.setStatus("A");
		
			tX = ses.beginTransaction();//start Transaction
			
			int id =(int) ses.save(p1); // given SQL instruction
			
			tX.commit();//commit SQL instruction
			System.out.println("Record inserted with ID::"+id);
			
		}catch(HibernateException e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			
			System.out.println("Record not inserted");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not inserted");
			e.printStackTrace();
		}

	}

}
