package com.ecommerce.amazon_clone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Específica que só trabalhamos com JSON, sem HTML por aqui
@RestController 
// Endereço base dos endpoints da API
@RequestMapping("/api")
public class StatusController {

    // É o guichê específico, ao acessar o GET em "api/status" você estará aqui :)
    @GetMapping("/status")
    public String checkStatus() {
        return "API da Amazon Clone está funcionando corretamente!";
    }
    
}
