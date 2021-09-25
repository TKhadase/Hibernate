package com.tushar.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tushar.model.DrivingLicense;
import com.tushar.model.Person;
import com.tushar.utility.HBConnection_improved;

public class LicensDaoImpl implements ILicenseDao {

	@Override
	public void save_child_to_Parent() {
		
		Transaction tx =null;
		try(Session ses =HBConnection_improved.getSession()) {
			
			Person person = new Person("Tushar", "Khadse","YTL");
			DrivingLicense license  = new DrivingLicense("2W", "ACTIVE", new Date(), new  Date(150, 03, 31), person);
			
			tx =ses.beginTransaction();
			ses.save(license);
			tx.commit();
			System.out.println("Licence Details Saved ! ");
			
		}
		catch(HibernateException he) {
			System.out.println("HibernateException::  Error saving data");
			he.printStackTrace();
			if(tx.getRollbackOnly() || tx.getStatus()!=null || tx  !=null) {
				tx.rollback();
			}
		}
		catch(Exception e) {
			System.out.println("Exception::  Error saving data");
			e.printStackTrace();
			if(tx.getRollbackOnly() || tx.getStatus()!=null || tx  !=null) {
				tx.rollback();
			}
		}
		
	}//save_child_to_Parent

	@Override
	public void getInfo() {
		try(Session ses =HBConnection_improved.getSession()) {
			
			Query query = ses.createQuery("from DrivingLicense");
			List<DrivingLicense> licenses =  query.getResultList();
			licenses.forEach(license ->{
				System.out.println(license +"-- "+license.getPerson());
			});
		
		}
		catch(HibernateException he) {
			System.out.println("HibernateException::  Error Fetching data");
			he.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Exception::  Error Fetching data");
			e.printStackTrace();
		}
		
	}//getInfo
	
	
}
