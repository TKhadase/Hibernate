package com.tushar.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public final class Student  {

	private Integer SID;
	private String sname;
	private Double marks;
	private String result;
	private Integer percent;
	private Integer updateCount;	
	private Timestamp dtLastUpdated;
	
}
