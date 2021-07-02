package com.tushar.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.utility.HBConnection;

public class merge_Approach2_Problem {

	public static void main(String[] args) {
		//same as 07-saveOrUpdate, only changes in mapping file: product.hbm.xml
		Transaction tX =null;
		
		System.out.println("merge_Approach2_Problem.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			tX = ses.beginTransaction();
			
			Product prod = ses.get(Product.class, 15) ;
			
			if(prod ==null) {
				System.out.println("record not available");
			}else {
			Product p1 = new Product();
			p1.setPID(15);
			p1.setProdname("cleaner liquid1");
			p1.setPrice(110.0);
			System.out.println("Actual data:"+prod);
			
			ses.update(p1); //wont be able to update record, as hibernate L1 cache allow only 1 copy of each entity class with uniquie id.
			
			tX.commit();
			System.out.println("Record merged");
			System.out.println("updated data:"+p1);
			}
			
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
