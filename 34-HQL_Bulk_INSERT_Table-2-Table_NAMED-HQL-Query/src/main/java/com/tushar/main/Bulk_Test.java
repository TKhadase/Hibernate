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
			
			System.out.println("---------------------INSERT TABLE 2 TABLE----------executeUpdate-------------");
			Query query= ses.createNamedQuery("data_transfer_Product_ProductBKP");
			query.setParameter(1, "A");
			int iInsert=  query.executeUpdate();
			System.out.println(iInsert+" no. of Records Inserted");
			
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
