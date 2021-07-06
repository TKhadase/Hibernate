package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Student;
import com.tushar.model.Student;
import com.tushar.utility.HBConnection;

public class DynamicSchema_hbm2ddl_auto{

	public static void main(String[] args) {
		//same as 07-saveOrUpdate, only changes in mapping file: product.hbm.xml
		Transaction tX =null;
		
		System.out.println("DynamicSchema_hbm2ddl_auto.main() STARTED");
		
		try(SessionFactory factory =HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();
				)
		{
			tX = ses.beginTransaction();
			
			Student s1  =new Student();
			s1.setSID(1);
			s1.setSname("priya");
			s1.setMarks(720.0);
			s1.setPercent(89);
			s1.setResult("pass");
			
			ses.save(s1);  
			//in cfg.xml
			//hbm2ddl.auto=update ::: creates new table if not available, or uses it if available, or alters if new column required
			//hbm2ddl.auto=create :::   creates new table if not available, or uses it if available.
			//hbm2ddl.auto=validate ::: default. Does nothing, just check whether tables available or not with required column and data types.
			//hbm2ddl.auto=create-drop :::  creates new table upon factory object creation and drops after on application stops
			
			tX.commit();
			System.out.println("Record  inserted");
			
		}catch(HibernateException e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record  not inserted");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record  not inserted");
			e.printStackTrace();
		}

	}

}
