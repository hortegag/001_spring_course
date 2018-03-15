package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Student;

public class PrimaryKeyDemo {
	
	
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
			System.out.println("Creating a 3 Student objec");
			
			
			
			
			
			// create a student object
			Student student1 = new Student("Hector", "Ortega", "test@gmail.com");
			Student student2 = new Student("Carla", "Salvatierra", "csalvagua@gmail.com");
			Student student3 = new Student("Juan", "Pablo", "jpablo@gmail.com");
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch (Exception e) {
			
		} finally {
			factory.close();
		}
		

	}

}
