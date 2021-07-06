package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection;

public class merge_Approach2_solution{

	public static void main(String[] args) {
		//same as 07-saveOrUpdate, only changes in mapping file: product.hbm.xml
		Transaction tX =null;
		
		System.out.println("merge_Approach2_solution.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			tX = ses.beginTransaction();
			
			Product p1 = ses.get(Product.class, 15);
			if(p1 == null) {
				System.out.println("Record not available");
			}else {
			Product prod = new Product();
			prod.setPID(15);
			prod.setProdname("washer2");
			prod.setPrice(120.0);
			prod.setQty(12);
			prod.setStatus("A");
			System.out.println(p1.hashCode()+": actual data:"+p1);
			
			Product p = (Product)ses.merge(prod); // merges prod data having same id  object in L1 Memory & will return merged object from L1 Memory  
			
			tX.commit();
			System.out.println(prod.hashCode()+": Record merged");
			System.out.println(p.hashCode()+": updated data:"+p);
			
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
