package com.ecommerce.amazon_clone.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SapABAPClient {

    // O motor de logs oficial do Spring
    private static final Logger log = LoggerFactory.getLogger(SapABAPClient.class);

    public void sendToLegacyErp(String productName) {
        log.info("ABAP CLIENT: Iniciando conexão via middleware (CPI) para o ERP legado. Produto: '{}'", productName);
        
        try {
            // Simulando o tempo de resposta da rede e do servidor SAP (1.5 segundos) que futuramente pode ser substituído por uma chamada real via HTTP para o middleware (CPI) que se comunica com o SAP S/4HANA.
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("ABAP CLIENT: Operação interrompida.", e);
            throw new IllegalStateException("ABAP CLIENT: Falha na conexão de rede com o S/4HANA", e);
        }
        log.info("ABAP CLIENT: Integração concluída. Produto '{}' sincronizado no SAP S/4HANA.", productName);
    }
}