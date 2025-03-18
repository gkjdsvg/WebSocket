package com.example.WebSocket.controller;

import com.example.WebSocket.DTO.SignUpRequestDto;
import com.example.WebSocket.DTO.UserRequest;
import com.example.WebSocket.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {
    private final UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@Validated @RequestBody SignUpRequestDto request) {
        userService.registerUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("회원가입 성공!");
    }
}
