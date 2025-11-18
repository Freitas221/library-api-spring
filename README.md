# 📚 Virtual Library API

API RESTful desenvolvida com **Spring Boot** para gerenciamento de uma biblioteca virtual. O sistema permite o cadastro de livros, autores, usuários e o controle de empréstimos.

## 🔧 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (ou MySQL/PostgreSQL)
- Maven
- Postman (para testes)

## 🚀 Funcionalidades principais

- ✅ Cadastro de livros
- ✅ Cadastro de autores
- ✅ Registro de usuários
- ✅ Remoção de livros, autores e editora
- ✅ Consulta de disponibilidade de exemplares

## 🧱 Estrutura do projeto
src/main/java
└── com.marcos.biblioteca.project
├── ProjectApplication.java # Classe principal do Spring Boot
├── config/ # Configurações do projeto
├── model/ # Entidades JPA (Author, Book, Category, Publisher)
├── repositories/ # Interfaces do Spring Data JPA
├── resources/ # Controladores REST
│ └── exceptions/ # Tratamento de exceções e erros HTTP
├── services/ # Camada de serviços (lógica de negócio)
│ └── exceptions/ # Exceções personalizadas de serviço
src/main/resources
├── application.properties
├── application-test.properties
Dockerfile
docker-compose.yml

## 🔗 Endpoints básicos

| Método | Rota               | Descrição                   |
|--------|--------------------|-----------------------------|
| GET    | `/books`           | Lista todos os livros       |
| POST   | `/books`           | Cadastra novo livro         |
| GET    | `/users`           | Lista todos os usuários     |
| POST   | `/loans`           | Realiza um empréstimo       |
| PUT    | `/returns/{id}`    | Registra devolução de livro |

> Obs: os endpoints podem variar conforme sua implementação.

## 📦 Como executar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/virtual-library-api.git
```

## 💻 Executar Localmente (com Docker🐋)

**Configure o dockerfile**

````
FROM maven:3.8.4-eclipse-temurin-17 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/*.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

````

## 💻 Executar Localmente (sem Docker)

**Configure o (application.properties)**
````
spring.application.name=project

spring.profiles.active=test 

spring.jpa.open-in-view=true

spring.h2.console.enabled=true

spring.h2.console.path=/h2-console


Compile e execute o projeto:

mvn spring-boot:run


A aplicação será iniciada em:

http://localhost:8080
````

🧑‍💻 Autor

Marcos Freitas Rocha
Desenvolvedor Java | Spring Boot | Docker | JavaScript | HTML5 e CSS3 | 

📧 (marcosfreitas7542@gmail.com)
🌐 (https://github.com/Freitas221)
