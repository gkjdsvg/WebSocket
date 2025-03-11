package com.example.WebSocket.websocket;

import com.example.WebSocket.JWT.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 메시지를 받을 수 있는 경로 설정
        registry.enableSimpleBroker("/topic");  // "/topic"으로 시작하는 경로는 브로커가 처리
        registry.setApplicationDestinationPrefixes("/app");  // 클라이언트에서 보낼 경로 설정
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket 연결을 위한 엔드포인트 설정
        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:8089").withSockJS();
    }
}

