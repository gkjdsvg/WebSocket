package com.example.WebSocket.repository;

import com.example.WebSocket.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
