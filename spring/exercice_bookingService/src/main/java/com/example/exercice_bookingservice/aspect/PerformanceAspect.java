package com.example.exercice_bookingservice.aspect;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    private long startTime;

    @Before("execution(* com.example.exercice_bookingservice.repository.BookRepository.*(..))")
    public void logBefore() {
        startTime = System.currentTimeMillis();
        System.out.println("Action Before");
    }

    @AfterReturning("execution(* com.example.exercice_bookingservice.repository.BookRepository.*(..))")
    public void logAfterReturning() {
        long endTime = System.currentTimeMillis();
        System.out.println("Action After");
        System.out.println("Temps execution méthode : " + (endTime - startTime) + "ms");
    }
}
