package com.example.hackatonrowi;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

@Component
public class WebsocketTest {
    private final SimpMessagingTemplate messagingTemplate;

    public WebsocketTest(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    @EventListener
    public void handleWebSocketConnectionListener(final SessionConnectedEvent event){
        System.out.println("Wow, docker-postgresql-multiple-databases new user in the chat");
    }

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
