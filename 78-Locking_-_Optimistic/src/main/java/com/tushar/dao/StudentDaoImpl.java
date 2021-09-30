package com.tushar.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Cache;
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
			
			 int id =(int) ses.save(s1);
			tx.commit();
			System.out.println(s1+"\nrecord inserted successfully with ID:"+id);
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
			
			/*Query query = ses.createQuery("from StudentInfo");
			List<StudentInfo>  list = query.getResultList();
			list.forEach(student ->{
				System.out.println("Student:: "+student);
				System.out.println("Library:: "+student.getLibrary());
			}); */
			
			int  id=207;
			StudentInfo s1 = ses.get(StudentInfo.class, id);
			System.out.println("Read from DB:: Student s1:: "+s1);
			
			StudentInfo s2 = ses.get(StudentInfo.class, id);
			System.out.println("Getting from L1 Cache: Student s2:: "+s2);
			
			ses.clear();
			System.out.println("------------------------clearing L1 Cache------------------------");
			StudentInfo s3 = ses.get(StudentInfo.class, id);
			System.out.println("Getting from L2 Cache: Student s3:: "+s3);
			if(s3!=null)
			ses.evict(s3);
			
			ses.clear();
			System.out.println("------------------------wait 16 second------------------------");
			Thread.sleep(16000);
			System.out.println("------------------------clearing L1,L2 Cache------------------------");
			StudentInfo s4 = ses.get(StudentInfo.class,id);
			System.out.println("Getting from DB: Student s4:: "+s4);
			
			Cache cache = HBConnection_improved.getSessionFactory().getCache();
			ses.clear();
			cache.evictAll();
			System.out.println("------------------------clearing L1,L2 Cache & Closing L1,L2 Cache------------------------");
			//or //cache.evict(StudentInfo.class);
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

	@Override
	public void updateStudentInfo() {
		Transaction tx=null;
		try(Session ses = HBConnection_improved.getSession()) {
			
			int  id=317;
			StudentInfo s1 = ses.get(StudentInfo.class, id);
			System.out.println("updateStudentInfo Read from DB:: Student s1:: "+s1);
			tx =ses.beginTransaction();
			
			s1.setAddrs("PUNE");
			ses.update(s1);
			System.out.println(" going to sleep 50 seconds");
			Thread.sleep(50000);
			System.out.println(" back from  sleep of 50 seconds, to commit records");
			tx.commit();
			System.out.println(s1+ " update succesfully");
		}catch(HibernateException he) {
			System.out.println("getStudentInfo -HibernateException :: Problem occured while fetching:"+he);
			he.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("getStudentInfo -HibernateException :: Problem occured while fetching:"+e);
			e.printStackTrace();
		}
		
		
	}//updateStudentInfo
	
	@Override
	public void updateStudentInfo1() {
		Transaction tx=null;
		try(Session ses = HBConnection_improved.getSession()) {
			
			int  id=317;
			StudentInfo s1 = ses.get(StudentInfo.class, id);
			System.out.println("updateStudentInfo1 Read from DB:: Student s1:: "+s1);
			tx =ses.beginTransaction();
			
			s1.setAddrs("GOA");
			ses.update(s1);
			tx.commit();
			System.out.println(s1+ " update succesfully");
		}catch(HibernateException he) {
			System.out.println("getStudentInfo -HibernateException :: Problem occured while fetching:"+he);
			he.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("getStudentInfo -HibernateException :: Problem occured while fetching:"+e);
			e.printStackTrace();
		}finally {
			HBConnection_improved.closeSessionFactory();
		}
		
	}//updateStudentInfo1
	
}
