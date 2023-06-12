package com.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAspect {

    private static final Logger logger = Logger.getLogger(FirstAspect.class);

    @Before("execution(public * getAll())")
    public void beforeAdvice() {
        logger.info("Executing @Before advice on createLeaveApplication()");
    }

    @Before("execution(* com.*.*(..))")
    public void all() {
        logger.info("Executing @Before advice on every method in service package()");
    }

    @Before("execution( * com.controller.*.*(..))")
    public void allWithJointPoint(JoinPoint joinPoint) {
        logger.info("Executing @Before advice on every method in service package()");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info(methodSignature.toString());
        for(int i = 0; i < joinPoint.getArgs().length; i++) {
            logger.info(joinPoint.getArgs()[i].getClass().getSimpleName());
            logger.info(joinPoint.getArgs()[i].toString());
        }
    }

}
