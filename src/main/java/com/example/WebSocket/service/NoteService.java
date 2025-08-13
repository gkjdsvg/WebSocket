package com.example.WebSocket.service;

import com.example.WebSocket.DTO.NoteRequestDto;
import com.example.WebSocket.domain.Note;
import com.example.WebSocket.domain.User;
import com.example.WebSocket.exception.ResourceNotFoundException;
import com.example.WebSocket.repository.NoteRepository;
import com.example.WebSocket.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class NoteService {
    @Getter
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createNoteForUser(@RequestParam NoteRequestDto noteRequestDto) {
        System.out.println("Requested username: " + noteRequestDto.getUsername());

        User user = userRepository.findByUsername(noteRequestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Note note = new Note();
        note.setContent(noteRequestDto.getContent());

        user.addNote(note); // ✅ 편의 메서드 사용 (양방향 관계 설정)

        noteRepository.save(note);
    }
}