package com.tushar.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public final class Student  {

	@Id
	private Integer SID;
	
	@Column
	private String sname;
	@Column
	private Double marks;
	@Column
	private String result;
	@Column
	private Integer percent;
	@Version
	private Integer updateCount;
	@UpdateTimestamp
	private Timestamp dtLastUpdated;
	@CreationTimestamp
	private Timestamp dtCreated;	
	
}
