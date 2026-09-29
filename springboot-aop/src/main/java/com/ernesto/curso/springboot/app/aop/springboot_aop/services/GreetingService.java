package com.ernesto.curso.springboot.app.aop.springboot_aop.services;

public interface GreetingService {
    String sayHello(String person, String phrase, String position);
    String sayHelloException(String person, String phrase, String position);

}
