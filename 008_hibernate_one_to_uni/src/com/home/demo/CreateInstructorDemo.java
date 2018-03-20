package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Course;
import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		// 
		try {
			// use the session object to save Java object
			System.out.println("Creating a new Student objec");
			
			// create the object
			
			Instructor instructor = new Instructor("Juan", "Pueblo", "jpueblo@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("react course", "play guitar");
			
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			Course course = new Course();
			
			
					
			// start a transaction
			session.beginTransaction();
			
			// save the object
			// this will also save the details object because of CascadeType.ALL
			System.out.println("Saving object instructor");
			session.save(instructor);
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			
		} finally {
			session.close();
			factory.close();
		}
		

	}

}
