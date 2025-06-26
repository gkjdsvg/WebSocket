package com.example.WebSocket.service;

import com.example.WebSocket.domain.token;
import com.example.WebSocket.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final TokenRepository tokenRepository;

    public token findByRefreshToken(String token) {
        return tokenRepository.findByRefreshToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
