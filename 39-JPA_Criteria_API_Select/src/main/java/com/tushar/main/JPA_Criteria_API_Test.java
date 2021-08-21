package com.tushar.main;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class JPA_Criteria_API_Test {

	public static void main(String[] args) {

		System.out.println("JPA_Criteria_API_Test.main() STARTED");

		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {
			
			System.out.println("--------ENTITY------------SELECT ALL----------------------");
			CriteriaBuilder cBuilder1 =ses.getCriteriaBuilder();
			CriteriaQuery<Product> cQuery1 = cBuilder1.createQuery(Product.class);
			Root rootProd1 = cQuery1.from(Product.class);
			cQuery1.select(rootProd1);
			Query query1 =ses.createQuery(cQuery1);
			List<Product> list1 = query1.getResultList();
			list1.forEach(System.out::println);
			
			System.out.println("--------ENTITY------------SELECT ALL---- condition-------between-------orderBy---");
			CriteriaBuilder cBuilder2 =ses.getCriteriaBuilder();
			CriteriaQuery<Product> cQuery2 = cBuilder2.createQuery(Product.class);
			Root rootProd2 = cQuery2.from(Product.class);
			cQuery2.select(rootProd2).where(  
																				cBuilder2.between(rootProd2.get("PID"),  50, 70)  
																				).orderBy(cBuilder2.asc(
																																rootProd2.get("prodname")
																																)
																						 			) ;
			Query query2 =ses.createQuery(cQuery2);
			List<Product> list2 = query2.getResultList();
			list2.forEach(System.out::println);
			
			System.out.println("--------ENTITY------------SELECT ALL---- multiple CONDITION----ge---and---le------------");
			CriteriaBuilder cBuilder3 =ses.getCriteriaBuilder();
			CriteriaQuery<Product> cQuery3 = cBuilder3.createQuery(Product.class);
			Root rootProd3 = cQuery3.from(Product.class);
			cQuery3.select(rootProd3).where(  
																				cBuilder3.and(  
																											cBuilder3.ge( rootProd3.get("price"), 100) ,    
																											cBuilder3.le(rootProd3.get("price"), 1000) )  
																				);
			Query query3=ses.createQuery(cQuery3);
			List<Product> list3 = query3.getResultList();
			list3.forEach(System.out::println);
			
			
			System.out.println("--------ENTITY------------SELECT ALL---- multiple CONDITION----like-(Case sensitive)--and---le------------");
			CriteriaBuilder cBuilder4 =ses.getCriteriaBuilder();
			CriteriaQuery<Product> cQuery4 = cBuilder4.createQuery(Product.class);
			Root rootProd4 = cQuery4.from(Product.class);
			cQuery4.select(rootProd4).where(  
																				cBuilder4.and(  
																											cBuilder4.like( rootProd4.get("prodname"), "D%") ,    
																											cBuilder4.le(rootProd4.get("price"), 1000) )  
																				);
			Query query4=ses.createQuery(cQuery4);
			List<Product> list4 = query4.getResultList();
			list4.forEach(System.out::println);
			 
		} catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
		}

	}

}

