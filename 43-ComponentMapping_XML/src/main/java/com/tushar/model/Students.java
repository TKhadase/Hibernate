package com.tushar.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public final class Students implements Serializable {
	
	private int SID; 
	@NonNull
	private String fname;
	@NonNull
	private String lname;
	@NonNull
	private String addrs;
	@NonNull
	private StudentsResult result;
	
	public Students() {
	}

	@Override
	public String toString() {
		return "Students [SID=" + SID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + "]";
	}

	
	
}