package com.example.WebSocket.DTO;

import com.example.WebSocket.domain.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class NoteDto {
    private Long id;
    private String content;

    public NoteDto(Note note) {
        this.id = note.getId();
        this.content = note.getContent();
    }
}
