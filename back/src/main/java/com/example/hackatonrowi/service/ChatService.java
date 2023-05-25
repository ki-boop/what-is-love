package com.example.hackatonrowi.service;

import com.example.hackatonrowi.entity.*;
import com.example.hackatonrowi.repository.ChatRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatService {
    private final ChatRepository chatRepository;

    private final SimpMessagingTemplate messagingTemplate;

    public ChatService(ChatRepository chatRepository, SimpMessagingTemplate messagingTemplate) {
        this.chatRepository = chatRepository;
        this.messagingTemplate = messagingTemplate;
    }

    public Chat getChat(String chatId) {
        return chatRepository.findById(UUID.fromString(chatId)).orElseThrow();
    }

    public Chat createChat(Product product, Customer customer) {
        return chatRepository.save(Chat.builder()
                .customer(customer)
                .product(product)
                .build());
    }

    public List<Chat> getAvailableChats(Manager manager) {
        return chatRepository.findAllByProductAndManagerIdIsNull(manager.getProduct());
    }

    public Chat setManager(String chatId, Manager manager) {
        Chat chat = getChat(chatId);
        chat.setManager(manager);
        return chatRepository.save(chat);
    }
}
