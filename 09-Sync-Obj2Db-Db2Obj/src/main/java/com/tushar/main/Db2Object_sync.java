package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection;

public class Db2Object_sync{

	public static void main(String[] args) {
		//same as 07-saveOrUpdate, only changes in mapping file: product.hbm.xml
		Transaction tX =null;
		
		System.out.println("Db2Object_sync.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			
			Product p1 = ses.get(Product.class, 15); //get Data
			System.out.println("actual data:"+p1);
			
			Thread.sleep(30000);
			ses.refresh(p1); // sync object with DB
			
			System.out.println("Record Updated");
			System.out.println("updated data:"+p1);
			
		}catch(HibernateException e) {
			System.out.println("Record not updated");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Record not Updated");
			e.printStackTrace();
		}

	}

}
