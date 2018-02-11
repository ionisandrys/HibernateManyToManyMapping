package com.luv2code.hibernate.demo;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentsAndCourses {

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
		
		try {			
			
			// start a transaction
			session.beginTransaction();
				
			// DELETE STUDENTS
	/*		
			// get the students from database, with id = 7,8 and 9
						int studentId;
						for(studentId=7;studentId<=9;studentId++){
							
						Student tempStudent = session.get(Student.class, studentId);
						
						System.out.println("\nLoaded student: " + tempStudent);
						System.out.println("Courses: " + tempStudent.getCourses());		
					
						// delete student
						System.out.println("\nDeleting student: " + tempStudent);
						session.delete(tempStudent);
						}
		*/				
						// delete students with id = 5,10, 12
						int[] studentsId={5,10,12};
						for(int a=0;a<=2;a++){
							
						Student tempStudent = session.get(Student.class, studentsId[a]);
						
						System.out.println("\nLoaded student: " + tempStudent);
						System.out.println("Courses: " + tempStudent.getCourses());		
					
						// delete student
						System.out.println("\nDeleting student: " + tempStudent);
						session.delete(tempStudent);
					}
						
						
			// DELETE COURSE
						/*
						 get  course from db
						int courseId = 10;
						Course tempCourse = session.get(Course.class, courseId);
						
						// delete the course
						System.out.println("Deleting course: " + tempCourse);
						
						session.delete(tempCourse);
				*/
			
			
		// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
