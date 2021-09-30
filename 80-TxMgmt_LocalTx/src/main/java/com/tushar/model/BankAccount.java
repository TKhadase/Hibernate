package com.tushar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="BANK_ACCOUNT")
public final class BankAccount  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO  )
	private int AID; 
	
	//private String PID;  
	@NonNull
	private String aname;
	@NonNull
	private Double balance;
	@NonNull
	private String status;

	public BankAccount(){
		
	}
	
	@Override
	public String toString() {
		return "BankAccount [AID=" + AID + ", aname=" + aname + ", balance=" + balance + ", status=" + status + "]";
	}

	
	
	
}