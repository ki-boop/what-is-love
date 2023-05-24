package com.example.hackatonrowi.service;

import com.example.hackatonrowi.entity.*;
import com.example.hackatonrowi.repository.ChatMessageRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    private final SimpMessagingTemplate messagingTemplate;

    public ChatMessageService(ChatMessageRepository chatMessageRepository, SimpMessagingTemplate messagingTemplate) {
        this.chatMessageRepository = chatMessageRepository;
        this.messagingTemplate = messagingTemplate;
    }

    public ChatMessage sendMessage(String content, User user, Chat chat, RoleName roleName) {
        ChatMessage chatMessage = chatMessageRepository.save(ChatMessage.builder()
                .chat(chat)
                .sender(user)
                .content(content)
                .sentAt(Date.valueOf(LocalDate.now()))
                .build()
        );

        String recipient = roleName == RoleName.ROLE_CUSTOMER ? chat.getManager().getUsername() : chat.getCustomer().getUsername();

//        messagingTemplate.convertAndSendToUser();

        return chatMessage;
    }
}
