package com.example.WebSocket.websocket;

import com.example.WebSocket.JWT.JwtTokenProvider;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class WebSocketAuthInterceptor implements ChannelInterceptor {
    private final JwtTokenProvider jwtTokenProvider;

    public WebSocketAuthInterceptor(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        String token = message.getHeaders().get("Authorization", String.class);

        if (token != null && jwtTokenProvider.validateToken(token)) {
            // 토큰 유효하면 메시지 전달
            return message;
        }

        // 토큰이 유효하지 않으면 연결을 거부하거나 에러 처리
        throw new RuntimeException("Invalid JWT token");
    }
}
