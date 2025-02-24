# API-REST-Profissionais-Contatos
 API REST em Java para controle de cadastro de profissionais e seus números de contato
 
## Índice
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação](#instalação)
- [Uso](#uso)

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Swagger(Documentação)
- Lombok
- JPA/Hibernate
- Springframework
- PostgreSQL(Banco de dados)

## Instalação

# clonar repositório
git clone https://github.com/eltonips/API-REST-Profissionais-Contatos 

configurar Banco de dados no arquivo application.properties que está no caminho API-REST-Profissionais-Contatos\src\main\resources
os scripts são rodados automaticamente pelo migration em tempo de execução da aplicação

A documentação da API está presente no Swagger através do link #localhost:PORTA_DO_BANCO/swagger-ui.html

![Swagger-ApiRest](https://github.com/user-attachments/assets/685eee16-2797-46f3-bbd5-418db4135dfb)


# entrar na pasta do projeto back end

cd API-REST-Profissionais-Contatos

# executar o projeto

./mvnw spring-boot:run

## Uso
Através do Postman é possível realizar as chamadas a API e fazer as ações desejadas de Get, Post, Put e Delete.
