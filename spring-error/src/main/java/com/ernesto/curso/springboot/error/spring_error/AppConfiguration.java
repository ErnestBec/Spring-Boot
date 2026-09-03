package com.ernesto.curso.springboot.error.spring_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.ernesto.curso.springboot.error.spring_error.models.domain.User;

@Configuration
public class AppConfiguration {
    
    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Ernesto", "Becerril"));
        users.add(new User(2L, "Erik", "Becerril"));
        users.add(new User(3L, "Armando", "Becerril"));
        users.add(new User(4L, "Raul", "Becerril"));
        users.add(new User(5L, "Enedina", "Becerril"));
        users.add(new User(6L, "Ernesto", "Polcarpio"));
        return users;
    } 

    
}
