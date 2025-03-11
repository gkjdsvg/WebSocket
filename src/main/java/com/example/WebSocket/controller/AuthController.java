package com.example.WebSocket.controller;


import com.example.WebSocket.JWT.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

//    //로그인 API
//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        // 로그인 로직 (여기서는 간단히 예시로만 사용)
//        if (username.equals("user@example") && password.equals("123456")) {
//            // 로그인 성공 시 JWT 토큰 생성
//            return jwtTokenProvider.createToken(username);
//        } else {
//            throw new RuntimeException("Invalid credentials");
//        }
//    }
//
//    @GetMapping("/login")
//    public ResponseEntity<String> getUserInfo(@RequestParam(defaultValue = "Guest") String username) {
//        return ResponseEntity.ok("User: " + username);
//    }

    // 로그인 및 사용자 정보 조회 API
    // 로그인 API (JWT 발급)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam(defaultValue = "Guest") String username,
                                        @RequestParam(required = false) String password) {

        if (username == null || username.isBlank()) {
            username = "Guest";  // ✅ username이 없으면 자동으로 Guest 처리
        }

        // 아무 비밀번호나 입력해도 Guest 계정 로그인 가능
        if (username.equals("Guest") || (username.equals("user@example") && password.equals("123456"))) {
            String jwtToken = jwtTokenProvider.createToken(username);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken)
                    .body("Login Successful! Token: " + jwtToken);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
