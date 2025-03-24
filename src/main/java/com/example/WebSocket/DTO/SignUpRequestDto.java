package com.example.WebSocket.DTO;

import com.example.WebSocket.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Builder
@Getter
@Setter
public class SignUpRequestDto {
    private Long id;
    private String username;
    private String password;

    public SignUpRequestDto(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
