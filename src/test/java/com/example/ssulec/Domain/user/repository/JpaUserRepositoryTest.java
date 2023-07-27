package com.example.ssulec.Domain.user.repository;

import com.example.ssulec.Domain.user.domain.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class JpaUserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Test
    void save() {
        //given
        User user = new User("password", "leeminseo0923@naver.com", "이민서");
        //when
        userRepository.save(user);
        User savedUser = userRepository.findById(user.getId()).orElse(null);
        //then
        assertThat(savedUser).isEqualTo(user);
    }
}