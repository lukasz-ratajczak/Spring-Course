package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int theId = 2;

            session.beginTransaction();

            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);

            System.out.println("tempInstructorDetail: "+tempInstructorDetail);

            System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        catch(Exception exc){
            exc.printStackTrace();
        }

        finally {
            session.close();
            factory.close();
        }


    }

}
