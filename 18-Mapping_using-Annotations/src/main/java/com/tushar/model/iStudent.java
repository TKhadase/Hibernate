package com.tushar.model;

import java.io.Serializable;

public interface iStudent extends Serializable {

	public Integer getSID() ;
	public void setSID(Integer sID);
	public String getSname();
	public void setSname(String sname);
	public Double getMarks();
	public void setMarks(Double marks);
	public String getResult();
	public void setResult(String result);
	public Integer getPercent();
	public void setPercent(Integer percent);
	public String getRemarks() ;
	public void setRemarks(String remarks);

}
