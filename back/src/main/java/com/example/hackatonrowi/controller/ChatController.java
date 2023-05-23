package com.example.hackatonrowi.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
//
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(@Payload ChatMessage chatMessage,
//                               SimpMessageHeaderAccessor headerAccessor) {
//        // Add username in web socket session
////        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//    }

    @EventListener(ApplicationReadyEvent.class)
    public void echo() throws Exception{
        int i = 0;
        while (true) {
            System.out.println(i);
            messagingTemplate.convertAndSend("/echo", i++);
            Thread.sleep(2000);
        }
    }
}
