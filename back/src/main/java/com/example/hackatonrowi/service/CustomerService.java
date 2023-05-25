package com.example.hackatonrowi.service;

import com.example.hackatonrowi.entity.Customer;
import com.example.hackatonrowi.repository.CustomerRepository;
import com.example.hackatonrowi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerByUsername(String username) {
        return customerRepository.findByUsername(username).orElseThrow();
    }
}
