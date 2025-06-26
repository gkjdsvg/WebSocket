package com.example.WebSocket.repository;

import com.example.WebSocket.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u From User u where u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
    Optional<User> findByUserId(Long userId);
}
