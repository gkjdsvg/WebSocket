//package com.example.WebSocket.controller;
//
//
//import com.example.WebSocket.DTO.LoginRequest;
//import com.example.WebSocket.DTO.SignUpRequestDto;
//import com.example.WebSocket.JWT.JwtTokenProvider;
//import com.example.WebSocket.domain.User;
//import com.example.WebSocket.repository.UserRepository;
//import com.example.WebSocket.service.NoteService;
//import com.example.WebSocket.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.HttpHeaders;
//
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    private final JwtTokenProvider jwtTokenProvider;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public AuthController(JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.userRepository = userRepository;
//    }
//    // 로그인 및 사용자 정보 조회 API
//    // 로그인 API (JWT 발급)
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//        String username = request.getUsername();
//        String password = request.getPassword();
//
//        Optional<User> userOptional = userRepository.findByUsername(username);
//        if (userOptional.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false, "message", "존재하지 않는 사용자입니다."));
//        }
//
//        User user = userOptional.get();
//        if (!user.getPassword().equals(password)) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false, "message", "비밀번호가 틀렸습니다."));
//        }
//
//        String jwtToken = jwtTokenProvider.createToken(username);
//        return ResponseEntity.ok(Map.of(
//                "success", true,
//                "token", jwtToken
//        ));
//    }
//}
