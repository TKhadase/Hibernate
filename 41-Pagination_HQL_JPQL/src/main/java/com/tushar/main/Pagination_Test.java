package com.tushar.main;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class Pagination_Test {

	public static void main(String[] args) {

		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {

			System.out.println("**************************JPQL_Pagination_Test STARTED **************************");	
			int PageSize_JPQL=3;
			List<Product> list1_JPQL =null;
			int currPage_JPQL =1;
			
			Query queryCount_JPQL = ses.createQuery("select Count(*) from Product");
			long totalRows_JPQL =(long) queryCount_JPQL.getSingleResult();
			long pageCount_JPQL  = totalRows_JPQL/PageSize_JPQL;
			pageCount_JPQL =    (totalRows_JPQL%pageCount_JPQL==0 ) ? pageCount_JPQL:  pageCount_JPQL++;
			
			System.out.println("pageCount:"+pageCount_JPQL);
			System.out.println("totalRows:"+totalRows_JPQL);
			
			Query query1_JPQL = ses.createQuery("from Product");
			for (int i = 0; i <= totalRows_JPQL; i += PageSize_JPQL) {
				list1_JPQL =null;
				
				try {
				query1_JPQL.setFirstResult(i);
				query1_JPQL.setMaxResults(PageSize_JPQL);
				list1_JPQL = query1_JPQL.getResultList();
				System.out.println("---------------Page ::"+currPage_JPQL+"---------");
				list1_JPQL.forEach(System.out::println);
				currPage_JPQL++;
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			System.out.println("**************************NativeSQL_Pagination_Test STARTED **************************");
			int PageSize_native=3;
			List<Product> list1_native =null;
			int currPage_native =1;
			
			NativeQuery queryCount_native = ses.createNativeQuery("select Count(*) from Product");
			queryCount_native.addScalar("Count(*)", StandardBasicTypes.LONG);
			long totalRows_native =(long) queryCount_native.getSingleResult();
			
			long pageCount_native  = totalRows_native/PageSize_native;
			pageCount_native =    (totalRows_native%pageCount_native==0 ) ? pageCount_native:  pageCount_native++;
			
			System.out.println("pageCount:"+pageCount_native);
			System.out.println("totalRows:"+totalRows_native);
			
			NativeQuery query1_native = ses.createNativeQuery("select * from Product");
			query1_native.addEntity(Product.class);
			for (int i = 0; i <= totalRows_native; i += PageSize_native) {
				list1_native =null;
				
				try {
				query1_native.setFirstResult(i);
				query1_native.setMaxResults(PageSize_native);
				list1_native = query1_native.getResultList();
				System.out.println("---------------Page ::"+currPage_native+"---------");
				list1_native.forEach(System.out::println);
				currPage_native++;
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
		}//try
		catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			}//catch
		 catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			}//catch

	}//main

}//class