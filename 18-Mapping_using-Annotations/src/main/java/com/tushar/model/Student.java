package com.tushar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import lombok.Data;

@Entity					                   //makes given  class as entity class
@Table                                    //if entity class name matching, else if not matching  @Table(name="students")
@DynamicInsert(true)     //allows dynamic insertion
@DynamicUpdate(true)  //allows dynamic updation
@Proxy(lazy=true, proxyClass = iStudent.class)   //allows to work with lazy loading + proxy interface
@Data
public final  class Student implements iStudent {
	
	@Id   //makes variable as singular id field column as primary key column
	@Column   //if column name not matching variable name, then specify explicitely as	@Column(name="sid")
	private Integer SID;
	
	@Column
	private String sname;
	
	@Column
	private Double marks;
	
	@Column(name="result", length = 4)
	private String result;
	
	@Column
	private Integer percent;
	
	@Transient  //ignores given variable participating in every persistance operation
	private String remarks;
	
}
