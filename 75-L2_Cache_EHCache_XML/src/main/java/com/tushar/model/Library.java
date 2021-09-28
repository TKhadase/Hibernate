package com.tushar.model;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Library {

	private int MID;
	@NonNull
	private String type;
	@NonNull
	private String status;
	@NonNull
	private Date doj;

	private StudentInfo student;

	@Override
	public String toString() {
		return "Library [MID=" + MID + ", type=" + type + ", status=" + status + ", doj=" + doj + "]";
	}

}
