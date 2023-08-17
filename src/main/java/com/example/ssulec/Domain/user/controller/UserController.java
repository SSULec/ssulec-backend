package com.example.ssulec.Domain.user.controller;

import com.example.ssulec.Domain.user.assembler.UserModelAssembler;
import com.example.ssulec.Domain.user.domain.User;
import com.example.ssulec.Domain.user.dto.UserLoginDto;
import com.example.ssulec.Domain.user.exception.UserNotFoundException;
import com.example.ssulec.Domain.user.repository.UserRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    UserRepository userRepository;
    UserModelAssembler userModelAssembler;

    public UserController(UserRepository userRepository, UserModelAssembler userModelAssembler) {
        this.userRepository = userRepository;
        this.userModelAssembler = userModelAssembler;
    }

    @GetMapping("/user/{id}")
    public EntityModel<User> one(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );
        return userModelAssembler.toModel(user);
    }

    @GetMapping("/user")
    public CollectionModel<EntityModel<User>> all() {
        List<EntityModel<User>> users = userRepository.findAll().stream()
                .map(userModelAssembler::toModel)
                .toList();
        return CollectionModel.of(users);
    }

    @PostMapping("/user")
    public ResponseEntity<?> add(@RequestBody User user) {
        EntityModel<User> model = userModelAssembler.toModel(userRepository.save(user));

        return ResponseEntity
                .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(model);
    }

    @PostMapping("/user/login")
    public boolean login(@RequestBody UserLoginDto userLoginDto){
        Optional<User> userOptional = userRepository.findByEmail(userLoginDto.email());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            return user.getPassword().equals(userLoginDto.password());
        }
        throw new UserNotFoundException("User not found");
    }
}
