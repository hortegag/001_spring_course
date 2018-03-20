package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Course;
import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;

public class GetinstructorCoursesDemo {

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

					
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int id = 1;
			
			Instructor theInstructor = session.get(Instructor.class, id);

			// retrieve the courses from that instructor
			System.out.println("Print the courses: "+theInstructor.getCourses());
			

			

			// commmit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			
		} finally {
			session.close();
			factory.close();
		}
		

	}

}
