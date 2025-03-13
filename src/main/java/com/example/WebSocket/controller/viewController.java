package com.example.WebSocket.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewController {
    @GetMapping("/note")
    public String note() {
        return "note";
    }

    @GetMapping("/task")
    public String task() {
        return "task";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
