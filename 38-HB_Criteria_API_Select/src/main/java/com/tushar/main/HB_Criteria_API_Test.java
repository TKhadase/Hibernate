package com.tushar.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class HB_Criteria_API_Test {

	public static void main(String[] args) {

		System.out.println("HB_Criteria_API_Test.main() STARTED");

		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {
			
			System.out.println("--------ENTITY------------SELECT ALL----------------------");
			Criteria criteria1 = ses.createCriteria(Product.class);
			List<Product> prodList1 = criteria1.list();
			prodList1.forEach(System.out::println);
			
			System.out.println("----------ENTITY----------SELECT ALL WITH single CONDITION-------between---------------");
			Criteria criteria2 = ses.createCriteria(Product.class);
			Criterion cond2 = Restrictions.between("PID", 0, 70);
			criteria2.add(cond2);
			List<Product>  prodList2 = criteria2.list();
			prodList2.forEach(System.out::println);
			
			
			System.out.println("----------ENTITY----------SELECT ALL WITH multiple CONDITION----ge---and---le-------------------");
			Criteria criteria3 = ses.createCriteria(Product.class);
			Criterion cond3_1 = Restrictions.ge("price", 50.0);
			Criterion cond3_2 = Restrictions.le("price", 600.0);
			Criterion cond3_1_2 =Restrictions.and(cond3_1, cond3_2);
			criteria3.add(cond3_1_2);
			List<Product>  prodList3 = criteria3.list();
			prodList3.forEach(System.out::println);
			
			System.out.println("----------ENTITY----------SELECT ALL--WITH CONDITION----ilike------case insensitive----------");
			Criteria criteria4 = ses.createCriteria(Product.class);
			Criterion cond4 =Restrictions.ilike("prodname", "d%");
			criteria4.add(cond4);
			List<Product> prodList4 = criteria4.list();
			prodList4.forEach(System.out::println);
			
			System.out.println("---------ENTITY-----------SELECT ALL--WITH CONDITION----like-----case sensitive-----------");
			Criteria criteria5 = ses.createCriteria(Product.class);
			Criterion cond5 =Restrictions.like("prodname", "D%");
			criteria5.add(cond5);
			List<Product> prodList5 = criteria5.list();
			prodList5.forEach(System.out::println);
			
			System.out.println("---------ENTITY-----------SELECT ALL--WITH CONDITION----in------------------");
			Criteria criteria6 = ses.createCriteria(Product.class);
			Criterion cond6 =Restrictions.in("PID", 10,11);
			criteria6.add(cond6);
			List<Product> prodList6 = criteria6.list();
			prodList6.forEach(System.out::println);
			
			System.out.println("--------ENTITY------------SELECT ALL--WITH CONDITION----or------------------");
			Criteria criteria7 = ses.createCriteria(Product.class);
			Criterion cond7 =Restrictions.or(cond4, cond5 );
			criteria7.add(cond7);
			List<Product> prodList7 = criteria7.list();
			prodList7.forEach(System.out::println);
			
			System.out.println("--------SCALAR------------------------------");
			Criteria criteria8 = ses.createCriteria(Product.class);
			//get Columns
			Projection pPID = Projections.property("PID");
			Projection pprodname = Projections.property("prodname");
			ProjectionList projectionsList =Projections.projectionList();
			projectionsList.add(pPID);projectionsList.add(pprodname);
			//get Order if required
			Order order = Order.asc("prodname");
			//set Projection & Order
			criteria8.setProjection(projectionsList);
			criteria8.addOrder(order);
			//execute
			List<Object[]> prodObj8 = criteria8.list();
			prodObj8.forEach(objProd->{
				for (Object val :objProd )	
				{ 
					System.out.print(val+"  ");
				}
				System.out.println();
			});
			
			
		} catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
		}

	}

}

