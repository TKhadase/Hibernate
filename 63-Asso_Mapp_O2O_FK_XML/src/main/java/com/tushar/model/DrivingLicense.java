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
public class DrivingLicense {

	private int LID;
	@NonNull
	private String type;
	@NonNull
	private String status;
	@NonNull
	private Date issuedt;
	@NonNull
	private Date expdt;

	@NonNull
	private Person person;

	public DrivingLicense() {
	}

	@Override
	public String toString() {
		return "DrivingLicense [LID=" + LID + ", type=" + type + ", status=" + status + ", issuedt=" + issuedt
				+ ", expdt=" + expdt + "]";
	}


}
