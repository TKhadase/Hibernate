package com.tushar.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HBConnection_improved {

	private static SessionFactory factory =null;
	
	static {
		System.out.println("HBConnection_improved.enclosing_method()");
		try {
		Configuration cfg =new Configuration();
		
		/*StandardServiceRegistryBuilder stdServRegBulder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry stdServReg = stdServRegBulder.configure("/com/tushar/common/Hibernate.cfg.xml") .build();
		factory = cfg.buildSessionFactory(stdServReg);
		*/
		
		cfg.configure("/com/tushar/common/Hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		
	}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	}//static
	
	public static SessionFactory getSessionFactory() {
		System.out.println("HBConnection_improved.getSessionFactory()");
		return factory;
	}//getSessionFactory
	
	public static Session getSession() {
		Session ses =null;
		if(factory!=null) {
			System.out.println("HBConnection_improved.getSession()");
			ses = factory.openSession();
		}
		return ses;
	}//getSession
	
	public static void closeSession(Session ses) {
		if(ses !=null) {
			System.out.println("HBConnection_improved.closeSession()");
			ses.close();
		}
	}//closeSession

	public static void closeSessionFactory() {
		if(factory!=null) {
			System.out.println("HBConnection_improved.closeSessionFactory()");
			factory.close();
		}
	}//closeSessionFactory
	
	
}
