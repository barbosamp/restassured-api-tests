# Projeto de Automação de Testes de API

Este projeto tem como objetivo a automação de testes de API utilizando o framework Rest Assured, com suporte a escrita de testes em BDD com Cucumber e serialização/deserialização de dados com Jackson.

### Tecnologias e Ferramentas
- Java 21
- Rest Assured 5.5.0
- Cucumber 7.22
- Jackson 2.15
- Maven

### Estrutura do Projeto
├───.github
├   ├───workflows  
├───src                                               
│   ├───test                                            
│       ├───java                                      
│       │   └───dev.etech                                    
│       │       └───config
│       │       └───endpoints
│       │       └───pojo
│       │       │   └───auth
│       │       │   └───filmes
│       │       │   └───usuarios
│       │       └───runner
│       │       └───steps
│       │       └───utils
│       └───resources                                 
│           └───features  - Cenários de Teste no formato Gherkin


### Pré-requisitos
- Java 21 instalado
- Maven ou Gradle configurado
- IDE recomendada: IntelliJ IDEA ou Eclipse

## Como Executar os Testes

### Via maven:
```bash
  mvn clean test
```

### Via IDE:
O arquivo que deve ser executado encontra-se:
```bash
# src/test/java/dev/etech/runner/RunTest.java

# Utilizar a tag para rodar os cénarios que deseja.
# Exemplo:
tags = {"@smokeTest"})

```

#### [IntelliJ] Para executar o projeto basta clicar com o botão direito do mouse -> Run 'RunTest'

### Boas Práticas Adotadas
- Padrão Page Object adaptado para APIs
- Reutilização de código com métodos utilitários
- Dados externos parametrizados quando necessário
- Separação de camadas (Steps, Services, Models)