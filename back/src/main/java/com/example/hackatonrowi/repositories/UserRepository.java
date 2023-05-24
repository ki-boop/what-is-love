package com.example.hackatonrowi.repositories;

import com.example.hackatonrowi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
