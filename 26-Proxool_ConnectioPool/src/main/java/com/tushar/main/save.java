package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Student;
import com.tushar.model.Student;
import com.tushar.utility.HBConnection_improved;

public class save{

	public static void main(String[] args) {
		Transaction tX =null;
		System.out.println("save.main() STARTED");
		
		try(SessionFactory factory =HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();
				)
		{
			tX = ses.beginTransaction();
			int id=30;
			Student s1  =new Student();
			s1.setSID(id);
			s1.setSname("priya");
			s1.setMarks(7210.0);
			s1.setPercent(91);
			s1.setResult("pass");
			
			ses.save(s1);  
			tX.commit();
			tX = ses.beginTransaction();
			System.out.println("Record  inserted");
			Student s2  =ses.get(Student.class, id);
			s2.setSname("priyu");
			
			Thread.sleep(10000);
			ses.update(s2);  
			tX.commit();
			System.out.println("Record  created "+s2.getDtCreated());
			System.out.println("Record  Updated "+s2.getUpdateCount()+" times");
			System.out.println("Record  Updated at"+s2.getDtLastUpdated());
			
		}catch(HibernateException e) {
			e.printStackTrace();
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record  not inserted");
		
		}
		catch(Exception e) {
			e.printStackTrace();
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record  not inserted");
		}

	}

}
