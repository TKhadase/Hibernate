package com.tushar.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBConnection_MySQL {

	private static SessionFactory factory =null;
	
	static {
		
		try {
		Configuration cfg =new Configuration();
		cfg.configure("/com/tushar/common/Hibernate-mysql.cfg.xml");
		factory = cfg.buildSessionFactory();
	}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	}//static
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}//getSessionFactory
	
	public static Session getSession() {
		Session ses =null;
		if(factory!=null) {
			ses = factory.openSession();
		}
		return ses;
	}//getSession
	
	public static void closeSession(Session ses) {
		if(ses !=null) {
			ses.close();
		}
	}//closeSession

	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}//closeSessionFactory
	
	
}
