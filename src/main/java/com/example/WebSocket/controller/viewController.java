package com.example.WebSocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewController {
    @GetMapping("/note")
    public String note() {
        return "noteAdd";
    }

    @GetMapping("/task")
    public String task() {
        return "taskAdd";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping({"/signup", "signUp"})
    public String signUp() {
        return "Notion-signUp";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
