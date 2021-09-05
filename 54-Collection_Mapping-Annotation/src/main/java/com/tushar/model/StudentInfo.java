package com.tushar.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "COLL_MAP_A_STUDENTINFO")
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
	@ElementCollection
	@JoinTable(name = "COLL_MAP_A_FNAME")//child table
	@JoinColumn(name = "STUDENT_ID", referencedColumnName = "SID")//FK
	@OrderColumn(name = "FRND_INDEX")//index column
	@ListIndexBase(value = 1)//base index value
	@Column(name = "FRND")
	private List<String> frnds;
	
	@ElementCollection
	@JoinTable(name = "COLL_MAP_A_CITY")//child table
	@JoinColumn(name = "STUDENT_ID", referencedColumnName = "SID")//FK
	@Column(name = "CITY")
	private List<String> cities;
	
	@NonNull	
	@ElementCollection
	@JoinTable(name = "COLL_MAP_A_PHONE")//child table
	@JoinColumn(name = "STUDENT_ID", referencedColumnName = "SID")//FK
	@Column(name = "PHONE")
	private Set<String> phones;
	
	@NonNull	
	@ElementCollection
	@JoinTable(name = "COLL_MAP_A_IDS")//child table
	@JoinColumn(name = "STUDENT_ID", referencedColumnName = "SID")//FK
	@MapKeyColumn(name ="SID_NAME" ,length = 20)
	@Column(name = "SID_NO")
	private Map<String, String> idDetails;
	
	public StudentInfo() {
	}

	@Override
	public String toString() {
		return "StudentInfo [SID=" + SID + ", fname=" + fname + ", lname=" + lname + ", addrs=" + addrs + ", frnds="
				+ frnds + ", cities=" + cities + ", phones=" + phones + ", idDetails=" + idDetails + "]";
	}

}