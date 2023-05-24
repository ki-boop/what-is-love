package com.example.hackatonrowi.dto;

import com.example.hackatonrowi.entity.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ChatDto {
    private UUID id;
//    private Customer customer;
//    private Manager manager;
//    private Product product;
//    private List<ChatMessage> messages;

    public static ChatDto map(Chat chat) {
        return ChatDto.builder().id(chat.getId()).build();
    }
}
