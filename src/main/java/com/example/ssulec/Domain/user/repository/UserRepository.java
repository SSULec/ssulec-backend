package com.example.ssulec.Domain.user.repository;

import com.example.ssulec.Domain.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(int userId);
    Optional<User> findByEmail(String email);
}
