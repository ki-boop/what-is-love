package com.example.hackatonrowi.service;

import com.example.hackatonrowi.dto.ChatMessageDto;
import com.example.hackatonrowi.entity.*;
import com.example.hackatonrowi.repository.ChatMessageRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    private final SimpMessagingTemplate messagingTemplate;

    public ChatMessageService(ChatMessageRepository chatMessageRepository, SimpMessagingTemplate messagingTemplate) {
        this.chatMessageRepository = chatMessageRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @Transactional
    public ChatMessage sendMessage(String content, User user, Chat chat, RoleName roleName) {
        ChatMessage chatMessage = chatMessageRepository.save(ChatMessage.builder()
                .id(UUID.randomUUID())
                .chat(chat)
                .sender(user)
                .content(content)
                .sentAt(Date.valueOf(LocalDate.now()))
                .build()
        );

        String recipient = roleName == RoleName.ROLE_CUSTOMER ? chat.getManager().getUsername() : chat.getCustomer().getUsername();

        messagingTemplate.convertAndSendToUser(recipient, "/queue/drivers", ChatMessageDto.map(chatMessage));

        return chatMessage;
    }
}
