package com.ernesto.curso.springboot.error.spring_error.services;

import java.util.List;
import java.util.Optional;

import com.ernesto.curso.springboot.error.spring_error.models.domain.User;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
}
