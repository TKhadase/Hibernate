package com.tushar.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tushar.model.Doctor;
import com.tushar.model.Patients;
import com.tushar.utility.HBConnection_improved;

public class HospitalDaoImpl implements IHospitalDao {

	@Override
	public void saveDoctorPatientDetails() {
		
		Transaction tx=null;
		try (Session ses = HBConnection_improved.getSession()){
			Doctor d1 =new Doctor("Tushar", 2, "HEART");
			Doctor d2 =new Doctor("XYZ", 5, "BONES");
			Patients p1 =new Patients(101, "ABCD", "HEART ATTACK",  LocalDate.now());
			Patients p2 =new Patients(101, "PQRS", "HEART FAIL",  LocalDate.now());
			d1.setPatients(List.of(p1,p2));
			p1.setDoctor(List.of(d1, d2));
			p2.setDoctor(List.of(d1));
			
			tx =ses.beginTransaction();
			ses.save(d1);
			ses.save(d2);
			tx.commit();
			System.out.println("Doctor-Patients details saved" );
		}//try
		catch(HibernateException he) {
			System.out.println("saveDoctorPatientDetails() :: Error while saving details");
			he.printStackTrace();
			if(tx !=null  || tx.getRollbackOnly() || tx.getStatus() !=null) {
				tx.rollback();	
			}
		}//HibernateException
		catch(Exception e) {
			System.out.println("saveDoctorPatientDetails() :: Error while saving details");
			e.printStackTrace();
			if(tx !=null  || tx.getRollbackOnly() || tx.getStatus() !=null) {
				tx.rollback();	
			}
		}//Exception
		
		}//saveDoctorPatientDetails

	@Override
	public void savePatientDoctorDetails() {
		
		Transaction tx=null;
		try (Session ses = HBConnection_improved.getSession()){
			Doctor d1 =new Doctor("Tushar2", 2, "HEART");
			Doctor d2 =new Doctor("XYZ2", 5, "BONES");
			Patients p1 =new Patients(103, "ABCD2", "HEART ATTACK",  LocalDate.now());
			Patients p2 =new Patients(104, "PQRS2", "HEART FAIL",  LocalDate.now());
			d1.setPatients(List.of(p1,p2));
			p1.setDoctor(List.of(d1, d2));
			p2.setDoctor(List.of(d1));
			
			tx =ses.beginTransaction();
			ses.save(p1);
			ses.save(p2);
			tx.commit();
			System.out.println("Patients-Doctor details saved" );
		}//try
		catch(HibernateException he) {
			System.out.println("saveDoctorPatientDetails() :: Error while saving details");
			he.printStackTrace();
			if(tx !=null  || tx.getRollbackOnly() || tx.getStatus() !=null) {
				tx.rollback();	
			}
		}//HibernateException
		catch(Exception e) {
			System.out.println("saveDoctorPatientDetails() :: Error while saving details");
			e.printStackTrace();
			if(tx !=null  || tx.getRollbackOnly() || tx.getStatus() !=null) {
				tx.rollback();	
			}
		}//Exception
		
		}//savePatientDoctorDetails

	@Override
	public void getDoctorPatientDetails() {
	
		try (Session ses = HBConnection_improved.getSession()){
		Query query = ses.createQuery("from Doctor");
		List<Doctor> doctor= 	query.getResultList();
		doctor.forEach( dr ->{
			System.out.println("Doctor: "+dr);
			List<Patients> patients = dr.getPatients();
			patients.forEach(System.out::println);
		});
		
		}//try
		catch(HibernateException he) {
			System.out.println("getDoctorPatientDetails() :: Error while fetching details");
			he.printStackTrace();
		}//HibernateException
		catch(Exception e) {
			System.out.println("getDoctorPatientDetails() :: Error while fetching details");
			e.printStackTrace();
		}//Exception
		
	}
	
	
	
}
