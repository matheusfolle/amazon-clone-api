package com.ecommerce.amazon_clone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.amazon_clone.models.Product;
import com.ecommerce.amazon_clone.repositories.ProductRepository;

// Anotações são metadados 
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    // Spring "injecta" o repo para utilizarmos o BD
    @Autowired
    private ProductRepository repository;

    // Rota GET para listar products a partir do select *
    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Rota POST para criar product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }

}
