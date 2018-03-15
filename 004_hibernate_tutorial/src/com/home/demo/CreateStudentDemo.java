package com.home.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		// 
		try {
			// use the session object to save Java object
			System.out.println("Creating a new Student objec");
			
			// create a student object
            String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
            
            Student student = new Student("Paully", "Doe", "paul@luv.com", theDateOfBirth);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(student);
			
			
			// commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("Done!");
			
		} catch (Exception e) {
			
		} finally {
			factory.close();
		}
		

	}

}
