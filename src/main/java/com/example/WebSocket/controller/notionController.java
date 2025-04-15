package com.example.WebSocket.controller;

import com.example.WebSocket.DTO.NoteRequestDto;
import com.example.WebSocket.domain.Note;
import com.example.WebSocket.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8089")
@RequestMapping("/note")
@Slf4j
public class notionController {
    private final NoteService noteService;

    public notionController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNote(NoteRequestDto noteRequestDto) { //
        try {
            // NoteRequestDto 객체를 전달
            noteService.createNoteForUser(noteRequestDto);
            return ResponseEntity.ok("Note created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}