package com.tushar.main;

import com.tushar.dao.ILicenseDao;
import com.tushar.dao.LicensDaoImpl;

public class Test {

	public static void main(String[] args) {
		ILicenseDao dao = new LicensDaoImpl();
		dao.save_child_to_Parent();
		System.out.println("==============================================================");
		dao.getInfo();
		
	}//main

}//class