package com.ehr.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class BankLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.ehr.controllers.*.*(..))")
    private void forControllersPackage() {}

    @Pointcut("execution(* com.ehr.services.*.*(..))")
    private void forServicesPackage() {}

    @Pointcut("execution(* com.ehr.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllersPackage() || forServicesPackage() || forDAOPackage()")
    private void forApplication() {}

    @Before("forApplication()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Info: @Before('forApplication') -> Calling the Method: " + methodName);
    }

    @AfterReturning(pointcut = "forApplication()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Info: @AfterReturning(pointcut='forApplication',returning='result') -> Calling the Method: " + methodName);
        logger.info("Info: @AfterReturning(pointcut='forApplication',returning='result') -> Data Returned by Method: " + result);
    }

}
