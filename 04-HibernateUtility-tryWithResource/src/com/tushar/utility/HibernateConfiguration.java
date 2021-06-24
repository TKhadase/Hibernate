package com.tushar.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

	private static SessionFactory factory;

	static {
		System.out.println("HibernateConfiguration.static()");
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/com/tushar/common/Hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// static

	public static SessionFactory getSessionFactory() {
		System.out.println("HibernateConfiguration.getSessionFactory()");
		if (factory != null)
			return factory;
		else
			throw new RuntimeException("Error in creating session factory");
	}// getSessionFactory

	public static Session getSession() {
		System.out.println("HibernateConfiguration.getSession()");
		Session ses = null;
		if (factory != null)
			ses = factory.openSession();

		return ses;
	}// getSession

	public static void closeSession(Session ses) {
		System.out.println("HibernateConfiguration.closeSession()");
		if (ses != null)
			ses.close();

	}// closeSession

	public static void closeSessionFactory() {
		System.out.println("HibernateConfiguration.closeSessionFactory()");
		if (factory != null)
			factory.close();
	}// closeSessionFactory

}// class
