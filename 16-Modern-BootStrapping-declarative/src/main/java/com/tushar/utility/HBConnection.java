package com.tushar.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HBConnection {

	private static SessionFactory factory =null;
	
	static {
		
		try {
		Configuration cfg =new Configuration();
		cfg.configure("/com/tushar/common/Hibernate.cfg.xml");
		cfg.addResource("/com/tushar/model/Student.hbm.xml");
		
		StandardServiceRegistryBuilder stdServRegBulder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry stdServReg = stdServRegBulder.applySettings(cfg.getProperties()).build();
		
		factory = cfg.buildSessionFactory(stdServReg);
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
