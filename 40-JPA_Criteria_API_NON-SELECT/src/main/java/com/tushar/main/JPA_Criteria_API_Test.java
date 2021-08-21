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

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class JPA_Criteria_API_Test {

	public static void main(String[] args) {

		System.out.println("JPA_Criteria_API_Test.main() STARTED");
		Transaction tx =null;
		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {
			tx =ses.beginTransaction();

			System.out.println("--------UPDATE---------");
			CriteriaBuilder cBuilderUpdate = ses.getCriteriaBuilder();
			CriteriaUpdate<Product> cQueryUpdate = cBuilderUpdate.createCriteriaUpdate(Product.class);
			Root<Product> rootUpdate = cQueryUpdate.from(Product.class);
			cQueryUpdate.set(rootUpdate.get("prodname") , "xyz").where(
																																	cBuilderUpdate.equal(rootUpdate.get("PID"),  11)
																																	);
			Query query1 =ses.createQuery(cQueryUpdate);
			int iUpdated = query1.executeUpdate();
			System.out.println("No.of Row's updated:"+iUpdated);
			
			System.out.println("--------DELETE---------");
			CriteriaBuilder cBuilderDelete = ses.getCriteriaBuilder();
			CriteriaDelete<Product> cQueryDelete = cBuilderDelete .createCriteriaDelete(Product.class);
			Root<Product> rootDelete  = cQueryDelete .from(Product.class);
			cQueryDelete .where(
														cBuilderDelete .equal(rootDelete .get("PID"),  11)
														);
			Query query2 =ses.createQuery(cQueryDelete );
			int iDeleted = query2.executeUpdate();
			System.out.println("No.of Row's deleted:"+iDeleted);
		
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tx!=null ||tx.getRollbackOnly() || tx.getStatus()!=null) {
				tx.rollback();
			}
		} catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if(tx!=null ||tx.getRollbackOnly() || tx.getStatus()!=null) {
				tx.rollback();
			}
		}

	}

}

