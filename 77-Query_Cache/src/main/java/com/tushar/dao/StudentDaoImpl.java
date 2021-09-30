package com.tushar.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Cache;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
			
		System.out.println("Read from DB:: ");
		Query query = ses.createQuery("from StudentInfo"); // org.hibernate.query.Query;
			List<StudentInfo>  list1 = query.getResultList();
			query.setCacheable(true);
			query.setCacheRegion("default-query-results-region");
			
			list1.forEach(student ->{
				System.out.println("Student1:: "+student);
				System.out.println("Library1:: "+student.getLibrary());
			}); 
			
			System.out.println("Getting from  Query Cache:: ");
			List<StudentInfo>  list2 = query.getResultList();
			list2.forEach(student ->{
				System.out.println("Student2:: "+student);
				System.out.println("Library2:: "+student.getLibrary());
			}); 
			
			HBConnection_improved.closeSessionFactory(); //close L2 cache
			
			
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
