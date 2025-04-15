package com.example.WebSocket.controller;

import com.example.WebSocket.DTO.NoteRequestDto;
import com.example.WebSocket.DTO.NoteResponseDTO;
import com.example.WebSocket.JWT.JwtTokenProvider;
import com.example.WebSocket.domain.Note;
import com.example.WebSocket.repository.NoteRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ListController {

    private final NoteRepository noteRepository;

    public ListController(JwtTokenProvider jwtTokenProvider, NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostMapping("/note")
    @ResponseBody
    public List<NoteResponseDTO> getAllNotes() {
        List<Note> notes = noteRepository.findAll();  // 모든 노트 조회
        List<NoteResponseDTO> noteResponseDTOS = new ArrayList<>();  // DTO 리스트 초기화

        for (Note note : notes) {
            // Note 객체를 NoteResponseDTO로 변환
            NoteResponseDTO dto = new NoteResponseDTO(
                    note.getNote_id(),  // id
                    note.getContent(),   // 내용
                    note.getUser().getUsername()  // 작성자 이름
            );
            noteResponseDTOS.add(dto);  // DTO 리스트에 추가
        }

        return noteResponseDTOS;  // 리스트 반환
    }
}
