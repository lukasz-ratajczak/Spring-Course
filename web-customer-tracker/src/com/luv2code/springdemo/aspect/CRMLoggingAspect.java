package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution (* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution (* com.luv2code.springdemo.dao.*.*(..))")
    private void forDAOPackage() {
    }

    @Pointcut("execution (* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint) {

        logger.info("======>> in @Before: calling method: " + joinPoint.getSignature().toShortString());
        Object[] args = joinPoint.getArgs();

        for (Object temp : args
        ) {
            logger.info("======>> argument " + temp);
        }

    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    private void after(JoinPoint joinPoint, Object result) {

        logger.info("======>> in @Before: calling method: " + joinPoint.getSignature().toShortString());
        logger.info("======> result: " + result);
    }


}
