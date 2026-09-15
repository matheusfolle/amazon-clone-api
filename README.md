# SAP Ecosystem Mock API (Commerce & S/4HANA Integration)

## 📌 Sobre o Projeto
Esta API RESTful foi desenvolvida para simular a camada de back-end de um ecossistema corporativo distribuído. O objetivo principal é demonstrar a aplicação de boas práticas de engenharia de software e padrões de projeto em um cenário de integração entre uma plataforma de e-commerce (Front-end desacoplado) e um ERP legado.

A arquitetura reflete o fluxo de comunicação padrão de ambientes SAP:
**Commerce (Spartacus) -> Middleware (CPI) -> SAP S/4HANA.**

## 🏗️ Arquitetura e Fluxo de Integração

O sistema simula o seguinte pipeline de dados:
1. **Origem:** O cliente (Front-end em Angular) envia um payload de criação de produto.
2. **Processamento (Spring Boot):** A API recebe, valida via DTOs, aplica regras de negócio e persiste no banco de dados em memória.
3. **Transformação e Roteamento (Simulação CPI):** O módulo `SapAbapClient` assume o papel do middleware, roteando a intenção de sincronização.
4. **Destino (S/4HANA):** Logs estruturados (`SLF4J`) registram a confirmação da chegada e do processamento do evento no ERP legado.

## 🛠️ Stack Tecnológica
* **Java 17+ / Spring Boot 3:** Framework principal para injeção de dependências e criação de endpoints REST.
* **H2 Database & Spring Data JPA:** Persistência de dados em memória para agilidade no ambiente de desenvolvimento.
* **SLF4J:** Rastreabilidade corporativa e registro de logs de integração.
* **JUnit:** Cobertura de testes unitários isolados.
* **Bean Validation:** Blindagem de API utilizando DTOs (`records`).

## 🧠 Padrões de Projeto Aplicados
* **Strategy & Factory:** Implementados no serviço de cálculo de fretes (`FreightService`). Elimina a complexidade ciclomática (`if/else`) e permite a escalabilidade de novas regras logísticas de forma isolada, onde o Spring atua como a *Factory* resolvendo a interface.
* **Injeção de Dependência por Construtor:** Garantia de imutabilidade das dependências (`final`) e facilidade de mockagem para testes unitários, seguindo as melhores práticas da documentação oficial do Spring.

## 🚀 Como Executar
```bash
# Clone o repositório
git clone [https://github.com/matheusfolle/amazon-clone-api.git](https://github.com/matheusfolle/amazon-clone-api.git)

# Acesse o diretório
cd amazon-clone-api

# Execute via Maven Wrapper
./mvnw spring-boot:run