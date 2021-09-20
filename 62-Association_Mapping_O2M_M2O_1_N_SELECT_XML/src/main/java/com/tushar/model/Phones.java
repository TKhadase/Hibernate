package com.tushar.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Phones {

	private int PID; 
	@NonNull	
	private String provider;
	@NonNull	
	private String num;
	@NonNull	
	private String phoneType;
	
	private StudentInfo student;
	
	@Override
	public String toString() {
		return "Phones [PID=" + PID + ", provider=" + provider + ", num=" + num + ", phoneType=" + phoneType + "]";
	}
	
	
	
}
