package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    
    @GetMapping("/insertproducts")
    public String insertProducts() {
        productService.insertProducts();
        return "Products inserted successfully!";
    }
}

