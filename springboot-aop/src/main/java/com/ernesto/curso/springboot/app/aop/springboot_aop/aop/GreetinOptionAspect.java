package com.ernesto.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2) 
@Component 
@Aspect 
public class GreetinOptionAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Around("execution(* com.ernesto.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") 
    public  Object loggObjectOrder(ProceedingJoinPoint joinPoint) throws Throwable{
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        
        try {
            logger.info("Antes (Around Order): " + method + " con los argumentos " + args);
            result = joinPoint.proceed(); 
            logger.info("Despues (Around Order): " + method + " con los argumentos " + args);
            return result; 
        } catch (Exception e) {
            logger.info("Despues de excepción (Around Order): " + method + " con los argumentos " + args);
            throw e;
        }

    }
}
