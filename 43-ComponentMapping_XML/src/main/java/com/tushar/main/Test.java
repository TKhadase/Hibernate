package com.tushar.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Students;
import com.tushar.model.StudentsResult;
import com.tushar.utility.HBConnection_improved;

public class Test {

	public static void main(String[] args) {
		Transaction tx =null;
		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {

			tx =ses.beginTransaction();
			System.out.println("**************************Test STARTED **************************");	
			StudentsResult result = new StudentsResult("Pass", "Good");
			Students s1 = new Students("Tushar", "Khadse", "Ytl", result);
			int rollNo = (int) ses.save(s1);
			tx.commit();
			
			System.out.println("Students details saved with RollNo#"+rollNo);
			
			Query query = ses.createQuery("from Students");
			List<Students> student = query.getResultList();
			student.forEach( s ->{
				System.out.println(s);
				System.out.println(s.getResult());
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