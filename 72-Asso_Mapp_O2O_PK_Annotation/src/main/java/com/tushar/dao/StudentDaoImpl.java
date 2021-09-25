package com.tushar.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tushar.model.Library;
import com.tushar.model.StudentInfo;
import com.tushar.utility.HBConnection_improved;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public void saveStudentInfo_Parent_to_child() {
		Transaction tx =null;
		try(Session ses = HBConnection_improved.getSession()) {
			tx =ses.beginTransaction();
			StudentInfo s1 = new StudentInfo("Tushar","Khadse", "Ytl");
			Library lib1 = new Library("SILVER", "ACTIVE",  new Date());
			
			s1.setLibrary(lib1);
			lib1.setStudent(s1);
			
			ses.save(s1);
			tx.commit();
			System.out.println("record inserted successfully");
		}catch(HibernateException he) {
			System.out.println("saveStudentInfo -HibernateException :: Problem occured while saving");
			he.printStackTrace();
			if(tx!=null || tx.getRollbackOnly()  || tx.getStatus()!=null) {
				tx.rollback();
			}
		}
		catch(Exception e) {
			System.out.println("saveStudentInfo -HibernateException :: Problem occured while saving");
			e.printStackTrace();
			if(tx!=null || tx.getRollbackOnly()  || tx.getStatus()!=null) {
				tx.rollback();
			}
		}
		
		
	}

	@Override
	public void saveStudentInfo_child_to_Parent() {
		Transaction tx =null;
		try(Session ses = HBConnection_improved.getSession()) {
			StudentInfo s1 = new StudentInfo("Tushar","Khadse", "Ytl");
			Library lib1 = new Library("SILVER", "ACTIVE",  new Date());
			
			s1.setLibrary(lib1);
			lib1.setStudent(s1);
			tx =ses.beginTransaction();
			ses.save(lib1);
			tx.commit();
			System.out.println("record inserted successfully");
		}catch(HibernateException he) {
			System.out.println("saveStudentInfo -HibernateException :: Problem occured while saving");
			he.printStackTrace();
			if(tx!=null || tx.getRollbackOnly()  || tx.getStatus()!=null) {
				tx.rollback();
			}
		}
		catch(Exception e) {
			System.out.println("saveStudentInfo -HibernateException :: Problem occured while saving");
			e.printStackTrace();
			if(tx!=null || tx.getRollbackOnly()  || tx.getStatus()!=null) {
				tx.rollback();
			}
		}
		
		
	}

	@Override
	public void getStudentInfo() {

		try(Session ses = HBConnection_improved.getSession()) {

			Query query = ses.createQuery("from StudentInfo");
			List<StudentInfo>  list = query.getResultList();
			list.forEach(student ->{
				System.out.println("Student:: "+student);
				System.out.println("Library:: "+student.getLibrary());
			});
			
		}catch(HibernateException he) {
			System.out.println("getStudentInfo -HibernateException :: Problem occured while fetching");
			he.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("getStudentInfo -HibernateException :: Problem occured while fetching");
			e.printStackTrace();
		}
		
		
	
		
	}
	
	
	
}
