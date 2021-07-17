package com.tushar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class EmployeeDetails  {

	private EmployeeID eid;  // HAS-A property
	private String ename;
	private Double salary;
	private String desg;
	private Integer level;
	
}
