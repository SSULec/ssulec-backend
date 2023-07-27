package com.example.ssulec.Domain.user.controller;

import com.example.ssulec.Domain.user.domain.User;
import com.example.ssulec.Domain.user.exception.UserNotFoundException;
import com.example.ssulec.Domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );
    }
}
