package com.springprojects.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springprojects.hibernate.demo.entity.Instructor;
import com.springprojects.hibernate.demo.entity.InstructorDetail;
import com.springprojects.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
		                        .addAnnotatedClass(Instructor.class)
		                        .addAnnotatedClass(InstructorDetail.class)
		                        .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the objects
			/*
			 * Instructor tempInstructor = new Instructor("Chad", "Darby",
			 * "darby@gmail.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
			 */
			
			Instructor tempInstructor = new Instructor("Queeny", "Jain", "queeny@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.queeny.com/youtube",
					"Acting");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			
			//save the instructor
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
			
		}

	}

}

























