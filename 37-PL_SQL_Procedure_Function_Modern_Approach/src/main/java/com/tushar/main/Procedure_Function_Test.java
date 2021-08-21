package com.tushar.main;


import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;

import com.tushar.model.Product;
import com.tushar.utility.HBConnection_improved;

public class Procedure_Function_Test {

	public static void main(String[] args) {

		System.out.println("Procedure_Function_Test.main() STARTED");

		try (SessionFactory factory = HBConnection_improved.getSessionFactory();
				Session ses = HBConnection_improved.getSession();) {
			
			/*
			 //create  ProcedureCall object
			System.out.println("Calling Procedure:: PRC_GET_AUTH_STATUS");
			ProcedureCall prcCall1 = ses.createStoredProcedureCall("PRC_GET_AUTH_STATUS");
			//register IN, OUT params with values
			prcCall1.registerParameter(1, String.class, ParameterMode.IN).bindValue("Tushar");
			prcCall1.registerParameter(2, String.class, ParameterMode.IN).bindValue("Khadse");
			prcCall1.registerParameter(3, String.class, ParameterMode.OUT);
			//get OUT Param value
			String result= (String) prcCall1.getOutputParameterValue(3);
			System.out.println("PRC_GET_AUTH_STATUS Result ::"+result);
			
			System.out.println("Calling Procedure:: PRC_GET_PRODUCT_BY_STATUS");
			ProcedureCall prcCall2 = ses.createStoredProcedureCall("PRC_GET_PRODUCT_BY_STATUS", Product.class);
			prcCall2.registerParameter(1, String.class, ParameterMode.REF_CURSOR);
			prcCall2.registerParameter(2, String.class, ParameterMode.IN).bindValue("A");
			List<Product> listProd = 	prcCall2.getResultList();
			listProd.forEach(System.out::println);*/
			
			System.out.println("Calling Function:: FUNC_GET_PRODUCT_BY_ID");
			String result[] = ses.doReturningWork(con->{
				//Create CallableStatement object
				CallableStatement cs = con.prepareCall("{?= call FUNC_GET_PRODUCT_BY_ID(?,?,?)}");
				//register  OUT params
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.NUMERIC);
				
				//set input param value
				cs.setInt(2, 68);
				cs.execute();
				
				String data[] = new String[3];
				data[0] =cs.getString(1);
				data[1] =cs.getString(3);
				data[2] =cs.getString(4);
				return data;
			});
			
			for (String val: result)
			{
				System.out.print(val+"-- ");
			}
			
		} catch (HibernateException e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while performing operation");
			e.printStackTrace();
		}

	}

}

/*
 
create table HB_users (username varchar2(15), password varchar2(15));
insert into HB_users (username,password) values('Tushar', 'Khadse');
commit;


CREATE OR REPLACE PROCEDURE PRC_GET_AUTH_STATUS
	(
	IUSERNAME IN VARCHAR2,
	IPASSWORD IN VARCHAR2,
	OSTATUS OUT VARCHAR2
	) AS
	CNT number(3);
	BEGIN
	SELECT COUNT(*) INTO CNT FROM HB_users WHERE username=IUSERNAME and password=IPASSWORD;
	IF(cnt<>0) THEN
	OSTATUS:='VALID CREDENTIALS';
	ELSE
	OSTATUS:='IN-VALID CREDENTIALS';
	END IF;
	END;
	/

CREATE OR REPLACE PROCEDURE PRC_GET_PRODUCT_BY_STATUS
	(
	DETAILS OUT SYS_REFCURSOR,
	ISTATUS IN VARCHAR2
	) AS
	BEGIN
	OPEN DETAILS FOR 
	SELECT * FROM PRODUCT WHERE STATUS=ISTATUS;
	END;
	/

COMMIT;

CREATE OR REPLACE FUNCTION FUNC_GET_PRODUCT_BY_ID
	(
	IPID IN NUMBER,
	OSTATUS OUT VARCHAR2,
	OQTY OUT NUMBER
	) RETURN VARCHAR2  AS
	ONAME VARCHAR2(45);
	BEGIN
	SELECT PRODNAME,STATUS,QTY INTO ONAME,OSTATUS,OQTY FROM PRODUCT WHERE PID=IPID;
	RETURN ONAME;
	END;
	/
	 
COMMIT;

*/