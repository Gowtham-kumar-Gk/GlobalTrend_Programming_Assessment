package com.spirngboot.annotation.in;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around("@annotation(LogExecutionTime)") // Intercepts methods with @LogExecutionTime
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis(); // Record start time
        Object proceed = joinPoint.proceed(); // Execute the method
        long executionTime = System.currentTimeMillis() - start; // Calculate execution time

        logger.info("Method {} executed in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
}

