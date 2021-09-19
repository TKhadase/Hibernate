package com.tushar.main;

import com.tushar.dao.*;
import com.tushar.utility.HBConnection_improved;

public class Test {

	public static void main(String[] args) {
		IHospitalDao dao =  new HospitalDaoImpl();
		dao.saveDoctorPatientDetails();
		dao.getDoctorPatientDetails();
		System.out.println("------------------------------------------------------------------------------------------------" );
		dao.savePatientDoctorDetails();
		dao.getDoctorPatientDetails();
		
		HBConnection_improved.closeSessionFactory();
		
	}//main

}//class