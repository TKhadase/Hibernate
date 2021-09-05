package com.tushar.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.StudentInfo;
import com.tushar.utility.HBConnection_improved;

public class Test {

	public static void main(String[] args) {
		Transaction tx =null;
		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {

			tx =ses.beginTransaction();
			System.out.println("**************************Test STARTED **************************");	
			StudentInfo s1 = new StudentInfo("Tushar", "Khadse", "YTL",
																					List.of("ABCD", "PQR", "XYZ"),
																					Set.of("1234", "5678", "9012"),
																					Map.of("ADHAR", "147896325", "PAN","JHASJ57") );
				s1.setCities(List.of("Ytl", "Pune"));
				int s1id = (int)ses.save(s1);
			
				tx.commit();
				System.out.println("StudentInfo  saved with IDNo#"+s1id);
			
			Query query1 = ses.createQuery("from StudentInfo");
			List<StudentInfo> student = query1.getResultList();
			student.forEach( s ->{
				System.out.println(s);
			});
			
		}//try
		catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
				tx.rollback();
			}
			}//catch
		 catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
				tx.rollback();
			}
			}//catch

	}//main

}//class