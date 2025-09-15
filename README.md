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
  src/
├── main/
│ ├── java/
│ │ └── com.freitas.virtuallibrary
│ │ ├── entities
│ │ ├── repositories
│ │ ├── resources
│ │ ├── services
│ │ └── exceptions
│ └── resources/
│ ├── application.properties
│ └── data.sql (opcional)
└── test/

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
