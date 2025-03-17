package com.example.WebSocket.DTO;

import com.example.WebSocket.domain.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class NoteRequestDto {
    private Long note_Id;
    private String content;
    private String user;
    private Date created_at;
}
