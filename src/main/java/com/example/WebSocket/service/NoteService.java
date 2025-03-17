package com.example.WebSocket.service;

import com.example.WebSocket.DTO.NoteRequestDto;
import com.example.WebSocket.domain.Note;
import com.example.WebSocket.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    @Transactional
    public Note save(NoteRequestDto noteRequestDto) {
        Note note = new Note(noteRequestDto.getContent());
        return noteRepository.save(note);
    }
}
