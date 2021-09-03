package com.tushar.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "EMP")
@Entity
public class Employee extends Person {

	private String company;
	private String desg;
	private double salary;
	private double experience;
	
	@Override
	public String toString() {
		return "Employee [company=" + company + ", desg=" + desg + ", salary=" + salary + ", experience=" + experience
				+ " ,   PID=" + getPID() + ", fname="	+ getFname() + ", lname=" + getLname() + ", addrs=" + getAddrs() + "]";
	}
	
}
