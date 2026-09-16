package com.ecommerce.amazon_clone.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

// Garante que ninguém envie lixo para a API. O Spring vai validar o DTO antes de chegar no Controller.
public record CreateProductRequest(
    @NotBlank(message = "O nome não pode estar vazio") 
    String name,
    String description,
    @NotNull(message = "O preço é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
    BigDecimal price
) {}