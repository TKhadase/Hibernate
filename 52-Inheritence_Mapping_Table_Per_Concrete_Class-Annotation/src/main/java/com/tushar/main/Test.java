package com.tushar.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tushar.model.Customer;
import com.tushar.model.Employee;
import com.tushar.model.Person;
import com.tushar.utility.HBConnection_improved;

public class Test {

	public static void main(String[] args) {
		Transaction tx =null;
		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {

			tx =ses.beginTransaction();
			System.out.println("**************************Test STARTED **************************");	
				Person person1 = new Person("Tushar", "Khadse", "YTL");
				Customer customer1 = new Customer(1560, "15-08-2021", "Gpay", "Pune");
				Employee employee1 = new Employee( "Ebix", "Analyst", 50000, 2);
				
				int person1id = (int)ses.save(person1);
				ses.save(employee1);
				ses.save(customer1);
			
				tx.commit();
				System.out.println("Person details saved with IDNo#"+person1id);
			
			Query query1 = ses.createQuery("from Person");
			List<Person> person = query1.getResultList();
			person.forEach( p ->{
				System.out.println(p);
			});
			
			Query query2 = ses.createQuery("from Employee");
			List<Employee> emp = query2.getResultList();
			emp.forEach( e ->{
				System.out.println(e);
			});
			
			Query query3 = ses.createQuery("from Customer");
			List<Customer> customer = query3.getResultList();
			customer.forEach( c->{
				System.out.println(c);
			});
			
		}//try
		catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
				tx.rollback();
			}
			}//catch
		 catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
				tx.rollback();
			}
			}//catch

	}//main

}//class