package com.example.aopbeforeadviceexample.io.spring.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

    @Before(value = "execution(* com.example.aopbeforeadviceexample.io.spring.boot.service.EmployeeService.* (..)) && args(empId, firstName, secondName)")
    public void beforeAdvice(JoinPoint joinPoint, String empId, String firstName, String secondName) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("Creating Employee with first name - " + firstName + ", second name - " + secondName + " and id - " + empId);
    }
}
