package com.tushar.main;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Student;
import com.tushar.model.iStudent;
import com.tushar.utility.HBConnection;

public class Load_usingAnnotations {

	public static void main(String[] args) {

		System.out.println("Load_usingAnnotations.main() STARTED");
		int roll_no =2;
		try (SessionFactory factory = HBConnection.getSessionFactory();
				Session ses = HBConnection.getSession();)
		{
			iStudent s1 = ses.load(iStudent.class, roll_no);
			
			System.out.println("Student with rollNo#"+roll_no+" is ::" + s1);
			s1.setRemarks("Need to work on more");
			System.out.println("Student with rollNo#"+roll_no+" is ::" + s1);

		}
		 catch (ObjectNotFoundException  e) {
				System.out.println("Student with rollNo#"+roll_no+" Does not exist" );
			}
		catch (HibernateException e) {
			System.out.println("problem reading Record " + e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("problem reading Record " + e);
			e.printStackTrace();
		}

	}

}
