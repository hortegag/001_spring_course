package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Course;
import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;
import com.home.entity.Review;
import com.home.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		// 
		try {

			// start a transaction
			session.beginTransaction();
			
			int id=2;
			Student student = session.get(Student.class, id);
			
			System.out.println("Print Student: "+student);
			
			Course courseOne = new Course("Must Read Emotional Intelligence");
			Course courseTwo = new Course("Must Read Java EE");
			courseOne.addStudent(student);
			courseTwo.addStudent(student);
			
			// save the courses
			session.save(courseOne);
			session.save(courseTwo);
			
			
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
