package com.tushar.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
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
	 
	@NonNull	
	private Set<Phones> phones;
	
	public StudentInfo() {
	}

	@Override
	public String toString() {
		return "StudentInfo [SID=" + SID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + "]";
	}

}