package com.tushar.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ANNO_OTO_FK_PERSON")
public  class Person implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PID; 
	@NonNull	
	private String fname;
	@NonNull	
	private String lname;
	@NonNull	
	private String addrs;
	
	public Person() {
	}

	@Override
	public String toString() {
		return "Person [PID=" + PID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + "]";
	}

}