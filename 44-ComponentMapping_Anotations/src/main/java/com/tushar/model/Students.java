package com.tushar.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public final class Students implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SID; 
	@NonNull
	private String fname;
	@NonNull
	private String lname;
	@NonNull
	private String addrs;
	
	@NonNull
	@Embedded
	private StudentsResult result;
	
	public Students() {
	}

	@Override
	public String toString() {
		return "Students [SID=" + SID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + "]";
	}

	
	
}