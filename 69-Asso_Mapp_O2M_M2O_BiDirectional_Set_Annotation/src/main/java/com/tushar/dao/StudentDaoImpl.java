package com.tushar.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Phones;
import com.tushar.model.StudentInfo;
import com.tushar.utility.HBConnection_improved;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public void saveStudentInfo() {

		Transaction tx = null;
		try (Session ses = HBConnection_improved.getSession();) {

			tx = ses.beginTransaction();
			System.out.println("**************************O2M INSERT**************************");

			Phones p1 = new Phones("airtel", "7798488512", "personal");
			Phones p2 = new Phones("vodafone", "7798488513", "home");
			
			StudentInfo s1 = new StudentInfo("Tushar", "Khadse", "YTL");
			
			p1.setStudent(s1);
			p2.setStudent(s1);
			s1.setPhones(Set.of(p1,p2));
			
			int s1id = (int) ses.save(s1);

			tx.commit();
			System.out.println("StudentInfo  saved with IDNo#" + s1id);

		} // try
		catch (HibernateException e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
		catch (Exception e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
	}// saveStudentInfo

	@Override
	public void getStudentInfo() {
		try (Session ses = HBConnection_improved.getSession();) {

			System.out.println("**************************O2M SELECT**************************");
			Query query1 = ses.createQuery("from StudentInfo");
			List<StudentInfo> student = query1.getResultList();
			student.forEach(s -> {
				System.out.println(s);
				Set<Phones> phone = s.getPhones();
				phone.forEach(System.out::println);
			});
		} // try
		catch (HibernateException e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
		} // catch
		catch (Exception e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
		} // catch
	}// getStudentInfo

	@Override
	public void addPhoneInfoForStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeStudentAndPhoneInfo(int sid) {
		Transaction tx = null;
		try (Session ses = HBConnection_improved.getSession();) {

			tx = ses.beginTransaction();
			System.out.println("**************************O2M DELETE both**************************");

			StudentInfo s = ses.get(StudentInfo.class, sid);

			if (s != null) {
				ses.delete(s);
				tx.commit();
				System.out.println(sid+": DELETE completed");
			}else {
				System.out.println(sid+": records not found to DELETE");
			}

		} // try
		catch (HibernateException e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
		catch (Exception e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
	}// removeStudentAndPhoneInfo

	@Override
	public void removePhoneInfo(int sid) {
		Transaction tx = null;
		try (Session ses = HBConnection_improved.getSession();) {

			tx = ses.beginTransaction();
			System.out.println("**************************O2M DELETE All child**************************");

			StudentInfo student = ses.get(StudentInfo.class, sid);

			if (student != null) {
				Set<Phones> phones = student.getPhones();
				phones.removeAll(phones);
				tx.commit();
				System.out.println(sid+": DELETE completed");
			}else {
				System.out.println(sid+": records not found to DELETE");
			}

		} // try
		catch (HibernateException e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
		catch (Exception e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
	}// removePhoneInfo
	
	@Override
	public void removeSpecificPhoneInfo(int sid, int pid) {
		Transaction tx = null;
		try (Session ses = HBConnection_improved.getSession();) {

			tx = ses.beginTransaction();
			System.out.println("**************************O2M DELETE specific child**************************");

			StudentInfo student = ses.get(StudentInfo.class, sid);

			if (student != null) {
				Set<Phones> phones = student.getPhones();
				Phones phone2Delete =  ses.get(Phones.class, pid);
				
				if(phone2Delete  != null) {
				phones.remove(phone2Delete);
				tx.commit();
				System.out.println(sid+">child> "+pid+" DELETE completed");
				}else {
					System.out.println(pid+": records not found to DELETE");
				}
				
			}else {
				System.out.println(sid+": records not found to DELETE");
			}

		} // try
		catch (HibernateException e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
		catch (Exception e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
	}// removeSpecificPhoneInfo
	
	@Override
	public void addSpecificPhoneInfo(int sid) {
		Transaction tx = null;
		try (Session ses = HBConnection_improved.getSession();) {

			tx = ses.beginTransaction();
			System.out.println("**************************O2M add child**************************");

			StudentInfo student = ses.get(StudentInfo.class, sid);

			if (student != null) {
				Set<Phones> phones = student.getPhones();
				Phones phone2add =  new Phones("JIO", "123456", "OFC");
				phones.add(phone2add);
				tx.commit();
				System.out.println(sid+">child>  insert completed");
			}else {
				System.out.println(sid+": records not found to insert");
			}

		} // try
		catch (HibernateException e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
		catch (Exception e) {
			System.out.println("Error while performing operations");
			e.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
		} // catch
	}// addSpecificPhoneInfo

}
