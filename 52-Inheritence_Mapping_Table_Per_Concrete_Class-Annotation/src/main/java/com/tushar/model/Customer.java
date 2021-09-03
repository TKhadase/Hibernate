package com.tushar.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TPCCA_Customer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Customer extends Person {
	
	private double billAmt;
	private String billDate;
	private String paymentType;
	private String billingLocation;
	
	@Override
	public String toString() {
		return "Customer [billAmt=" + billAmt + ", billDate=" + billDate + ", paymentType=" + paymentType + ", billingLocation="
				+ billingLocation + ",  PID=" + getPID() + ", fname="
				+ getFname() + ", lname=" + getLname() + ", addrs=" + getAddrs() + "]";
	}
	
}
