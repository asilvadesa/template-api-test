# Projeto de Automação de Testes de API REST

Este projeto tem como objetivo automatizar testes de **API REST**, utilizando **Spring Boot**, **Spring Data JPA**, **Rest Assured** e **PostgreSQL**, com foco na **geração dinâmica de massa de dados diretamente do banco** para validação dos cenários de teste.

A proposta é garantir testes mais confiáveis, reutilizáveis e próximos da realidade do ambiente.

---

## 🛠 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Rest Assured**
- **JUnit 5**
- **Maven**
- **PostgreSQL**
- **Hibernate**
- **Jackson**

---

## 📌 Arquitetura do Projeto

O projeto segue uma arquitetura organizada para facilitar manutenção e escalabilidade:
```text
src
└── main
│    ├── java
│    │   ├── domain        # Entidades / modelos
│    │   ├── repository    # Acesso ao banco de dados
│    │   ├── factory       # Criação de dados dinâmicos
│    └── resources
│        └── application-test.yml
│    
└── test
     └── java
          └── testes       # Testes automatizados
```

---

## 🎯 Objetivo do Projeto

- Automatizar testes de **API REST**
- Consultar dados reais no **PostgreSQL**
- Gerar **massa de dados dinâmica** para execução dos testes
- Evitar dados fixos (hardcoded)
- Tornar os testes mais confiáveis e próximos da realidade

---

## 🧪 Estratégia de Testes

A estratégia adotada combina:

- Consulta de dados existentes no banco
- Criação dinâmica de massa de dados
- Validação de respostas da API
- Testes independentes e reutilizáveis

### Exemplo de fluxo:
1. Buscar dados válidos no banco via JPA
2. Montar payload dinamicamente
3. Executar chamada REST com Rest Assured
4. Validar status code e response body

---

## 🔗 Integração com Banco de Dados

O acesso ao banco é feito via **Spring Data JPA**, permitindo:

- Consultas simples e complexas
- Reutilização de regras de negócio
- Facilidade na geração de dados para teste

### Exemplo de Repository:
```java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);
}
```

## 🔄 Geração de Massa de Dados Dinâmica

A massa de dados é gerada dinamicamente a partir de:

- Registros existentes no banco
- Dados randômicos controlados
- Factory Pattern para criação de objetos

### Exemplo de Factory:
```java

@Autowired
private UsuarioRepository usuarioRepository;

public class UsuarioFactory {

    public static List<Usuario> buscaUsuarioValido() {
        return usuarioRepository.findAll();
    }
}
```
Essa abordagem garante testes mais robustos e independentes.

## 🌐 Testes de API com Rest Assured

O Rest Assured é utilizado para executar e validar chamadas HTTP.

Exemplo de teste:
```java
given()
    .contentType(ContentType.JSON)
    .body(payload)
.when()
    .post("/usuarios")
.then()
    .statusCode(201)
    .body("cpf", equalTo(payload.getCpf()));

```
## ⚙️ Configuração do Ambiente

Arquivo de configuração de testes (application-test.yml):
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/testdb
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: none
    show-sql: true
```
## 🚀 Execução dos Testes
Pré-requisitos

- Java 21 ou superior
- Maven
- PostgreSQL em execução
- API REST disponível (brasilapi)
```bash
mvn clean test
```


