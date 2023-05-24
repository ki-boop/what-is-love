package com.example.hackatonrowi.repositories;

import com.example.hackatonrowi.entity.Chat;
import com.example.hackatonrowi.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
