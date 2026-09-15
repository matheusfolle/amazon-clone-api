package com.ecommerce.amazon_clone.services;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service 
// A notação da assinatura da interface CalculateCharges é a chave de busca para o Spring encontrar a implementação correta, a chave é o nome no @Component e isso atua como Padrão Factory, onde a interface é o produto e as implementações são as fábricas.
public class FreightService {
    private final Map<String, CalculateCharges> strategies;

    public FreightService(Map<String, CalculateCharges> strategies) {
        this.strategies = strategies;
    }

    public double calculateFreight(String freightType, Double peso) {
        // Busca a estratégia correta com base no tipo de frete (freightType) e chama o método calculate da implementação correspondente.
        CalculateCharges strategy = strategies.get(freightType.toUpperCase());

        if (strategy == null) {
            throw new IllegalArgumentException("Freight type not supported by architecture.");
        }

        return strategy.calculate(peso);
    }
}