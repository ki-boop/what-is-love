//package com.example.hackatonrowi.controller;
//
//import com.example.hackatonrowi.service.ChatMessageService;
//import com.example.hackatonrowi.service.ChatRoomService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.socket.messaging.SessionConnectedEvent;
//
//@RestController
//@RequestMapping("/api/chat")
//public class ChatController {
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;
//    @Autowired private ChatMessageService chatMessageService;
//    @Autowired private ChatRoomService chatRoomService;
//
//    @MessageMapping("/chat")
//    public void processMessage(@Payload ChatMessage chatMessage) {
//        var chatId = chatRoomService
//                .getChatId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true);
//        chatMessage.setChatId(chatId.get());
//
//        ChatMessage saved = chatMessageService.save(chatMessage);
//
//        messagingTemplate.convertAndSendToUser(
//                chatMessage.getRecipientId(),"/queue/messages",
//                new ChatNotification(
//                        saved.getId(),
//                        saved.getSenderId(),
//                        saved.getSenderName()));
//    }
//}
