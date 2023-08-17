package com.example.ssulec.Domain.user.repository;

import com.example.ssulec.Domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository {
    @Override
    Optional<User> findByEmail(String email);
}
