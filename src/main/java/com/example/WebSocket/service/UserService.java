package com.example.WebSocket.service;

import com.example.WebSocket.domain.User;
import com.example.WebSocket.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 서버 시작 시 기본 유저를 추가하는 메서드
    @PostConstruct
    public void init() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("1234")); // 비밀번호 암호화 필수!
            user.setRole("ROLE_ADMIN");
            userRepository.save(user);
        }
    }
}
