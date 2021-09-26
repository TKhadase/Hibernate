package com.tushar.main;

import com.tushar.dao.*;
import com.tushar.utility.HBConnection_improved;

public class Test {

	public static void main(String[] args) {
		IPersonDao dao = new PersonDaoImpl();
		int id = dao.save();
		System.out.println("==============================================================");
		dao.getInfo(id);
		dao.saveRecordtoRecord(id);
		
		HBConnection_improved.closeSessionFactory();
	}// main

}// class