package com.example.WebSocket.JWT;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Configuration
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.issuer}")
    private String issuer;

}
