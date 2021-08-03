package com.tushar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
//@Table(name="UID_PRODUCT_TEST")
public final class Product  {

	/*@Id
	@GenericGenerator(name = "PID_PRODUCT_Generator", strategy = "increment")
	@GeneratedValue(generator = "PID_PRODUCT_Generator" )
	private int PID;*/
	
	/*
	@Id
	@GenericGenerator(name = "PID_PRODUCT_Generator", strategy = "identity")
	@GeneratedValue(generator = "PID_PRODUCT_Generator" )
	private int PID;*/
	
	/*@Id
	@GenericGenerator(name = "PID_PRODUCT_Generator", strategy = "sequence",parameters = @Parameter(name="sequence_name", value = "PROD_ID_SEQ"))
	@GeneratedValue(generator = "PID_PRODUCT_Generator" )
	private int PID;*/
	
	/*@Id
		@GenericGenerator(name = "PID_PRODUCT_Generator", 
												strategy = "hilo",//runs upto Hibernate 4.x 
												parameters = {
														@Parameter(name="table", value = "PROD_ID_HILO"),
														@Parameter(name="column", value = "HI_VAL"),
														@Parameter(name="max_lo", value = "2"),
												})
		@GeneratedValue(generator = "PID_PRODUCT_Generator" )
		private int PID;*/
	
	/*@Id
	@GenericGenerator(name = "PID_PRODUCT_Generator", 
											strategy = "seqhilo",//not working properly in Annotation driven environment
											parameters = {
													@Parameter(name="sequence", value = "PROD_ID_SEQHILO"),
													@Parameter(name="max_lo", value = "2"),
											})
	@GeneratedValue(generator = "PID_PRODUCT_Generator" )
	private int PID;*/
	
	/*@Id
	@GenericGenerator(name = "PID_PRODUCT_Generator", 
											strategy = "native")
	@GeneratedValue(generator = "PID_PRODUCT_Generator" )
	private int PID;*/
	
	
	/*	@Id
		@GenericGenerator(name = "PID_PRODUCT_Generator", 
												strategy = "uuid")
		@GeneratedValue(generator = "PID_PRODUCT_Generator" )
		private String PID;  //use Table  "UID_PRODUCT_TEST" for UUID, GUID generator test & for custom generator
	*/	
	
	/*@Id
	@GenericGenerator(name = "PID_PRODUCT_Generator", 
											strategy ="guid")
	@GeneratedValue(generator = "PID_PRODUCT_Generator" )
	private String PID;  //use Table  "UID_PRODUCT_TEST" for UUID, GUID generator test & for custom generator
	*/	
	
	/*create or replace trigger PROD_ID_TRGR
	BEFORE INSERT ON PRODUCT FOR EACH ROW
	DECLARE
	prod_no number(4);
	BEGIN
	SELECT PROD_ID_SEQ.NEXTVAL INTO prod_no FROM DUAL;
	:new.PID := prod_no;
	END;
	/
	@Id
	@GenericGenerator(name = "PID_PRODUCT_Generator", 
											strategy ="select",parameters = @Parameter(name="key", value = "prodname"))
	@GeneratedValue(generator = "PID_PRODUCT_Generator" )
	private int PID;  */
	
	@Id
	@GenericGenerator(name = "PID_PRODUCT_Generator", 
											strategy ="com.tushar.generators.CustomGenerator")
	@GeneratedValue(generator = "PID_PRODUCT_Generator" )
	private String PID;  
	
	@NonNull
	private String prodname;
	@NonNull
	private Double price;
	@NonNull
	private String status;
	@NonNull
	private Integer qty;
	
}
