package com.tushar.main;

import com.tushar.dao.IStudentDao;
import com.tushar.dao.StudentDaoImpl;

public class OptimisticTest1 {

	public static void main(String[] args) {
		IStudentDao dao = new StudentDaoImpl();
		System.out.println("OptimisticTest1.main()");
		dao.updateStudentInfo();
		
	}//main

}//class