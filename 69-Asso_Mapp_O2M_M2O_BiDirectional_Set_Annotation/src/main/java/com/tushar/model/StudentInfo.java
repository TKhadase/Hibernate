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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
@Table(name="ANNO_OTM_MTO_STUDENT")
public  class StudentInfo implements Serializable {
	
	@Id
	@GenericGenerator(name = "STU_GEN", strategy = "increment")
	@GeneratedValue(generator="STU_GEN" )	
	private int SID; 
	
	@NonNull	
	private String fname;
	@NonNull	
	private String lname;
	@NonNull	
	private String addrs;
	 
	@OneToMany(targetEntity = Phones.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name = "STUD_ID", referencedColumnName = "SID")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.JOIN)
	private Set<Phones> phones;
	
	public StudentInfo() {
	}

	@Override
	public String toString() {
		return "StudentInfo [SID=" + SID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + "]";
	}

}