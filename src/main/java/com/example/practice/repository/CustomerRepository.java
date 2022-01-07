package com.example.practice.repository;

import com.example.practice.entity.Customer;
import com.example.practice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

