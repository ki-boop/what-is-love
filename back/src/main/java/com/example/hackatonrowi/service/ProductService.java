package com.example.hackatonrowi.service;

import com.example.hackatonrowi.entity.Customer;
import com.example.hackatonrowi.entity.Product;
import com.example.hackatonrowi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
