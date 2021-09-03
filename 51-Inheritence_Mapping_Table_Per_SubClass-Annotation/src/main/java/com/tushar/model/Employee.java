package com.tushar.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="TPSCA_Employee")
@DiscriminatorValue(value = "EMP")
@PrimaryKeyJoinColumn(name = "PID",referencedColumnName = "PID")
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
