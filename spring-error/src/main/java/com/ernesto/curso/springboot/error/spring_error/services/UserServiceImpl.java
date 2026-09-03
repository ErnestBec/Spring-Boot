package com.ernesto.curso.springboot.error.spring_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ernesto.curso.springboot.error.spring_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private List<User> users ;

    @Override
    public List<User> findAll() {
        return users;
    }


    @Override
    public Optional<User> findById(Long id) {
        // for(User u : users){
        //     if(u.getId().equals(id)){
        //         user = u;
        //         break;
        //     }
        // }
        //Forma mas limpia de trabajarlo con p.funcional
        return users.stream().filter(usr -> usr.getId().equals(id)).findFirst();   
    }

    

}
