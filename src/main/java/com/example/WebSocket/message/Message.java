package com.example.WebSocket.message;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
    private String sender;
    private String text; // "text" 필드 확인!!!

    public Message() {} // 기본 생성자 필수!

    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
