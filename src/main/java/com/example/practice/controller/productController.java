package com.example.practice.controller;

import com.example.practice.entity.Product;
import com.example.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class productController {

    // dependency injection
    private final ProductService productService;

    @Autowired
    public productController(ProductService productService) {
        this.productService = productService;
    }

    // method find by id
    @GetMapping(path = "get/product/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.getProductID(id));
    }

    // method find all id
    @GetMapping(path = "get/products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    // method to delete
    @DeleteMapping(path = "delete/product/{productID}")
    public void deleteProduct(@PathVariable Long productID) {
        // delete product id service
        productService.deleteProductID(productID);
    }

    @DeleteMapping(path = "delete/products")
    public void deleteProduct() {
        // delete all product
        productService.deleteAllProduct();
    }

    // method save product
    @PostMapping(path = "set/product")
    public void setProduct(@RequestBody Product product) {
        productService.setProduct(product);
    }

}
