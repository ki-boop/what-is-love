package com.example.hackatonrowi.controller;

import com.example.hackatonrowi.dto.SendMessageDto;
import com.example.hackatonrowi.entity.Chat;
import com.example.hackatonrowi.entity.ChatMessage;
import com.example.hackatonrowi.entity.RoleName;
import com.example.hackatonrowi.entity.User;
import com.example.hackatonrowi.service.ChatMessageService;
import com.example.hackatonrowi.service.ChatService;
import com.example.hackatonrowi.service.UserService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final UserService userService;
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;
    private final ChatService chatService;

    public ChatController(UserService userService,
                          SimpMessagingTemplate messagingTemplate,
                          ChatMessageService chatMessageService,
                          ChatService chatService) {
        this.userService = userService;
        this.messagingTemplate = messagingTemplate;
        this.chatMessageService = chatMessageService;
        this.chatService = chatService;
    }

    @MessageMapping("/chat")
    public void processMessage(@Payload SendMessageDto messageDto) {
        System.out.println(messageDto);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getPrincipal();

        messagingTemplate.convertAndSendToUser(authentication.getName(), "/queue/drivers", "Сообщение отправлено");

        User user = userService.getUserByUsername(authentication.getName());
////
//        Chat chat = chatService.getChat(messageDto.getChatId());
//
//        RoleName roleName = authentication.getAuthorities().contains("ROLE_CUSTOMER") ? RoleName.ROLE_CUSTOMER : RoleName.ROLE_MANAGER;
//
//        ChatMessage chatMessage = chatMessageService.sendMessage(messageDto.getContent(), user, chat, roleName);
//
//        chatService.sendMessage(messageDto);

        return;
    }
}
