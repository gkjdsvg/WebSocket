package com.example.WebSocket.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;

    public JwtTokenProvider(JwtProperties jwtProperties) {  // ✅ 매개변수 추가!
        this.jwtProperties = jwtProperties;
    }

    //토큰 생성
    public String createToken(String username) {
        long expirationTime = 1000 * 60 * 60; // 1시간

        Date now = new Date();

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationTime))
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

    public String getUsernameFromToken(String token) {
        String secretKey = "study-springboot-is-a-secure-key-32-characters";
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
