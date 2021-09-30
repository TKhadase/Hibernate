package com.tushar.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
@Table(name = "ANNO_OTO_LIBRARY_LOCK")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Library {

	@Id
	@GenericGenerator(name = "FOREIGN_GEN", strategy = "foreign", parameters = @Parameter(name="property", value = "student"))
	@GeneratedValue(generator = "FOREIGN_GEN")
	private int MID;
	@NonNull
	private String type;
	@NonNull
	private String status;
	@NonNull
	private Date doj;

	@OneToOne(targetEntity =StudentInfo.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "library")
	private StudentInfo student;

	@Override
	public String toString() {
		return "Library [MID=" + MID + ", type=" + type + ", status=" + status + ", doj=" + doj + "]";
	}

}
