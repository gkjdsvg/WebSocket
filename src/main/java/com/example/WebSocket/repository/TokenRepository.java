package com.example.WebSocket.repository;

import com.example.WebSocket.domain.token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<token, Long> {
    Optional<token> findByRefreshToken(String token);
    Optional<token> findByTokenUserId(Long id);
}
