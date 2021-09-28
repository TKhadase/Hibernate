package com.tushar.main;

import com.tushar.dao.IStudentDao;
import com.tushar.dao.StudentDaoImpl;
import com.tushar.utility.HBConnection_improved;

public class Test {

	public static void main(String[] args) {
		IStudentDao dao = new StudentDaoImpl();
		dao.getStudentInfo();
	}//main

}//class