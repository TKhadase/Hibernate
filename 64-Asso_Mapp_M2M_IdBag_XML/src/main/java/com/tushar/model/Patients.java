package com.tushar.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
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
public class Patients  implements Serializable{
	
	private int SRID; 
	@NonNull	
	private int PID; 
	@NonNull	
	private String name;
	@NonNull	
	private String disease;
	@NonNull	
	private LocalDate visitdate;
	
	private List<Doctor> doctor;

	@Override
	public String toString() {
		return "Patients [PID=" + PID + ", name=" + name + ", disease=" + disease + ", visitdate=" + visitdate + "]";
	}	
	
}
