package com.example.hackatonrowi.repositories;

import com.example.hackatonrowi.entity.Product;
import com.example.hackatonrowi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductReposirory  extends JpaRepository<Product, Long> {
    @Override
    List<Product> findAll();
}
