package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Course;
import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			// get the instructor from db
			int id = 1;
			
			Instructor theInstructor = session.get(Instructor.class, id);
			
			
			// create some courses
			Course courseOne = new Course("Guitar for beginner");
			Course courseTwo = new Course("Java for dummies");
			
			// add courses to instructor
			theInstructor.add(courseOne);
			theInstructor.add(courseTwo);
			
			// save the courses
			session.save(courseOne);
			session.save(courseTwo);
			
			

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
