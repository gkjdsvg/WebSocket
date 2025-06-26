package com.example.WebSocket.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Token {
    private String refreshToken;
    private String accessToken;
}
