package com.ecommerce.amazon_clone.services;

import org.springframework.stereotype.Component;

@Component("SEDEX")
public class FreightSedexStrategy implements CalculateCharges {
    
    @Override
    public double calculate(Double peso) {
        System.out.println("Calculando frete SEDEX para peso: %.3f%n" + peso);
        if (peso <= 1) {
            return 20.0;
        } else if (peso <= 5) {
            return 40.0;
        } else {
            return 50.0;
        }
    }
}