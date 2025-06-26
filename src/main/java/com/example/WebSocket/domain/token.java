package com.example.WebSocket.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "refreshToken")
    private String refreshToken;

    @Column(name = "token_user_id")
    private long tokenUserId;

    public Long getUserId() {
        return tokenUserId;
    }
}
