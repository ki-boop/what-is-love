package com.example.hackatonrowi.service;

import com.example.hackatonrowi.entity.Customer;
import com.example.hackatonrowi.entity.Manager;
import com.example.hackatonrowi.repository.CustomerRepository;
import com.example.hackatonrowi.repository.ManagerRepository;
import com.example.hackatonrowi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager getManagerByUsername(String username) {
        return managerRepository.findByUsername(username).orElseThrow();
    }
}
