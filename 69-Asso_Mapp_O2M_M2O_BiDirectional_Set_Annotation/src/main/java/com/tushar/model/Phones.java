package com.tushar.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

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
@Table(name="ANNO_OTM_MTO_PHONES")
public class Phones {

	@Id
	@SequenceGenerator(name = "PER_SEQ_GEN", sequenceName = "PERSON_SEQ_GEN",initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator="PER_SEQ_GEN", strategy =GenerationType.SEQUENCE )	
	private int PID; 
	
	@NonNull	
	private String provider;
	@NonNull	
	private String num;
	@NonNull	
	private String phoneType;
	
	@ManyToOne(targetEntity =StudentInfo.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER )
	@JoinColumn(name = "STUD_ID", referencedColumnName = "SID")
	@LazyToOne(LazyToOneOption.PROXY)
	private StudentInfo student;
	
	@Override
	public String toString() {
		return "Phones [PID=" + PID + ", provider=" + provider + ", num=" + num + ", phoneType=" + phoneType + "]";
	}
	
	
	
}
