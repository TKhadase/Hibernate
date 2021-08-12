package com.tushar.main;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class DDL_CRUD_Test {

	public static void main(String[] args) {

		System.out.println("DDL_CRUD_Test.main() STARTED");
		Transaction tX = null;

		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {
				tX = ses.beginTransaction();
			
			System.out.println("---------------------SELECT *-----addEntity(Product.class)-----getResultList-------------");
			NativeQuery query1 = ses.createNativeQuery("SELECT * FROM PRODUCT P WHERE P.STATUS=?");
			query1.addEntity(Product.class);
			query1.setParameter(1, "A");
			List<Product> listProd1 = query1.getResultList();
			listProd1.forEach(System.out::println);

			System.out.println("---------------------SELECT *------List<Object[]>----getResultList-------------");
			NativeQuery query2 = ses.createNativeQuery("SELECT * FROM PRODUCT P WHERE P.STATUS=?");
			query2.setParameter(1, "A");
			List<Object[]> listProd2 = query2.getResultList();
			listProd2.forEach(prodObj -> {
				for (Object objects : prodObj) {
					System.out.print(objects + "   ");
				}
				System.out.println();
			});

			System.out.println("---------------------SELECT <specific cols>---addScalar(-,TYPE)---List<Object[]>----getResultList-------------");
			NativeQuery query3 = ses
					.createNativeQuery("SELECT PID,PRODNAME,PRICE,STATUS,QTY FROM PRODUCT P WHERE P.STATUS=?");
			// register each column name
			query3.addScalar("PID", StandardBasicTypes.INTEGER);
			query3.addScalar("PRODNAME", StandardBasicTypes.STRING);
			query3.addScalar("PRICE", StandardBasicTypes.DOUBLE);
			query3.addScalar("STATUS", StandardBasicTypes.STRING);
			query3.addScalar("QTY", StandardBasicTypes.INTEGER);

			// specify input values
			query3.setParameter(1, "A");
			// execute
			List<Object[]> listProd3 = query3.getResultList();
			listProd3.forEach(prodObj -> {
				for (Object objects : prodObj) {
					System.out.print(objects + "   ");
				}
				System.out.println();
			});

			System.out.println("---------------------SELECT <one col>---addScalar(-,TYPE)---List<one col Type>----getResultList-------------");
			NativeQuery query4 = ses.createNativeQuery("SELECT  PRODNAME  FROM PRODUCT P WHERE P.STATUS=?");
			// register each column name
			query4.addScalar("PRODNAME", StandardBasicTypes.STRING);
			// specify input values
			query4.setParameter(1, "A");
			// execute
			List<String> listProd4 = query4.getResultList();
			listProd4.forEach(prodObj -> {
				System.out.println(prodObj);
			});

			System.out.println("---------------------SELECT <count(*)>---addScalar(-,TYPE)---<one col Type>----getSingleResult-------------");
			NativeQuery query5 = ses.createNativeQuery("SELECT COUNT(*)  FROM PRODUCT P WHERE P.STATUS=?");
			// register each column name
			query5.addScalar("COUNT(*)", StandardBasicTypes.INTEGER);
			// specify input values
			query5.setParameter(1, "A");
			// execute
			int count5 = (int) query5.getSingleResult();
			System.out.println("PRODUCT count:" + count5);

			System.out.println("---------------------SELECT <AGGREGATE VALUES>---addScalar(-,TYPE)---Object[]----getSingleResult-------------");
			NativeQuery query6 = ses.createNativeQuery("SELECT COUNT(*), MAX(PID), MIN(PID), SUM(PID), AVG(PID)  FROM PRODUCT");
			// register each column name
			query6.addScalar("COUNT(*)", StandardBasicTypes.INTEGER);
			query6.addScalar("MAX(PID)", StandardBasicTypes.INTEGER);
			query6.addScalar("MIN(PID)", StandardBasicTypes.INTEGER);
			query6.addScalar("SUM(PID)", StandardBasicTypes.INTEGER);
			query6.addScalar("AVG(PID)", StandardBasicTypes.INTEGER);
			// execute
			Object[] aggregateData = (Object[]) query6.getSingleResult();
			System.out.println("COUNT :: "+aggregateData[0]);
			System.out.println("MAX :: "+aggregateData[1]);
			System.out.println("MIN :: "+aggregateData[2]);
			System.out.println("SUM :: "+aggregateData[3]);
			System.out.println("AVG :: "+aggregateData[4]);

			tX.commit();
		} catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if (tX != null && tX.getRollbackOnly() && tX.getStatus() != null)
				tX.rollback();
		} catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
			if (tX != null && tX.getRollbackOnly() && tX.getStatus() != null)
				tX.rollback();
		}

	}

}
