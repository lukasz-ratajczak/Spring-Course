package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.concurrent.locks.ReadWriteLock;

public class CreateCoursesAndStudentsDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            Course tempCourse = new Course("Pacman - How To Score One Million Points");
            System.out.println("\n");
            System.out.println("Saving the Course: "+tempCourse);
            session.save(tempCourse);

            Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("\n");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved students: "+ tempCourse.getStudents());

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }


    }

}
