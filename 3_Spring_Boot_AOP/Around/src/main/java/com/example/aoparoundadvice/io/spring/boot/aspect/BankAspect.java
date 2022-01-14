package com.example.aoparoundadvice.io.spring.boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BankAspect {

    //Displays all the available methods i.e. the advice will be called for all the methods
    @Pointcut(value = "execution(* com.example.aoparoundadvice.io.spring.boot.service.BankService.*(..))")
    private void logDisplayingBalance() {
    }

    //Declares the around advice that is applied before and after the method matching with a pointcut expression
    @Around(value = "logDisplayingBalance()")
    public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("The method aroundAdvice() before invocation of the method " + jp.getSignature().getName() + " method");
        Object proceed = jp.proceed();
        System.out.println("The method aroundAdvice() after invocation of the method " + jp.getSignature().getName() + " method");
        return proceed;
    }

}
