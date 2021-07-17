package com.tushar.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeID  implements Serializable{
	
	private Integer id;
	private String projectName;
	
	
}
