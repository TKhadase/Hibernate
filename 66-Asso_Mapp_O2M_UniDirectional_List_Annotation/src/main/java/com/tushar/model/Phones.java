package com.tushar.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ANNO_OTM_UNI_PHONES")
public class Phones {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PID; 
	
	@NonNull	
	private String provider;
	@NonNull	
	private String num;
	@NonNull	
	private String phoneType;
	
	@Override
	public String toString() {
		return "Phones [PID=" + PID + ", provider=" + provider + ", num=" + num + ", phoneType=" + phoneType + "]";
	}
	
	
	
}
