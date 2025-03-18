package com.example.WebSocket.service;

import com.example.WebSocket.DTO.SignUpRequestDto;
import com.example.WebSocket.domain.User;
import com.example.WebSocket.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("이미 존재하는 사용자입니다.");
        }

        // 비밀번호 해싱
        String encodedPassword = passwordEncoder.encode(password);

        // 유저 생성 후 저장
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);

        userRepository.save(user);
    }
}
