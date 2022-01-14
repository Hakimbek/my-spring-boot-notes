package com.example.aopafterthrow.io.spring.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {
    //implementing after throwing advice
    @AfterThrowing(value = "execution(* com.example.aopafterthrow.io.spring.boot.service.impl.AccountServiceImpl.*(..))", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
        System.out.println("Exception is:" + ex.getMessage());
    }
}
