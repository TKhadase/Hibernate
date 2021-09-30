package com.tushar.main;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.utility.HBConnection_improved;

public class Tx_Test {

	public static void main(String[] args) {

		System.out.println("Tx_Test.main() STARTED");
		Transaction tx=null;
		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {
			tx =ses.beginTransaction();
			Query querySrc =ses.createQuery("update BankAccount set balance=balance-:amt where AID =:srcAc");//debit
			querySrc.setParameter("amt",  500.0);
			querySrc.setParameter("srcAc",  101);
			int resSrc = querySrc.executeUpdate();
			
			Query queryDest =ses.createQuery("update BankAccount set balance=balance+:amt where AID =:dstAc");//credit
			queryDest.setParameter("amt",  500.0);
			queryDest.setParameter("dstAc",  102);
			int resDst = queryDest.executeUpdate();
			
			if(resSrc==0 || resDst==0) {
				tx.rollback();
				System.out.println("Balance Transfer Failed.");
			}
			else {
				tx.commit();
				System.out.println("Balance Transfer successfull.");
			}
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null || tx.getRollbackOnly() || tx.getStatus()!=null)
			{
				tx.rollback();
				System.out.println("Balance Transfer Failed1.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null || tx.getRollbackOnly() || tx.getStatus()!=null)
			{
				tx.rollback();
				System.out.println("Balance Transfer Failed2.");
			}
		}

	}

}

