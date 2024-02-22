package com.example.correction_spring_aspect.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TransactionalAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(com.example.correction_spring_aspect.annotation.Transactional)")
    public void transationalPointCut() {

    }

    @Around("transationalPointCut()")
    public Object transationalAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("Transaction begin");
            Object object = joinPoint.proceed();
            System.out.println("Commit transaction");
            logger.warn("Method name : " + joinPoint.getSignature().getName());
            logger.warn("Arguments name : " + Arrays.asList(joinPoint.getArgs()));
            return object;
        }catch (Exception ex){
            System.out.println("Transaction roolback");
            throw ex;
        }


    }


}
