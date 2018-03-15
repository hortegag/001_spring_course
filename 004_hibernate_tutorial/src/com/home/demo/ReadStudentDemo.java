package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Josue", "Ortega", "josue@gmail.com");
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(student);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			
			// find out the student's id: primary key
			System.out.print("Saved student. Generated id:"+student.getId());
			
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting the student" + student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nGetting complete" + student.toString());

			
			System.out.println("Done!");
			
		} catch (Exception e) {
			
		} finally {
			factory.close();
		}
		

	}

}
