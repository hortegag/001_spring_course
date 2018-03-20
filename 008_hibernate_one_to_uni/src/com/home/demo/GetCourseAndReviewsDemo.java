package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Course;
import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;
import com.home.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		// 
		try {

			// start a transaction
			session.beginTransaction();
			
			
			// get the course
			int id = 10;
			Course course = session.get(Course.class, id);
			
			// print the course
			System.out.println("Course: "+course);
			
			// print the reviews
			System.out.println(course.getReviews());
		

			// commmit transaction
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
