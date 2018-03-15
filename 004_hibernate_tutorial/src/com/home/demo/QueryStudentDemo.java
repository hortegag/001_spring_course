package com.home.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Student;

public class QueryStudentDemo {

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
			
			session.getTransaction().begin();
			// query students
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
	
			// display the students
			displayStudents(theStudents);
			
			
			//query students: lastName='Ortega'
			theStudents = session.createQuery("from Student s where s.lastName='Ortega'").getResultList();
			
			System.out.println("\nLast Name Ortega");
			displayStudents(theStudents);

			
			
			//query students: lastName='Ortega'
			theStudents = session.createQuery("from Student s where s.lastName='Ortega' OR s.firstName='Juan'").getResultList();
			
			System.out.println("\nLast Name Ortega or FirstName Juan");
			displayStudents(theStudents);
			
			
			//query students: lastName='Ortega'
			theStudents = session.createQuery("from Student s where s.email LIKE 'j%'").getResultList();
			
			System.out.println("\nEmail like j%");
			displayStudents(theStudents);
			
			// commit transaction
		
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents){
			
			System.out.println(student);
		}
	}

}
