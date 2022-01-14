package com.example.aopreturningadvice.io.spring.boot.aspect;

import com.example.aopreturningadvice.io.spring.boot.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

    //implementing after returning advice
    @AfterReturning(value = "execution(* com.example.aopreturningadvice.io.spring.boot.service.impl.AccountServiceImpl.*(..))", returning = "account")
    public void afterReturningAdvice(JoinPoint joinPoint, Account account) {
        System.out.println("After Returning method:" + joinPoint.getSignature());
        System.out.println(account);
    }

}
