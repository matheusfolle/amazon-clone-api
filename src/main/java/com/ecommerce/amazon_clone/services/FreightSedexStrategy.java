package com.ecommerce.amazon_clone.services;

import org.springframework.stereotype.Component;

@Component("SEDEX")
public class FreightSedexStrategy implements CalculateChargesStrategy {

    @Override
    public double calculate(Double weight) {
        System.out.printf("Calculando frete SEDEX para peso: %.3f%n", weight);
        if (weight <= 1) {
            return 20.0;
        } else if (weight <= 5) {
            return 40.0;
        } else {
            return 50.0;
        }
    }
}