package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor tempInstructor =
                    new Instructor("Chad", "Darby", "darby@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("luv2code.com/youtube", "luv 2 code!");

//            Instructor tempInstructor =
//                    new Instructor("Madhu", "Patel", "mahdu@luv2code.com");
//
//            InstructorDetail tempInstructorDetail =
//                    new InstructorDetail("youtube.com/guitar", "guitar");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor: "+tempInstructor);
            session.save(tempInstructor);



            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }


    }

}
