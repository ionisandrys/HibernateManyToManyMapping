package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForSheldon {

	public static void main(String[] args) throws ParseException {
		
		// create session factory ( once in the project)
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
	//			.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		
		Session session = factory.getCurrentSession();
		
		try{
			
			
			// start a transaction
			session.beginTransaction();
			
			// get Sheldon from database
			int studentId = 12;
			Student tempStudent = session.get(Student.class, studentId);
			
			// display Sheldon's courses
			
			System.out.println("Courses : "+ tempStudent.getCourses());
			
			// create more courses
			Course tempCourse1 = new Course("Math");
			Course tempCourse2 = new Course("Plasma Physics");
			Course tempCourse3 = new Course("Economy");
			
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse3.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the courses
			session.save(tempCourse3);
			session.save(tempCourse2);
			session.save(tempCourse1);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done ! ");
			
		}finally{
			session.close();
			factory.close();
		}
		
		
		
		
		
	}

}
