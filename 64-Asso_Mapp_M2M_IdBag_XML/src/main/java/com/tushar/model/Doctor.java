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
public  class Doctor implements Serializable {
	
	private int DID; 
	@NonNull	
	private String name;
	@NonNull	
	private int experience;
	@NonNull	
	private String specialist;
	 
	private Set<Patients> patients;
	
	public Doctor() {
	}

	@Override
	public String toString() {
		return "Doctor [DID=" + DID + ", name=" + name + ", experience=" + experience + ", specialist=" + specialist
				+ "]";
	}

}