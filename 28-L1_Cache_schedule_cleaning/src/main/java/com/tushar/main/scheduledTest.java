/*
 * For each session get() call, session is connecting to DB for record 
as session is cleared using clear() periodically
*/
package com.tushar.main;

import java.util.Timer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Student;
import com.tushar.model.Student;
import com.tushar.utility.HBConnection_improved;
import com.tushar.utility.Scheduled_SessionCleaner;

public class scheduledTest {

	public static void main(String[] args) {
		System.out.println("scheduledTest.main() STARTED");
		Timer timer = new Timer();

		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {
			timer.schedule(new Scheduled_SessionCleaner(ses), 10000, 10000);

			int id = 21;
			Student s1 = ses.get(Student.class, id);
			if (s1 != null) {
				System.out.println(s1);
			} else {
				System.out.println("Record  not available");
			}
			System.out.println("--------------------------------------------");
			Thread.sleep(20000);
			Student s2 = ses.get(Student.class, id);
			if (s2 != null) {
				System.out.println(s2);
			} else {
				System.out.println("Record  not available");
			}
			System.out.println("--------------------------------------------");
			Thread.sleep(20000);
			Student s3 = ses.get(Student.class, id);
			if (s3 != null) {
				System.out.println(s3);
			} else {
				System.out.println("Record  not available");
			}
			System.out.println("--------------------------------------------");
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("Record  not available");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Record  not available");
		}

	}

}
