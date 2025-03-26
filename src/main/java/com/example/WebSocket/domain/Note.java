package com.example.WebSocket.domain;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "note_username", referencedColumnName = "username", nullable = false) // username으로 연관 설정
    private User user;

    @PrePersist
    protected void onCreate() {
        if (this.created_at == null) {
            this.created_at = LocalDateTime.now(); // null일 경우 자동 설정
        }
    }

    public void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.user = user;
    }
}
