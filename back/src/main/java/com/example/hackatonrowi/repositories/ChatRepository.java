package com.example.hackatonrowi.repositories;

import com.example.hackatonrowi.entity.Chat;
import com.example.hackatonrowi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
