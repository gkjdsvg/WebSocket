package com.example.WebSocket.controller;

import com.example.WebSocket.DTO.LoginRequest;
import com.example.WebSocket.DTO.SignUpRequestDto;
import com.example.WebSocket.DTO.UserRequest;
import com.example.WebSocket.JWT.JwtTokenProvider;
import com.example.WebSocket.JWT.JwtUtil;
import com.example.WebSocket.domain.User;
import com.example.WebSocket.repository.UserRepository;
import com.example.WebSocket.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class userController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public userController(UserService userService, JwtTokenProvider jwtTokenProvider, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@Validated @RequestBody SignUpRequestDto request) {
        userService.registerUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("회원가입 성공!");
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        System.out.println("💡 로그인 시도: " + request.getUsername());

        String username = request.getUsername();
        String password = request.getPassword();

        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            System.out.println("❌ 존재하지 않는 사용자");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false, "message", "존재하지 않는 사용자입니다."));
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("❌ 비밀번호 틀림");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false, "message", "비밀번호가 틀렸습니다."));
        }

        String jwtToken = jwtTokenProvider.createToken(username);
        System.out.println("✅ 로그인 성공, 토큰 발급");
        return ResponseEntity.ok(Map.of(
                "success", true,
                "token", jwtToken
        ));
    }

}
