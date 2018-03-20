package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.home.entity.Course;
import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;

public class FetchJoinDemo {

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
			//option 2: using HQL
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+"where i.id = :instructorId",
					Instructor.class);
			
			
			// set parameter on query
			
			query.setParameter("instructorId", id);
			
			//execute query and get instructor
			Instructor theInstructor = query.getSingleResult();
			
			System.out.println("Print the Instructor: "+theInstructor);

			// commmit transaction
			session.getTransaction().commit();
			
			System.out.println("Closing the session");
			session.close();
			
			// since the courses are lazy loaded ... should fail
			
			// option 1 call the getter while the session is open
			System.out.println("Print the courses: "+theInstructor.getCourses());

			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		

	}

}
