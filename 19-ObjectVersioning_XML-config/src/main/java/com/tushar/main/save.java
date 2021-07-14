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
			
			Student s1  =new Student();
			s1.setSID(18);
			s1.setSname("priya");
			s1.setMarks(7210.0);
			s1.setPercent(91);
			s1.setResult("pass");
			
			ses.save(s1);  
			tX.commit();
			tX = ses.beginTransaction();
			System.out.println("Record  inserted");
			Student s2  =ses.get(Student.class, 18);
			s2.setSname("priyu");
			ses.update(s2);  
			tX.commit();
			System.out.println("Record  Updated"+s2.getUpdateCount()+" times");
			
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
