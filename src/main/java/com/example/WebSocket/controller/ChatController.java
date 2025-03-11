package com.example.WebSocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @GetMapping("/home")
    public String homePage() {
        return "home";  // chat.html 파일을 반환 (resources/templates/chat.html)
    }
}
