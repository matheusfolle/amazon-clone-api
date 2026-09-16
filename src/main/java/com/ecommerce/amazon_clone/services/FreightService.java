package com.ecommerce.amazon_clone.services;

import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
// A notação da assinatura da interface CalculateCharges é a chave de busca para
// o Spring encontrar a implementação correta, a chave é o nome no @Component e
// isso atua como Padrão Factory, onde a interface é o produto e as
// implementações são as fábricas.
public class FreightService {
    private final Map<String, CalculateChargesStrategy> strategies;

    // Inj. de Dep.
    public FreightService(Map<String, CalculateChargesStrategy> strategies) {
        this.strategies = strategies;
    }

    public double calculateFreight(String freightType, Double weight) {
        if (freightType == null || freightType.isBlank()) {
            throw new IllegalArgumentException("Freight type is required.");
        }

        if (weight == null || !Double.isFinite(weight) || weight < 0) {
            throw new IllegalArgumentException("Invalid weight. Weight must be a finite non-negative value.");
        }
        // Busca a estratégia correta com base no tipo de frete (freightType) e chama o método calculate da implementação correspondente.
        CalculateChargesStrategy strategy = strategies.get(freightType.trim().toUpperCase(Locale.ROOT));

        if (strategy == null) {
            throw new IllegalArgumentException("Freight type not supported by architecture.");
        }

        return strategy.calculate(weight);
    }
}
