# Bookstore QL API

## Sobre

Este projeto é uma API GraphQL desenvolvida com Spring Boot 3 e Java 21 para gerenciar autores e livros. A API permite consultas e mutações flexíveis, retornando exatamente os dados solicitados, diferentemente das APIs REST tradicionais.

## Tabela de Conteúdo

- [Funcionalidades implementadas](#funcionalidades-implementadas)  
- [Tecnologias utilizadas](#tecnologias-utilizadas)  
- [Como começar](#como-começar)  
- [Endpoints da API](#endpoints-da-api)  
  - [Endpoint GraphQL](#endpoint-graphql)  
  - [Operações disponíveis](#operações-disponíveis)  
    - [Queries](#queries)  
    - [Mutations](#mutations)  
- [Dados para Teste](#dados-para-teste)  
  - [Autores e livros criados para teste](#autores-e-livros-criados-para-teste)  
- [O que eu aprendi?](#o-que-eu-aprendi)  
- [Observações](#observações) 

## Funcionalidades implementadas

- Consultar todos os autores e seus livros.
- Consultar autor por ID.
- Adicionar e excluir autores.
- Adicionar e excluir livros associados a autores.
- Validação para evitar duplicidade.
- Tratamento customizado de exceções.

## Tecnologias utilizadas

- Java 21  
- Spring Boot 3.4.7 (Web, GraphQL, Data JPA, Validation)  
- H2 Database  
- Lombok  
- Maven  

## Como começar

1. Clone o repositório:

```bash
git clone https://github.com/MarceloB-Junior/bookstore_ql_api.git
cd bookstore_ql_api
```

2. Certifique-se de ter Java 21 e Maven instalados.

3. Instale as dependências e rode a aplicação:

```bash
mvn clean install
mvn spring-boot:run
```

4. (Opcional) Acesse o console H2:

- Console do banco H2:: `http://localhost:8080/h2-console`  
    - Usuário: `sa`  
    - Senha: (em branco)  

## Endpoints da API

### Endpoint GraphQL

- **POST** `http://localhost:8080/graphql`

### Operações disponíveis

#### Queries

- **authors**  
  Consulta todos os autores e seus livros.

  ```graphql
  query {
    authors {
      id
      name
      books {
        id
        title
        publisher
      }
    }
  }
  ```

- **authorById**  
  Consulta um autor pelo ID.

  ```graphql
  query {
    authorById(id: 1) {
      id
      name
      books {
        id
        title
        publisher
      }
    }
  }
  ```

#### Mutations

- **addAuthor**  
  Adiciona um novo autor.

  ```graphql
  mutation {
    addAuthor(author: { name: "Novo Autor" }) {
      id
      name
    }
  }
  ```

- **deleteAuthor**  
  Exclui um autor pelo ID.

  ```graphql
  mutation {
    deleteAuthor(id: 1)
  }
  ```

- **addBook**  
  Adiciona um novo livro associado a um autor.

  ```graphql
  mutation {
    addBook(book: { title: "Novo Livro", publisher: "Editora X", authorId: 1 }) {
      id
      title
      publisher
    }
  }
  ```

- **deleteBook**  
  Exclui um livro pelo ID.

  ```graphql
  mutation {
    deleteBook(id: 1)
  }
  ```

## Dados para Teste

Para facilitar o desenvolvimento e testes, a API já inclui um componente chamado **DataSeeder** que popula o banco de dados H2 em memória com dados iniciais ao iniciar a aplicação. 

### Autores e livros criados para teste

- **Mark Heckler**  
  - Livro: *Spring Boot: Up and Running*  
  - Editora: *O'Reilly Media*

- **William Smith**  
  - Livro: *Mastering GraphQL: From Basics to Expert Proficiency*  
  - Editora: *HiTeX Press*

Esses dados são inseridos automaticamente apenas se o banco estiver vazio, garantindo que você tenha exemplos reais para consultar e manipular via GraphQL sem precisar criar tudo manualmente.


## O que eu aprendi?

- Como construir uma API GraphQL com Java e Spring Boot.  
- Diferenças entre APIs GraphQL e REST.  
- Validação e tratamento de exceções customizadas em GraphQL.  

## Observações

- Recomenda-se migrar para banco persistente (PostgreSQL, SQL Server) para produção.
- Alterar `spring.jpa.hibernate.ddl-auto` de `create-drop` para `update` em ambientes reais.  
- Desabilitar o console H2 em produção por segurança.