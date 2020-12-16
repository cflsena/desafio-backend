
# Desafio Back-end

## Sobre o desafio

**Criar uma API tema livre:**

**Tabelas**
- **Professional**

| Nome Coluna | Tipos |
|--|--|
| id | Numérico |
| name | Texto |
| email | Texto |
| cell_phone | Texto |

- **Job**

| Nome Coluna | Tipos |
|--|--|
| id | Numérico |
| professional_id | Numérico |
| category_id | Numérico |
| description | Texto |
| weekendService | Texto | 
| active | Texto |
| references | Texto |

- **Category**

| Nome Coluna | Tipos |
|--|--|
| id | Numérico |
| description | Texto |
# Sobre a Configuração do Projeto

## Biblioteca auxiliar
- Lombok
	- **P.S.01**: link para download [Lombok Download](https://projectlombok.org/download)
	- **P.S.02**: link de instalação Eclipse [Lombok instalação](https://projectlombok.org/setup/eclipse)
	- **P.S.03**: link de instalação Intellij [Lombok instalação](https://projectlombok.org/setup/intellij)

## Stack

- Java 8
- Spring Boot
	- Starters
		- web
		- jpa
		- validation
- Lombok
- OpenApi 3.0
-   H2 (banco de dados em memória)
-   Maven
	- [https://maven.apache.org](https://maven.apache.org/)

## APIs REST
- Base url: hhtp://localhost:8080/desafio-backend/api/v1
- Documentação disponível em (ao startar o projeto): [http://localhost:8080/desafio-backend/api/v1/documentation.html](http://localhost:8080/desafio-backend/api/v1/documentation.html)

## Outras informações
**Banco de Dados**
- Arquivo sql executado contendo inserções iniciais ao startar o projeto: 
	- **data.sql**
	- Acessando o console do banco de dados H2:
		- url: [http://localhost:8080/desafio-backend/api/v1/h2](http://localhost:8080/desafio-backend/api/v1/h2)
		- Driver Class: org.h2.Driver
		- JDBC Url: jdbc:h2:mem:testdb
		- User Name: springboottest
		- Sem Password
		
**Postman**
- Arquivo para testar as APIs (na raiz do projeto):
	- **Desafio-Backend.postman_collection.json**

## Sobre o Desenvolvimento

- Implementado path que realiza a criação de um profissional;
- Implementado path que realiza a consulta de serviços por id;
- Implementado path que realiza a criação de um serviço;
- Implementado path que a atualiza somente o status de um serviço;
- Implementado path que exclui um serviço;
- Implementado path que a atualiza demais propriedades de um serviço;
- Implementado path que realiza consulta paginada de serviços, por alguns filtros.
- Elaborada documentação utilizando OpenAPI 3.0

