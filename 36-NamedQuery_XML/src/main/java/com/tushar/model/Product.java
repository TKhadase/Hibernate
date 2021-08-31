package com.tushar.model;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.NamedNativeQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public  class Product  {
	
	private int PID; 
	
	//private String PID;  
	@NonNull
	private String prodname;
	@NonNull
	private Double price;
	@NonNull
	private String status;
	@NonNull
	private Integer qty;
	
	public Product() {
		System.out.println("Product ::"+this.hashCode());
	}
}
/*
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
*/