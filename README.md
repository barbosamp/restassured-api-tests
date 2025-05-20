# Projeto de Automação de Testes de API

Este projeto tem como objetivo a automação de testes de API utilizando o framework Rest Assured, com suporte a escrita de testes em BDD com Cucumber e serialização/deserialização de dados com Jackson.

### Tecnologias e Ferramentas
- Java 21
- Rest Assured 5.5.0
- Cucumber 7.22
- Jackson 2.15
- Maven

### Estrutura do Projeto
```bash
├── .github/
│   └── workflows/               # Workflows do GitHub Actions para CI/CD
│
├── src/
│   └── test/
│       ├── java/
│       │   └── dev.etech/       # Pacote base da automação
│       │       ├── config/     # Configurações globais (ex: setup do RestAssured, variáveis de ambiente)
│       │       ├── endpoints/  # URLs e paths de API organizados por recurso
│       │       ├── pojo/       # Modelos de dados (Plain Old Java Objects)
│       │       │   ├── auth/   # Modelos de autenticação
│       │       │   ├── filmes/ # Modelos para a entidade Filmes
│       │       │   └── usuarios/ # Modelos para a entidade Usuários
│       │       ├── runner/     # Classes que executam os testes com Cucumber (Runner classes)
│       │       ├── steps/      # Definição dos passos (Steps Definitions) dos testes BDD
│       │       └── utils/      # Classes utilitárias e helpers (geração de dados, leitura de arquivos etc.)
│       │
│       └── resources/
│           └── features/       # Arquivos .feature escritos em Gherkin (Cenários de teste BDD)

```

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
