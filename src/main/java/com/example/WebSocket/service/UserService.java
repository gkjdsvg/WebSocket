package com.example.WebSocket.service;

import com.example.WebSocket.DTO.LoginRequest;
import com.example.WebSocket.JWT.JwtTokenProvider;
import com.example.WebSocket.domain.User;
import com.example.WebSocket.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional
    public void registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("이미 존재하는 사용자입니다.");
        }

        // 비밀번호 해싱
        String encodedPassword = passwordEncoder.encode(password);

        // 유저 생성 후 저장
        User user = User.builder()
                .username(username) // 올바르게 username을 전달
                .password(encodedPassword) // 인코딩된 비밀번호 저장
                .build();

        userRepository.save(user);
    }

    public String login(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("username이나 password가 null입니다.");
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("사용자가 없습니다"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }

        return jwtTokenProvider.createToken(user.getUsername());
    }
}
