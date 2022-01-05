package com.example.practice.controller;

import com.example.practice.entity.Product;
import com.example.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path = "/product/all")
public class productController {

    // dependency injection
    private final ProductService productService;

    @Autowired
    public productController(ProductService productService) {
        this.productService = productService;
    }

    // method find by id
    @GetMapping(path = "get/{id}/product")
    public Optional<Product> getProduct(@PathVariable("id") long id){
        return  productService.getProductID(id);
    }

    // method find all id
    @GetMapping(path = "get/all/product")
    public List<Product> getAllProduct(){
        return  productService.getAllProduct();
    }

    // method to delete
    @DeleteMapping(path = "delete/{productID}/product")
    public void deleteProduct(@PathVariable Long productID){
        // delete product id service
        productService.deleteProductID(productID);
    }

    @DeleteMapping(path = "delete/all/product")
    public void deleteProduct(){
        // delete all product
        productService.deleteAllProduct();
    }

    // method save product
    @PostMapping(path = "set/product")
    public void setProduct(@RequestBody Product product) {
        productService.setProduct(product);
    }

}
