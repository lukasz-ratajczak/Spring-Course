package com.luv2code.aopdemo;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain Program: AroundDemoApp");

        logger.info("Calling getFortune()");

        boolean tripWire = true;

        fortuneService.getFortune(tripWir-e);

        logger.info("\nMy fortune is: "+fortuneService.getFortune());

        logger.info("Finished");

        context.close();



    }
}
