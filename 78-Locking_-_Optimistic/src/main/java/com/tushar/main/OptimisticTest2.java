package com.tushar.main;

import com.tushar.dao.IStudentDao;
import com.tushar.dao.StudentDaoImpl;

public class OptimisticTest2 {

	public static void main(String[] args) {
		IStudentDao dao = new StudentDaoImpl();
		System.out.println("OptimisticTest2.main()");
		dao.updateStudentInfo1();
		
	}//main

}//class