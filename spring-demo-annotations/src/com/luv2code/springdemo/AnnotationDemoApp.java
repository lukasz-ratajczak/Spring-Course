package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach1 = context.getBean("tennisCoach", Coach.class);
        Coach coach2 = context.getBean("golfCoach", Coach.class);

        System.out.println(coach1.getDailyWorkout());
        System.out.println(coach2.getDailyWorkout());

        context.close();

    }
}
