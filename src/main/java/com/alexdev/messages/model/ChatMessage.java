package com.alexdev.messages.model;

import lombok.*;

@Data
@Builder
public class ChatMessage {
    private String content;
    private String sender;
}
