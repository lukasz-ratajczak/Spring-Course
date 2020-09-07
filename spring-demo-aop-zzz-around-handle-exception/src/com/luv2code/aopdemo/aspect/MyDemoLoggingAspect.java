package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.AccessibleObject;
import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        logger.info("\n=========> Executing @Around on method: "+proceedingJoinPoint.getSignature().toShortString());

        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e){
            logger.warning(e.getMessage());
            throw e;
        }
        long end = System.currentTimeMillis();

        long duration = end - begin;

        logger.info("\n=========> Duration: "+duration/1000+" seconds");
        
        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=========> Executing @After (finally) on method: "+method);

    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc){
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=========> Executing @AfterThrowing on method: "+method);

        logger.info("\n=========> Exception is: "+exc);
    }

    @Before("LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        logger.info("\n====>>> Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: "+methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg: args) {
            logger.info(tempArg.toString());
            if(tempArg instanceof Account){
                Account account = (Account) tempArg;
                logger.info("account name: "+ account.getName());
                logger.info("account level: "+ account.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=========> Executing @AfterReturning on method: "+method);

        logger.info("\n=========> Result is: "+result);

        convertAccountNamesToUpperCase(result);

        logger.info("\n=========> Modified Result is: "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account account:result
             ) {
            String upperCaseName = account.getName().toUpperCase();
            account.setName(upperCaseName);
        }
    }


}
