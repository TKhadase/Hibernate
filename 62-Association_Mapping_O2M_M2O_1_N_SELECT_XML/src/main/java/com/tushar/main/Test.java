package com.tushar.main;

import com.tushar.dao.IStudentDao;
import com.tushar.dao.StudentDaoImpl;

public class Test {

	public static void main(String[] args) {
		IStudentDao dao = new StudentDaoImpl();
		dao.getStudentInfo_1_N_problem();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		dao.getStudentInfo_1_N_Sol1_HBCriteria();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		dao.getStudentInfo_1_N_Sol2_JPACriteria();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		dao.getStudentInfo_1_N_Sol3_HQL_JOIN();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
	}//main

}//class