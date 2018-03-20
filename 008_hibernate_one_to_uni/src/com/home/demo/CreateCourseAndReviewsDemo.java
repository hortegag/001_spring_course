package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Course;
import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;
import com.home.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			
			//  create the Course
			Course course = new Course("Guitar how to play like a master");
			
			
			// add reviews
			course.addReview(new Review("Fantastic course I know how to play guararei"));
			course.addReview(new Review("Great I learn how to play november rain"));
			course.addReview(new Review("It the worst course to take"));
			
			
			//save course and review due to cascade type
			session.save(course);
			
			

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
