package com.tushar.main;

import com.tushar.dao.IStudentDao;
import com.tushar.dao.StudentDaoImpl;

public class Test {

	public static void main(String[] args) {
		IStudentDao dao = new StudentDaoImpl();
		
		dao.saveStudentInfo();
		dao.removeStudentAndPhoneInfo(2);
		dao.removePhoneInfo(3);
		dao.removeSpecificPhoneInfo(6,11);
		dao.addSpecificPhoneInfo(7);
		dao.getStudentInfo();
		
	}//main

}//class