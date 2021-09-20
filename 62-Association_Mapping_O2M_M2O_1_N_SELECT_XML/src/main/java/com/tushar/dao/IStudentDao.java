package com.tushar.dao;

public interface IStudentDao {

	public void saveStudentInfo();
	public void getStudentInfo_1_N_problem();
	public void addPhoneInfoForStudent();
	public void removeStudentAndPhoneInfo(int sid);
	public void removePhoneInfo(int sid);
	public void removeSpecificPhoneInfo(int sid, int pid);
	public void addSpecificPhoneInfo(int sid);
	
	
	public void getStudentInfo_1_N_Sol1_HBCriteria();
	
	public void getStudentInfo_1_N_Sol2_JPACriteria();
	
	public void getStudentInfo_1_N_Sol3_HQL_JOIN();
	
	
}

