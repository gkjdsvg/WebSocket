package com.example.WebSocket.domain;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.tool.schema.Action;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 ID
    private Long note_id;

    @Column(nullable = true)
    private String content;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private String note_username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // 🔥 FK 컬럼
    private User user;

    public Note(String content) {
        this.content = content;
    }

    @PrePersist
    protected void onCreate() {
        if (this.created_at == null) {
            this.created_at = LocalDateTime.now(); // null일 경우 자동 설정
        }
    }

    public void setUser(String user) {
        this.note_username = user;
    }
}
