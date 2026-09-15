package com.ecommerce.amazon_clone.services;

import org.springframework.stereotype.Component;

// "PAC" é a chave de busca
@Component("PAC")
public class FreightPACStrategy implements CalculateCharges {

    @Override
    public double calculate(Double peso) {
        System.out.println("Calculando frete PAC para peso: %.3f" + peso);
        if (peso <= 1) {
            return 10.0;
        } else if (peso <= 5) {
            return 20.0;
        } else {
            return 30.0;
        }
    }
}