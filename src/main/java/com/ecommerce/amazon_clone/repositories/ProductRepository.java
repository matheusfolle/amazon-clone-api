package com.ecommerce.amazon_clone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.amazon_clone.models.Product;

@Repository 
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Ao extender JPA ganho todos os comandos SQL básicos
}