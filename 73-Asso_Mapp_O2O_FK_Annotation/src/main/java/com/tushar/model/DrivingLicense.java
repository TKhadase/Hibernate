package com.tushar.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Entity
@Table(name = "ANNO_OTO_FK_DRIVINGLICENSE")
public class DrivingLicense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int LID;
	
	@NonNull
	private String type;
	@NonNull
	private String status;
	@NonNull
	private Date issuedt;
	@NonNull
	private Date expdt;

	@NonNull
	@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Person person;

	public DrivingLicense() {
	}

	@Override
	public String toString() {
		return "DrivingLicense [LID=" + LID + ", type=" + type + ", status=" + status + ", issuedt=" + issuedt
				+ ", expdt=" + expdt + "]";
	}


}
