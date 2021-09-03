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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TPCCA_Employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
