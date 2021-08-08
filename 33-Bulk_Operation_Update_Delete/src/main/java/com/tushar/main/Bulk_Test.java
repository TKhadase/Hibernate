package com.tushar.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class Bulk_Test{

	public static void main(String[] args) {
		
		System.out.println("Bulk_Test.main() STARTED");
		Transaction tX =null;
		
		try(SessionFactory factory =HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();
				)
		{
			tX = ses.beginTransaction();
			
			System.out.println("---------------------UPDATE----------executeUpdate-------------");
			Query queryUpdate =ses.createQuery("UPDATE Product p SET p.status=:newStatus  WHERE p.status=?1");
			queryUpdate .setParameter("newStatus", "A");
			queryUpdate.setParameter(1, "AAs");
			int iUpdate=queryUpdate.executeUpdate();
			System.out.println(iUpdate+" no. of Records Updated");
		
			System.out.println("---------------------DELETE----------executeUpdate-------------");
			Query queryDelete =ses.createQuery("DELETE FROM Product p  WHERE p.PID=?1");
			queryDelete.setParameter(1, 66);
			int iDelete=queryDelete.executeUpdate();
			System.out.println(iDelete+" no. of Records Deleted");
			
			tX.commit();
		}catch(HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
		}
		catch(Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
		}

	}

}
