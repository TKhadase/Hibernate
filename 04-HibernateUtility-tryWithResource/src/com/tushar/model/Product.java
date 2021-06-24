package com.tushar.model;

import lombok.Data;

@Data
public final class Product  {

	private Integer PID;
	private String prodname;
	private Double price;
	private String status;
	private Integer qty;
	
	//ORACLE
	//create table product(PID number(10,0) not null enable, PNAME varchar2(30), PRICE FLOAT(126), QTY FLOAT(126), STATUS varchar2(10), CONSTRAINT "PROD_PK" PRIMARY KEY("PID"));
	
	//MYSQL
	//create table product(PID INTEGER UNIQUE, PNAME varchar(30), PRICE varchar(16), QTY varchar(16), STATUS varchar(10));
	
}
