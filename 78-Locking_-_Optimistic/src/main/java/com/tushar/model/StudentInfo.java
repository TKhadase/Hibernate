package com.tushar.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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
@Table(name = "ANNO_OTO_STUDENT_LOCK")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
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
	
	@Version
	private int ver;
	
	@OneToOne(targetEntity =Library.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "MID", referencedColumnName = "SID")
	private Library library;
	
	public StudentInfo() {
	}

	@Override
	public String toString() {
		return "StudentInfo [SID=" + SID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + ", ver=" + ver
				+ ", library=" + library + "]";
	}

}