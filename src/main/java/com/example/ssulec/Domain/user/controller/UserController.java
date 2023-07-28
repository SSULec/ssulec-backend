package com.example.ssulec.Domain.user.controller;

import com.example.ssulec.Domain.user.assembler.UserModelAssembler;
import com.example.ssulec.Domain.user.domain.User;
import com.example.ssulec.Domain.user.exception.UserNotFoundException;
import com.example.ssulec.Domain.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserRepository userRepository;
    UserModelAssembler userModelAssembler;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{id}")
    public EntityModel<User> one(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );
        return userModelAssembler.toModel(user);
    }
}
