package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {


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

            int theId = 2;

            Student tempStudent = session.get(Student.class, theId);
            Course tempCourse1 = new Course("Guitar Practice");
            Course tempCourse2 = new Course("Fishing is Great, or maybe not");

            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);

            System.out.println(tempStudent + ">> adding new courses <<"+tempStudent.getCourses());

            session.save(tempCourse1);
            session.save(tempCourse2);


            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }


    }

}
