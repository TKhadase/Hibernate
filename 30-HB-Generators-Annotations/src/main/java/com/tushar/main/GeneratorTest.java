package com.tushar.main;

import java.util.Random;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class GeneratorTest{

	public static void main(String[] args) {
		
		Transaction tX =null;
		
		System.out.println("GeneratorTest.main() STARTED");
		
		try(SessionFactory factory =HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();
				)
		{
			
			Product p1 = new Product();
			//p1.setPID(14); //when asssigned Generator cfg <generator class="assigned"></generator> is used.
			
			
			/*for
			 * @Id
				@GenericGenerator(name = "PID_PRODUCT_Generator", strategy = "increment")
				@GeneratedValue(generator = "PID_PRODUCT_Generator")
				private int PID;
			 *  no need to specify id Val. Suitable for MultiThreaded env. but not for Clustered env
			 */
			
			
			/*for <generator class="identity"></generator>
			 *  no need to specify id Val. Suitable for MultiThreaded env.  &  Clustered env also
			 */
			
			
			/*for <generator class="sequence">
						<param name="sequence_name">PROD_ID_SEQ</param>
						<param name="initial_value">41</param>
						<param name="increment_size">1</param>
					</generator>
			 *  no need to specify id Val. Suitable for MultiThreaded env.  &  Clustered env also
			 *  internally it will create new sequence in ORACLE DB and in MYSQL it creates table to store/retrieve sequence value
			 *  ORACLE:: Hibernate: create sequence PROD_ID_SEQ start with 41 increment by  1
			 *  MYSQL:: create table PROD_ID_SEQ ( next_val bigint  )
			 */
			
			
			/*
			 * HILO generator runs upto HIbernate4.x only
			 * <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
				<dependency>
					<groupId>org.hibernate</groupId>
					<artifactId>hibernate-core</artifactId>
					<version>4.3.11.Final</version>
				</dependency>
			 * <generator class="hilo"> <param
			 * name="table">PROD_ID_HILO</param> 
			 * <param name="column">HI_VAL</param> 
			 * <param  name="max_lo">2</param> 
			 * </generator>
			 *  no need to specify id Val. Suitable for MultiThreaded env.  &  Clustered env also
			 */
			
			
			/*
			 * SEQHILO generator uses sequence interally as source of HI_VAL
			 * Works with sequence supported DB like Oracle...not MySQL
			 <generator class="seqhilo">
				<param name="sequence">PROD_ID_SEQHILO</param>
				<param name="max_lo">2</param>
			</generator>
			 *  no need to specify id Val... Suitable for MultiThreaded env.  &  Clustered env also
			 */
			
			
			/*
			<generator class="native"/>
			Suitable for MultiThreaded env.  &  Clustered env also
			This generator picks up behavior based on underlying DB s/f capability
			like for ORACLE :: sequence generator
			for MySQL :: identity generator
			for other that doesnt support sequence& identity generator:: hilo generator will be picked
			 */
			
			
			/*
			 * <generator class="uuid"/> 
			 * Generates 32 bit hex decimal number
			 * Suitable for MultiThreaded env.  &  Clustered env also
			*/
			
			
			/*
			 * <generator class="guid"/> 
			 * Suitable for MultiThreaded env.  &  Clustered env also
			 * in MySQL uses select   uuid()
			 * in ORACLE  uses select  rawtohex(sys_guid())  from  dual
			*/
			
			/*
			 * <generator class="select"> 
			 * <param name="key">prodname</param>  //here prodname must have unique constaraint
			 * </generator>
			 * <property name="prodname" column="PNAME"  unique-key="true" />
			 * 
							create or replace trigger PROD_ID_TRGR
							BEFORE INSERT ON PRODUCT FOR EACH ROW
							DECLARE
							prod_no number(4);
							BEGIN
							SELECT PROD_ID_SEQ.NEXTVAL INTO prod_no FROM DUAL;
							:new.PID := prod_no;
							END;
							/
			 */

			p1.setPrice(5244.0);
			p1.setProdname("Screw box"+ new Random().nextInt());
			p1.setQty(2);
			p1.setStatus("A");
		
			tX = ses.beginTransaction();//start Transaction
			
			//int id =(int) ses.save(p1); // given SQL instruction
			
			String id =(String) ses.save(p1); //use this for  uuid & guid generator & for custom generato
			
			tX.commit();//commit SQL instruction
			System.out.println("Record inserted with ID::"+id);
			
		}catch(HibernateException e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			
			System.out.println("Record not inserted");
			e.printStackTrace();
		}
		catch(Exception e) {
			if(tX!=null && tX.getRollbackOnly() && tX.getStatus()!=null)
				tX.rollback();
			System.out.println("Record not inserted");
			e.printStackTrace();
		}

	}

}
