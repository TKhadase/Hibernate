package com.tushar.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tushar.model.Person;
import com.tushar.utility.HBConnection_improved;

public class PersonDaoImpl implements IPersonDao {

	@Override
	public int  save() {
		int id=0;
		Scanner sc =null;
		Transaction tx = null;
		byte[] photo = null;
		char[] resume = null;

		try (Session ses = HBConnection_improved.getSession();)
			{
					sc =new Scanner(System.in);
					System.out.println("Please enter image path:");
					String image_path =sc.next();
					System.out.println("Please enter resume path:");
					String txtFile_path =sc.next();
			
			//get Photo into byte byte array
			File imagefile = new File("/"+image_path);
			FileInputStream fis = new FileInputStream(imagefile);
			photo = new byte[fis.available()];
			fis.read(photo);
			
			//get resume into byte char array
			File txtFile = new File("/"+txtFile_path);
			/*	System.out.println(""+txtFile.getAbsolutePath());
				System.out.println(""+txtFile.canRead());
				System.out.println(""+txtFile.canExecute());
				System.out.println(""+txtFile.canWrite());*/
			resume = new char[(int) txtFile.length()];
			FileReader reader = new FileReader(txtFile);
			reader.read(resume);
			
			//Create object with data
			Person person = new Person("Tushar", "Khadse", "YTL");
			person.setPhoto(photo);
			person.setResume(resume);
			
			tx =ses.beginTransaction();
			 id = (int)ses.save(person);
			tx.commit();
			System.out.println("person details saved!");
			
		} catch (Exception e) {
			System.out.println("Error saving data");
			e.printStackTrace();
			if (tx != null || tx.getRollbackOnly() || tx.getStatus() != null) {
				tx.rollback();
			}
		}
		return id;

	}

	@Override
	public void getInfo(int id) {
		
		byte[] photo = null;
		char[] resume = null;
		try(	Session ses = HBConnection_improved.getSession();){
			Person person =ses.get(Person.class, id);
			
			if(person!=null) {
				System.out.println(id+"-Record  found::"+person);
				
				FileOutputStream fos =new FileOutputStream("image.jpg");
				fos.write(person.getPhoto());
				FileWriter writer = new FileWriter("resume.txt");
				char[] resumeChars =person.getResume();
				writer.write(resumeChars);
				System.out.println("LOB saved locally");
				
			}else {
				System.out.println(id+"-Record not found");
			}
			
		} catch (Exception e) {
			System.out.println("Error retriving data");
			e.printStackTrace();
			}
		}

	@Override
	public void  saveRecordtoRecord(int id) {
		Transaction tx = null;
		byte[] photo = null;
		char[] resume = null;
		try(	Session ses = HBConnection_improved.getSession();){
			Person person =ses.get(Person.class, id);
			
			if(person!=null) {
				System.out.println(id+"-Record  found::"+person);
				Person p2 = new Person(person.getFname(), person.getLname(), person.getAddrs());
				p2.setPhoto(person.getPhoto());
				p2.setResume(person.getResume());
				tx=ses.beginTransaction();
				int idNew =(int) ses.save(p2);
				tx.commit();
				System.out.println(idNew+"-Record  inserted::"+person);
				
			}else {
				System.out.println(id+"-Record not found");
			}
			
		} catch (Exception e) {
			System.out.println("Error saving data");
			e.printStackTrace();
			if (tx != null || tx.getRollbackOnly() || tx.getStatus() != null) {
				tx.rollback();
			}
		}//Exception
	}//saveRecordtoRecord

	
	}//class
