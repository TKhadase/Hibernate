package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Student;
import com.tushar.utility.*;

public class DataTransfer_MySQL_to_Oracle{

	public static void main(String[] args) {
		//same as 07-saveOrUpdate, only changes in mapping file: product.hbm.xml
		Transaction tX =null;
		
		System.out.println("DataTransfer_MySQL_to_Oracle.main() STARTED");
		
		try(SessionFactory mySqlFactory =HBConnection_MySQL.getSessionFactory();
				Session  mySqlSes = HBConnection_MySQL.getSession();
				SessionFactory orclFactory =HBConnection_Oracle.getSessionFactory();
				Session  orclSes = HBConnection_Oracle.getSession();
				)
		{
			Student s = mySqlSes.get(Student.class, 1);
			tX = orclSes.beginTransaction();
			
			orclSes.save(s); //insert mySqlSes  s to orclSes s
		
			tX.commit();
			System.out.println("DataTransfer sucess");
			
		}catch(HibernateException e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("DataTransfer failed");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("DataTransfer failed");
			e.printStackTrace();
		}

	}

}
