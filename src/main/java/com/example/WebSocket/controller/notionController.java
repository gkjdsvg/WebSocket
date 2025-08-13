package com.example.WebSocket.controller;

import com.example.WebSocket.DTO.NoteRequestDto;
import com.example.WebSocket.domain.Note;
import com.example.WebSocket.domain.User;
import com.example.WebSocket.service.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<?> createNote(@RequestBody NoteRequestDto noteRequestDto) {
        /*requestBody를 사용한 이유는 URI 상에서 데이터를 줄 수 없기 때문이다.
        * 솔직히 노트 작성인데 그 많은 문자열을 URI에 담을 순 없지 않은가*/
        try {
            // NoteRequestDto 객체를 전달
            noteService.createNoteForUser(noteRequestDto);
            return ResponseEntity.ok("Note created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}