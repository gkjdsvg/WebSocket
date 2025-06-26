package com.example.WebSocket.JWT;

import com.example.WebSocket.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;

@Component
@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;

    //토큰 생성
    public String createToken(String username) {
        long expirationTime = 1000 * 60 * 60; // 1시간
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .setIssuer(jwtProperties.getIssuer())
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey().getBytes()) // 비밀키로 서명
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtProperties.getSecretKey().getBytes())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtProperties.getSecretKey().getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject(); // 사용자 이메일 반환
    }

    public String generateToken(User user, Duration expiredAt) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expiredAt.toMillis());
        return createToken(user.getUsername());
    }
}
