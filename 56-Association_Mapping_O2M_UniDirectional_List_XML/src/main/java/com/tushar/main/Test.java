package com.tushar.main;

import com.tushar.dao.IStudentDao;
import com.tushar.dao.StudentDaoImpl;

public class Test {

	public static void main(String[] args) {
		IStudentDao dao = new StudentDaoImpl();
		
		dao.saveStudentInfo();
		dao.saveStudentInfo();
		dao.saveStudentInfo();
		dao.getStudentInfo();
		
		dao.removeStudentAndPhoneInfo(1);
		dao.getStudentInfo();
		
		dao.removePhoneInfo(2);
		dao.getStudentInfo();
		
		dao.removeSpecificPhoneInfo(3,6);
		dao.getStudentInfo();
		
		dao.addSpecificPhoneInfo(3);
		dao.getStudentInfo();
		
	}//main

}//class