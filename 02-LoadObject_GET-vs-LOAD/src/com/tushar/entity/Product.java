package com.tushar.entity;

import lombok.Data;

@Data
public class Product {

	private Integer PID;
	private String prodname;
	private Double price;
	private String status;
	private Integer qty;
	
	//create table product(PID number(10,0) not null enable, PNAME varchar2(30), PRICE FLOAT(126), QTY FLOAT(126), STATUS varchar2(10), CONSTRAINT "PROD_PK" PRIMARY KEY("PID"));
	
}
