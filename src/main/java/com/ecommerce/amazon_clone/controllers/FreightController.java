package com.ecommerce.amazon_clone.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.amazon_clone.services.FreightService;

@RestController
@RequestMapping("/api/freight")
public class FreightController {

    private final FreightService freightService;

    // Facilita a criação de testes unitários e garante que a dependência seja imutável (final)
    public FreightController(FreightService freightService) {
        this.freightService = freightService;
    }

    @GetMapping("/calculate")
    public Double calculateFreight(@RequestParam String type, @RequestParam Double weight) {
        // Passa a resp para a Service aplicar a regra de negócio
        return freightService.calculateFreight(type, weight);
    }
}
