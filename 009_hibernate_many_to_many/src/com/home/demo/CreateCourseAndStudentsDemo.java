package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Course;
import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;
import com.home.entity.Review;
import com.home.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//  create the Course
			Course course = new Course("Guitar how to play like a master");
			
			//save the course
			System.out.println("Saving the course");
			
			//save course and review due to cascade type
			session.save(course);
			
			//create the students
			Student studentOne = new Student("Duke", "java", "test@mydomain.com");
			Student studentTwo= new Student("Mary", "Jane", "mjane@mydomain.com");
			
			//add student to the course
			course.addStudent(studentOne);
			course.addStudent(studentTwo);
			
			//save the students
			session.save(studentOne);
			session.save(studentTwo);
			

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
