package com.example.hackatonrowi.repository;

import com.example.hackatonrowi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReposirory  extends JpaRepository<Product, Long> {
    @Override
    List<Product> findAll();
}
