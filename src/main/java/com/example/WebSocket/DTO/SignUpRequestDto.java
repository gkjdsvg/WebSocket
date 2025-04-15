package com.example.WebSocket.DTO;

import com.example.WebSocket.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Getter
@Setter
public class SignUpRequestDto {
    private Long id;
    private String username;
    private String password;

    public SignUpRequestDto(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }
}
