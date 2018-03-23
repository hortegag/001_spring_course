package com.home.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.entity.Course;
import com.home.entity.Instructor;
import com.home.entity.InstructorDetail;
import com.home.entity.Review;
import com.home.entity.Student;

public class DeleteStudentDemo {

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
			
			// delete student
			session.delete(student);
			
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
