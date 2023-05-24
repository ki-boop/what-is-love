package com.example.hackatonrowi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "Message")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatMessage {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "chat_id")
    private UUID chat_id;

    @Column(name = "sender_id")
    private UUID sender_id;

    @Column(name = "sentAt")
    private Date sentAt;

    @Column(name = "content")
    private String content;
}
