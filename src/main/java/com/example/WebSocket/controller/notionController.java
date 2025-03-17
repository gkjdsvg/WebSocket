package com.example.WebSocket.controller;

import com.example.WebSocket.DTO.NoteRequestDto;
import com.example.WebSocket.domain.Note;
import com.example.WebSocket.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@Slf4j
public class notionController {
    private final NoteService noteService;

    public notionController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("create")
    public ResponseEntity<Note> createNote(@RequestBody NoteRequestDto noteRequestDto) {
        Note savedNote = noteService.save(noteRequestDto);
        return ResponseEntity.ok(savedNote);
    }
}
