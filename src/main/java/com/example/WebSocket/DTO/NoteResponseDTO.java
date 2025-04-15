package com.example.WebSocket.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
public class NoteResponseDTO {
    private Long note_id;
    private String note_content;
    private String note_username;

    public NoteResponseDTO(Long note_id, String content, String username) {
        this.note_id = note_id;
        this.note_content = content;
        this.note_username = username;
    }
}
