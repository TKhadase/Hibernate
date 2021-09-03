package com.tushar.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public  class Person implements Serializable {
	
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