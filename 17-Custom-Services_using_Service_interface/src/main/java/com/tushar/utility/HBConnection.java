package com.tushar.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.tushar.services.CustomJDBCserviceConnectionProvider;

public class HBConnection {

	private static SessionFactory factory =null;
	
	static {
		System.out.println("17-HBConnection.enclosing_method()");
		try {
			Configuration cfg =new Configuration();
			StandardServiceRegistryBuilder stdServRegBulder = new StandardServiceRegistryBuilder();
			stdServRegBulder.addService(ConnectionProvider.class, new CustomJDBCserviceConnectionProvider() );
			StandardServiceRegistry stdServReg = stdServRegBulder.configure("/com/tushar/common/Hibernate.cfg.xml") .build();
			
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
