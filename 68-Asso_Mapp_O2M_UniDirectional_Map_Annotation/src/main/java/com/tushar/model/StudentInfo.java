package com.tushar.model;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "MAP_ANNO_OTM_UNI_STUDENT")
public  class StudentInfo implements Serializable {
	
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
	@OneToMany(targetEntity =Phones.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true )
	@JoinColumn(name ="STUDENT_ID",referencedColumnName = "SID" )
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.JOIN)
	@MapKeyColumn(name = "CUST_ACC_SEQ")
	private Map<String, Phones> phones;
	
	public StudentInfo() {
	}

	@Override
	public String toString() {
		return "StudentInfo [SID=" + SID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + "]";
	}

}