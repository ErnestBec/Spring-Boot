package com.ernesto.curso.springboot.error.spring_error.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.ernesto.curso.springboot.error.spring_error.exceptions.UserNotFoundException;
import com.ernesto.curso.springboot.error.spring_error.models.domain.User;
import com.ernesto.curso.springboot.error.spring_error.services.UserService;


@RestController
@RequestMapping("/app")
public class AppController {

    private UserService service;

    public AppController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String index(){
        int value = Integer.parseInt("10L");
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable Long id) {

        User user = service.findById(id).orElseThrow(()->  new UserNotFoundException("Error, el usuario no existe!!"));

        // Optional<User> optionalUser = service.findById(id);
        // if(optionalUser.isEmpty()){
        //     return ResponseEntity.notFound().build();
        // }
        // return  ResponseEntity.ok(optionalUser.get());
        return user;
    }
    
}
