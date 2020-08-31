package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.AccessibleObject;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========> Executing @After (finally) on method: "+method);

    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========> Executing @AfterThrowing on method: "+method);

        System.out.println("\n=========> Exception is: "+exc);
    }

    @Before("LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("\n====>>> Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg: args) {
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                Account account = (Account) tempArg;
                System.out.println("account name: "+ account.getName());
                System.out.println("account level: "+ account.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========> Executing @AfterReturning on method: "+method);

        System.out.println("\n=========> Result is: "+result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n=========> Modified Result is: "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account account:result
             ) {
            String upperCaseName = account.getName().toUpperCase();
            account.setName(upperCaseName);
        }
    }


}
