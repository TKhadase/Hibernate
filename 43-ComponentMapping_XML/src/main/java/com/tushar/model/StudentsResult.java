package com.tushar.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsResult  implements Serializable {

	@NonNull
	private String status;
	@NonNull
	private String remarks;
	
	@Override
	public String toString() {
		return "StudentsResult [status=" + status + ", remarks=" + remarks + "]";
	}
	
	
	
}
