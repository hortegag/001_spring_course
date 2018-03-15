package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Student;

public class DeleteStudentDemo {

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
			int studentId = 2;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			
			System.out.println("\nStudent Id" + studentId);
			Student student = session.get(Student.class, studentId);
			
			System.out.println("deleting student...");
			
			session.delete(student);

			
			session.createQuery("delete from Student where id=4").executeUpdate();
					
			
			System.out.println("Done updating all students");
			
			session.getTransaction().commit();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
		

	}

}
