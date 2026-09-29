package com.ernesto.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service 
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String person, String phrase, String position) {
        String greeting = phrase + " " + person + " " +position;
        System.out.println(greeting);
        return greeting; 
    }

    @Override
    public String sayHelloException(String person, String phrase, String position) {
        throw  new RuntimeException("Nuevo error");
    }

    
}
