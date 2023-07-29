package com.example.ssulec.Domain.user.repository;

import com.example.ssulec.Domain.user.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long userId);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
