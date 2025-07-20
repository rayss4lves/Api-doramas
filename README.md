# API de Doramas

Uma API REST desenvolvida com Spring Boot que permite o gerenciamento de doramas — incluindo séries e filmes asiáticos. A aplicação oferece cadastro, edição, exclusão e filtros por gênero, emissora e país de origem.

Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven

 Endpoints Disponíveis

  - Séries

- `GET /serie` — Lista todas as séries
- `POST /serie` — Cadastra uma nova série
- `PUT /serie/{id}` — Edita uma série
- `DELETE /serie/{id}` — Exclui uma série

  - Filmes

- `GET /filme` — Lista todos os filmes
- `POST /filme` — Cadastra um novo filme
- `PUT /filme/{id}` — Edita um filme
- `DELETE /filme/{id}` — Exclui um filme

  - Filtros

- `GET /doramas/genero?genero=xxx` — Filtra doramas por gênero
- `GET /doramas/emissora?nomeEmi=xxx` — Filtra por emissora
- `GET /doramas/pais?nomePais=xxx` — Filtra por país de origem

 Como Testar

Use o [Postman](https://www.postman.com/) ou navegador para testar os endpoints.

Exemplo:
```http
GET http://localhost:8080/serie
GET http://localhost:8080/doramas/genero?genero=acao
