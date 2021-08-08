package com.tushar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@RequiredArgsConstructor
//@Table(name="UID_PRODUCT_TEST")
public final class Product  {
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY  )
		private int PID;  */
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE  )
		private int PID;  */
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.TABLE  )
	private int PID;    */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO  )
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
