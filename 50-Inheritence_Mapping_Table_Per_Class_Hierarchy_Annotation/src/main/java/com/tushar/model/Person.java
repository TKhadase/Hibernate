package com.tushar.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PER_TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "PER")
@Table(name = "TPCHA_PERSON")
public  class Person implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PID; 
	private String fname;
	private String lname;
	private String addrs;
	
	public Person() {
	}
	
	
	@Override
	public String toString() {
		return "Person [PID=" + PID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + "]";
	}


	public Person(String fname, String lname, String addrs) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.addrs = addrs;
	}

}