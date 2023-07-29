package com.example.ssulec.Domain.user.controller;

import com.example.ssulec.Domain.user.domain.User;
import com.example.ssulec.Domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    @WithMockUser(username = "ssulec", password = "ssulec12")
    void one() throws Exception{
        //given
        User user = new User("password", "email", "name");
        userRepository.save(user);
        //when
        mvc.perform(get("/user/" + user.getId()))
        //then
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "ssulec", password = "ssulec12")
    void all() throws Exception{
        //given
        User user = new User("password", "email", "name");
        userRepository.save(user);
        //when
        mvc.perform(get("/user"))
                //then
                .andExpect(status().isOk());
    }
}