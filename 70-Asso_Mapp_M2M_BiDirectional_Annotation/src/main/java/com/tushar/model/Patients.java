package com.tushar.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
@Entity
@Table(name = "ANNO_MTM_PATIENTS")
public class Patients  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SRID; 
	
	@NonNull	
	private int PID; 
	@NonNull	
	private String name;
	@NonNull	
	private String disease;
	@NonNull	
	private LocalDate visitdate;
	
	@ManyToMany(targetEntity = Doctor.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
	private Set<Doctor> doctor;

	@Override
	public String toString() {
		return "Patients [PID=" + PID + ", name=" + name + ", disease=" + disease + ", visitdate=" + visitdate + "]";
	}	
	
}
