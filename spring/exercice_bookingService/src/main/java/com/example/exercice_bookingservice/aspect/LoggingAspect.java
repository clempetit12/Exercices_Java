package com.example.exercice_bookingservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.exercice_bookingservice.repository.BookRepository.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Action Before");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.example.exercice_bookingservice.repository.BookRepository.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Action After");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Returned value: " + result);
    }


}
