package com.tushar.main;

import com.tushar.dao.IStudentDao;
import com.tushar.dao.StudentDaoImpl;

public class PessimisticTest2 {

	public static void main(String[] args) {
		IStudentDao dao = new StudentDaoImpl();
		dao.updateStudentInfo1();
		
	}//main

}//class