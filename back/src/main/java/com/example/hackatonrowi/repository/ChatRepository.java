package com.example.hackatonrowi.repository;

import com.example.hackatonrowi.entity.Chat;
import com.example.hackatonrowi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatRepository extends JpaRepository<Chat, UUID> {
    List<Chat> findAllByProductAndManagerOnIsNull(Product product);
}
