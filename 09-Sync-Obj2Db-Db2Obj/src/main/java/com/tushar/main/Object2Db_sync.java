package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection;

public class Object2Db_sync{

	public static void main(String[] args) {
		//same as 07-saveOrUpdate, only changes in mapping file: product.hbm.xml
		Transaction tX =null;
		
		System.out.println("Object2Db_sync.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			tX = ses.beginTransaction();//start Transaction
			
			Product p1 = ses.get(Product.class, 15);
			System.out.println("actual data:"+p1);
			
			p1.setPrice(121.0);
			p1.setProdname("Cleaner liquid");
			p1.setQty(10);
			p1.setStatus("A");
		
			tX.commit();//commit SQL instruction
			
			System.out.println("Record Updated");
			System.out.println("updated data:"+p1);
			
		}catch(HibernateException e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			
			System.out.println("Record not updated");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not Updated");
			e.printStackTrace();
		}

	}

}
