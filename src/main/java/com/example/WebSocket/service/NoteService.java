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

@Service
@RequiredArgsConstructor
public class NoteService {
    @Getter
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Transactional
    public Note save(NoteRequestDto noteRequestDto) {
        // username으로 User를 조회
        User user = userRepository.findByUsername(noteRequestDto.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + noteRequestDto.getUsername()));

        // Note 객체 생성 후 user를 세팅
        Note note = new Note(noteRequestDto.getContent());
        note.setUser(user);

        return noteRepository.save(note);  // 저장
    }
}
