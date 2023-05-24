package com.example.hackatonrowi.service;

import com.example.hackatonrowi.dto.SendMessageDto;
import com.example.hackatonrowi.entity.Chat;
import com.example.hackatonrowi.entity.ChatMessage;
import com.example.hackatonrowi.entity.User;
import com.example.hackatonrowi.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChatService {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat getChat(String chatId) {
        return chatRepository.findById(UUID.fromString(chatId)).orElseThrow();
    }
}
