package com.ecommerce.amazon_clone.controllers;

import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.amazon_clone.dtos.CreateProductRequest;
import com.ecommerce.amazon_clone.models.Product;
import com.ecommerce.amazon_clone.repositories.ProductRepository;
import com.ecommerce.amazon_clone.services.SapABAPClient;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductRepository repository;
    private final SapABAPClient sapABAPClient;

    // Injeção de dependência dupla!
    public ProductController(ProductRepository repository, SapABAPClient sapABAPClient) {
        this.repository = repository;
        this.sapABAPClient = sapABAPClient;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @PostMapping
    @Transactional
    // Transactional: Se o cliente SAP lançar IllegalStateException, a gravação local será revertida.
    public Product createProduct(@Valid @RequestBody CreateProductRequest request) {
        // A API só chega aqui se o DTO passar em todas as validações (nome não vazio, preço > 0)
        // Depois, converto esse DTO para a Model (Product) e salvo no banco.
        log.info("Recebendo requisição POST para criar o produto: {}", request.name());

        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());

        // 1. Salva no banco local da vitrine (H2)
        Product savedProduct = repository.save(product);
        log.info("Produto salvo no banco local (H2) com ID: {}", savedProduct.getId());

        // 2. Dispara a integração para o sistema ABAP
        sapABAPClient.sendToLegacyErp(savedProduct.getName());

        return savedProduct;
    }
}
