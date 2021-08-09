package com.tushar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
public final class PROD_BKP  {
	@Id
	private Integer PID; 
	@NonNull
	private String prodname;
	@NonNull
	private Double price;
	@NonNull
	private String status;
	@NonNull
	private Integer qty;
	
	public PROD_BKP() {
		System.out.println("PROD_BKP ::"+this.hashCode());
	}

	
}