package com.tushar.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ANNO_MTM_DOCTORS")
public  class Doctor implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int DID; 
	
	@NonNull	
	private String name;
	@NonNull	
	private int experience;
	@NonNull	
	private String specialist;
	 
	@ManyToMany(targetEntity = Patients.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ANNO_MTM_DCTR_PAT",
							joinColumns = @JoinColumn(name="DOCTOR_ID", referencedColumnName = "DID"),
							inverseJoinColumns =  @JoinColumn(name="PATIENT_ID", referencedColumnName = "SRID") )
	private Set<Patients> patients;
	
	public Doctor() {
	}

	@Override
	public String toString() {
		return "Doctor [DID=" + DID + ", name=" + name + ", experience=" + experience + ", specialist=" + specialist
				+ "]";
	}

}