package com.example.ssulec.Domain.user.repository;

import com.example.ssulec.Domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository {
}
