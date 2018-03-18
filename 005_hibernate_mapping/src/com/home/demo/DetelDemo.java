package com.home.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;

public class DetelDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		// 
		try {
			// use the session object to save Java object
			System.out.println("Creating a new Student objec");
			
			
					
			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("instrcutor" +instructor);
			
			if (instructor != null){
				System.out.println("Deletin instructor"+instructor);
				
				// will also delete the associate detail object because of the CascadeType.ALL
				session.delete(instructor);
			}
			
			
			
			
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
