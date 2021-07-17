package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.EmployeeDetails;
import com.tushar.model.EmployeeID;
import com.tushar.utility.HBConnection_improved;

public class saveOrUpdateTest{

	public static void main(String[] args) {
		
		Transaction tX =null;
		
		System.out.println("saveOrUpdateTest.main() STARTED");
		
		try(SessionFactory factory =HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();
				)
		{
			tX =ses.beginTransaction();
			EmployeeDetails e1 = new EmployeeDetails();
			EmployeeID eid = new EmployeeID(01, "KMBL");
			
			e1.setEid(eid);
			e1.setEname("Priya");
			e1.setDesg("Analyst");
			e1.setLevel(1);
			e1.setSalary(45000.0);
			
			ses.save(e1);
			tX.commit();//commit SQL instruction
			System.out.println("Record inserted/Updated");
			
			EmployeeDetails e= ses.load(EmployeeDetails.class, eid);
			if(e !=null) {
				System.out.println(e);				
			}
			
		}catch(HibernateException e) {
			e.printStackTrace();
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			
			System.out.println("Record not inserted/Updated");
		}
		catch(Exception e) {
			e.printStackTrace();
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not inserted/Updated");
		}

	}

}
