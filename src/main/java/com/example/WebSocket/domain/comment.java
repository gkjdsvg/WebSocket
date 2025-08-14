package com.example.WebSocket.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 ID
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "comment_username", referencedColumnName = "username")
    private User user;
}
