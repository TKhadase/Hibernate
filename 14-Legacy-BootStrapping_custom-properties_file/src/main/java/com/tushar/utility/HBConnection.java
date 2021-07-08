package com.tushar.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBConnection {

	private static SessionFactory factory =null;
	
	static {
		
		try {
		Properties HBprops = new Properties();
		InputStream is  = new FileInputStream("src/main/java/com/tushar/common/myHB.properties");
		HBprops.load(is);//loads all properties from is
		
		Configuration cfg =new Configuration();
		cfg.setProperties(HBprops);
		cfg.addFile("src/main/java/com/tushar/model/Student.hbm.xml");
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
