package com.tushar.model;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public final class EmployeeDetails  {

	@EmbeddedId
	private EmployeeID eid;  // HAS-A property
	@Column
	private String ename;
	@Column
	private Double salary;
	@Column
	private String desg;
	@Column
	private Integer level;
	
}
