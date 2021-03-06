package com.example.practice.service;

import com.example.practice.entity.Product;
import com.example.practice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // dependency injection
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping
    public Optional<Product> getProductID(Long id){
        return productRepository.findById(id);
    }

    @DeleteMapping
    public void deleteProductID(Long id){
        productRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllProduct(){
        productRepository.deleteAll();
    }

    @PostMapping
    public void setProduct( Product product){
        productRepository.save(product);
    }
}
