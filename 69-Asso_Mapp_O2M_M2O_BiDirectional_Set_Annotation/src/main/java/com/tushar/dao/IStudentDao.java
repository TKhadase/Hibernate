package com.tushar.dao;

public interface IStudentDao {

	public void saveStudentInfo();
	public void getStudentInfo();
	public void addPhoneInfoForStudent();
	public void removeStudentAndPhoneInfo(int sid);
	public void removePhoneInfo(int sid);
	public void removeSpecificPhoneInfo(int sid, int pid);
	public void addSpecificPhoneInfo(int sid);
	
}

