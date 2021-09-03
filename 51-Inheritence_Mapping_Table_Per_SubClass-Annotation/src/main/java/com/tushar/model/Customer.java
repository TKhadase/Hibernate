package com.tushar.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="TPSCA_Customer")
@DiscriminatorValue(value = "CUST")
@PrimaryKeyJoinColumn(name = "PID",referencedColumnName = "PID")
@Entity
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
