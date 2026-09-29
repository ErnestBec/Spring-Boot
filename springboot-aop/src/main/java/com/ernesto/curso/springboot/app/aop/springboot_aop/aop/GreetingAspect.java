package com.ernesto.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) 
@Aspect
@Component 
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //Otra forma de hacer el punto de corte es usanto PintCut()
    @Pointcut("execution(String com.ernesto.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") 
    private void generetingLoggerPointCut(){}

    @Before("generetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    // Podemos indiccar el en donde se ejecutara con * e indica todo dentro del
    // package x
    @After("generetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: " + method + " con los argumentos " + args);
    }

    @AfterReturning("generetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar: " + method + " con los argumentos " + args);
    }
 
    @AfterThrowing("generetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de excepción: " + method + " con los argumentos " + args);
    }

    @Around ("generetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        
        try {
            logger.info("Antes (Around): " + method + " con los argumentos " + args);
            result = joinPoint.proceed(); 
            logger.info("Despues (Around): " + method + " con los argumentos " + args);
            return result; 
        } catch (Exception e) {
            logger.info("Despues de excepción (Around): " + method + " con los argumentos " + args);
            throw e;
        }
    }
   

}
