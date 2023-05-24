package com.example.hackatonrowi.controller;

import com.example.hackatonrowi.dto.ChatDto;
import com.example.hackatonrowi.dto.SendMessageDto;
import com.example.hackatonrowi.entity.*;
import com.example.hackatonrowi.service.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final UserService userService;
    private final CustomerService customerService;
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;
    private final ChatService chatService;

    private final ProductService productService;

    public ChatController(UserService userService,
                          CustomerService customerService, SimpMessagingTemplate messagingTemplate,
                          ChatMessageService chatMessageService,
                          ChatService chatService, ProductService productService) {
        this.userService = userService;
        this.customerService = customerService;
        this.messagingTemplate = messagingTemplate;
        this.chatMessageService = chatMessageService;
        this.chatService = chatService;
        this.productService = productService;
    }

    @PostMapping("/")
    public ChatDto createChat(@RequestParam Long productId) {
        Customer customer = customerService.getCustomerByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Product product = productService.getProductById(productId);
        return ChatDto.map(chatService.createChat(product, customer));
    }

    @MessageMapping("/chat")
    public void processMessage(@Payload SendMessageDto messageDto) {
        System.out.println(messageDto);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getPrincipal();

        messagingTemplate.convertAndSendToUser(authentication.getName(), "/queue/drivers", "Сообщение отправлено");

        User user = userService.getUserByUsername(authentication.getName());

        Chat chat = chatService.getChat(messageDto.getChatId());

        RoleName roleName = authentication.getAuthorities().contains("ROLE_CUSTOMER") ? RoleName.ROLE_CUSTOMER : RoleName.ROLE_MANAGER;

        ChatMessage chatMessage = chatMessageService.sendMessage(messageDto.getContent(), user, chat, roleName);
    }
}
