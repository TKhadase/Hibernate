package com.tushar.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class SELECT_Test{

	public static void main(String[] args) {
		
		System.out.println("SELECT_Test.main() STARTED");
		
		try(SessionFactory factory =HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();
				)
		{
			
			System.out.println("---------------------SELECT ALL COLUMN VALUES(ENTITY QUERY)---------getResultList--------------");
			Query query1 =ses.createQuery("FROM Product p WHERE p.status=?1");
			query1 .setParameter(1, "AAs");
			List<Product>  list1 = query1.getResultList();
			list1.forEach(prod->{
					System.out.println(prod);
			});
			
			System.out.println("---------------------SELECT SPECIFIC MULTIPLE COLUMN VALUES(SCALAR QUERY)----------getResultList-------------");
			Query query2 =ses.createQuery("SELECT PID, prodname FROM Product p WHERE p.status=?1");
			query2 .setParameter(1, "AAs");
			List<Object[]>  list2 = query2.getResultList();
			list2.forEach(prod->{
					for(Object p: prod) {
						System.out.print(p+"  ");
					}
					System.out.println();
			});
			
			System.out.println("---------------------SELECT SPECIFIC SINGLE COLUMN VALUES(SCALAR QUERY)--------getResultList---------------");
			Query query3 =ses.createQuery("SELECT  prodname FROM Product  p WHERE p.status=?1");
			query3 .setParameter(1, "AAs");
			List<String>  list3 = query3.getResultList();
			list3.forEach(prod->{
					System.out.println(prod);
			});
			
			System.out.println("---------------------SELECT SPECIFIC SINGLE COLUMN VALUES(SCALAR QUERY)-------getSingleResult----------------");
			Query query4 =ses.createQuery("FROM Product  p WHERE p.PID=?1");
			query4.setParameter(1, 66);
			Product list4 = (Product) query4.getSingleResult();
			if(list4!=null) 
			System.out.println("DATA:: "+list4); 
			else
				System.out.println("Record not found");
			
			System.out.println("---------------------SELECT SPECIFIC MULTIPLE COLUMN VALUES(SCALAR QUERY)----------getSingleResult-------------");
			Query query5=ses.createQuery("SELECT PID, prodname FROM Product p WHERE p.PID=?1");
			query5 .setParameter(1, 66);
			Object[]  list5 = (Object[]) query5.getSingleResult();
			if(list5!=null) 
				System.out.println("DATA:: "+list5[0]+"  "+list5[1]); 
			else
				System.out.println("Record not found");
			
			System.out.println("---------------------SELECT SPECIFIC SINGLE COLUMN VALUES(SCALAR QUERY)--------getSingleResult---------------");
			Query query6 =ses.createQuery("SELECT  prodname FROM Product  p WHERE p.PID=?1");
			query6 .setParameter(1, 66);
			String  list6 = (String) query6.getSingleResult();
			if(list6!=null) 
				System.out.println("DATA:: "+list6); 
			else
				System.out.println("Record not found");
			
		
			System.out.println("---------------------SELECT Aggregate SPECIFIC MULTIPLE COLUMN VALUES(SCALAR QUERY)----------getSingleResult-------------");
			Query query7=ses.createQuery("SELECT COUNT(*), MIN(PID), MAX(PID), SUM(PID), AVG(PID)  FROM Product");
			Object[]  list7 = (Object[]) query7.getSingleResult();
			if(list7!=null) 
				System.out.println("Aggregate DATA:: "+list7[0]+"  "+list7[1]+"  "+list7[2]+"  "+list7[3]+" "+list7[4]); 
			else
				System.out.println("Aggregate Record not found");
			
		}catch(HibernateException e) {
			System.out.println("Record not found");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Record not found");
			e.printStackTrace();
		}

	}

}
