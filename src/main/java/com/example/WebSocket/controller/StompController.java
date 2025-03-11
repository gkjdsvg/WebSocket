package com.example.WebSocket.controller;

import com.example.WebSocket.message.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class StompController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public StompController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/message")// 클라이언트에서 "/app/message"로 보낸 메시지를 받음
    public void sendMessage(Message message, SimpMessageHeaderAccessor headerAccessor) {
        String sessionId = headerAccessor.getSessionId(); // 보낸 사람의 세션 ID 가져오기
        System.out.println("📤 받은 메시지: " + message.getText()); // 디버깅 로그

        // 모든 구독자에게 전송 (하지만 보낸 사람은 제외)
        simpMessagingTemplate.convertAndSend("/topic/chat", message);
    }
}
