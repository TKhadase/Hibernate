package com.tushar.main;

import java.util.Random;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class GeneratorTest{

	public static void main(String[] args) {
		
		Transaction tX =null;
		
		System.out.println("GeneratorTest.main() STARTED");
		
		try(SessionFactory factory =HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();
				)
		{
			
			Product p1 = new Product();
		
			p1.setPrice(514.0);
			p1.setProdname("Driver set"+ new Random().nextInt());
			p1.setQty(12);
			p1.setStatus("AAs");
		
			tX = ses.beginTransaction();//start Transaction
			
			int id =(int) ses.save(p1); // given SQL instruction
			
			//String id =(String) ses.save(p1); //use this for  uuid & guid generator & for custom generato
			
			tX.commit();//commit SQL instruction
			System.out.println("Record inserted with ID::"+id);
			
		}catch(HibernateException e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			
			System.out.println("Record not inserted");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not inserted");
			e.printStackTrace();
		}

	}

}
