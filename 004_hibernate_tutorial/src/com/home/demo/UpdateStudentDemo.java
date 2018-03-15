package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Student;

public class UpdateStudentDemo {

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
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			
			System.out.println("\nStudent Id" + studentId);
			Student student = session.get(Student.class, studentId);
			
			System.out.println("updating student...");
			
			System.out.println("Changing name");
			student.setFirstName("Nartuop");
			
			// commit the transaction
			session.getTransaction().commit();
						
			System.out.println("Done!");
			
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
					
			
			System.out.println("Done updating all students");
			
			session.getTransaction().commit();
			
			
			
			
		} catch (Exception e) {
			
		} finally {
			factory.close();
		}
		

	}

}
