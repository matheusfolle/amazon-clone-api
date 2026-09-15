package com.ecommerce.amazon_clone.services;

import org.springframework.stereotype.Component;

// "PAC" é a chave de busca
@Component("PAC")
public class FreightPACStrategy implements CalculateChargesStrategy {

    @Override
    public double calculate(Double weight) {
        System.out.printf("Calculando frete PAC para peso: %.3f", weight);
        if (weight <= 1) {
            return 10.0;
        } else if (weight <= 5) {
            return 20.0;
        } else {
            return 30.0;
        }
    }
}