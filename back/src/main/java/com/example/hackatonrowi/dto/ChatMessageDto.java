package com.example.hackatonrowi.dto;

import com.example.hackatonrowi.entity.Chat;
import com.example.hackatonrowi.entity.ChatMessage;
import com.example.hackatonrowi.entity.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.UUID;

@Data
@Builder
public class ChatMessageDto {
    private UUID id;

    private Date sentAt;

    private String content;

    private Long sender_id;

    private UUID chat_id;


    public static ChatMessageDto map(ChatMessage chatMessage) {
        return ChatMessageDto.builder()
                .id(chatMessage.getId())
                .sentAt(chatMessage.getSentAt())
                .content(chatMessage.getContent())
                .sender_id(chatMessage.getSender().getId())
                .chat_id(chatMessage.getId())
                .build();
    }
}
