package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection;

public class merge_alternate_saveOrUpdate_Approach1{

	public static void main(String[] args) {
		//same as 07-saveOrUpdate, only changes in mapping file: product.hbm.xml
		Transaction tX =null;
		
		System.out.println("merge_alternate_saveOrUpdate_Approach1.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			tX = ses.beginTransaction();
			
			Product p1 = new  Product(); 
			p1.setPID(15);
			p1.setProdname("washer1");
			p1.setPrice(110.0);
			p1.setQty(11);
			p1.setStatus("A");
			System.out.println("actual data:"+p1);
			
			ses.merge(p1); // merges p1 data
			
			tX.commit();
			System.out.println("Record merged");
			System.out.println("updated data:"+p1);
			
		}catch(HibernateException e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not merged");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not merged");
			e.printStackTrace();
		}

	}

}
