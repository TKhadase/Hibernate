package com.tushar.model;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public  class StudentInfo implements Serializable {
	
	private int SID; 
	@NonNull	
	private String fname;
	@NonNull	
	private String lname;
	@NonNull	
	private String addrs;
	 
	private Library library;
	
	public StudentInfo() {
	}

	@Override
	public String toString() {
		return "StudentInfo [SID=" + SID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + "]";
	}

}