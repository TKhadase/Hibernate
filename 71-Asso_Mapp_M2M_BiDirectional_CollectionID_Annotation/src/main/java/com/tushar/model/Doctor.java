package com.tushar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
@Table(name = "IDBAG_ANNO_MTM_DOCTORS")
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
	@JoinTable(name = "IDBAG_ANNO_MTM_DCTR_PAT",
							joinColumns = @JoinColumn(name="DOCTOR_ID", referencedColumnName = "DID"),
							inverseJoinColumns =  @JoinColumn(name="PATIENT_ID", referencedColumnName = "SRID") )
	@GenericGenerator(name= "IDVAL_GEN1",strategy = "increment" )
	@CollectionId(columns = @Column(name = "DR_PAT_ID",nullable = true),
								type = @Type(type = "integer"),
								generator = "IDVAL_GEN1")
	private List<Patients> patients;
	
	public Doctor() {
	}

	@Override
	public String toString() {
		return "Doctor [DID=" + DID + ", name=" + name + ", experience=" + experience + ", specialist=" + specialist
				+ "]";
	}

}