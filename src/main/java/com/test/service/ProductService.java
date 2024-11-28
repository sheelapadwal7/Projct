package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Product;
import com.test.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void insertProducts() {
        // Create a list of products
        Product product1 = new Product("Laptop", 10000);
        Product product2 = new Product("Smartphone", 5000);
        Product product3 = new Product("Tablet",4000);

        // Insert products into the database
        productRepository.saveAll(List.of(product1, product2, product3));
    }
}

