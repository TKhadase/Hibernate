package com.tushar.entity;


public final class Product implements iProd{

	private Integer PID;
	private String prodname;
	private Double price;
	private String status;
	private Integer qty;
	
	public Integer getPID() {
		return PID;
	}

	public void setPID(Integer pID) {
		PID = pID;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [PID=" + PID + ", prodname=" + prodname + ", price=" + price + ", status=" + status + ", qty="
				+ qty + "]";
	}
	
	
	//create table product(PID number(10,0) not null enable, PNAME varchar2(30), PRICE FLOAT(126), QTY FLOAT(126), STATUS varchar2(10), CONSTRAINT "PROD_PK" PRIMARY KEY("PID"));
	
}
