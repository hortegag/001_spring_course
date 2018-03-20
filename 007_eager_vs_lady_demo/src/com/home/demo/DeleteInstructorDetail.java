package com.home.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;

public class DeleteInstructorDetail {

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
			
			// get the instructor detail object
			int idDetail = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, idDetail);
			
			// print the instructor detail
			System.out.println("instructorDetail"+instructorDetail);
			
			
			// print the associated instructor
			System.out.println("the associated instructor "+instructorDetail.getInstructor());
			
			// remove the object reference
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			// delete de instructor detail
			System.out.println("Deleting tempInstructor detail");
			session.delete(instructorDetail);
			
			

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			session.close();
			
			factory.close();
		}
		

	}

}
