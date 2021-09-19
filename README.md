<h1 align="center">Biblioteca Waitaka</h1>

<p align="center"> O projeto é um sistema de controle de 
empréstimo de livros de uma biblioteca de uma universidade ficticia da 
região de Campos dos Goytacazes - RJ</p>

<p align="center">
     <a href="#objetivo">Objetivo</a> •
     <a href="#roadmap">Roadmap</a> • 
     <a href="#tecnologias">Tecnologias</a> • 
     <a href="#contribuicao">Contribuição</a> • 
     <a href="#autor">Autor</a>
</p>

<h4 align="center"> 
	🚧  Biblioteca Waitaka 🚀 Escopo inicial finalizado, mas aberto para melhorias.
</h4>

### Features

- [x] Cadastro de Estudantes
- [x] Cadastro de Funcionarios
- [x] Cadastro de Professores
- [x] Cadastro de Livros
- [x] Cadastro do Aluguel dos livros


### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Docker](https://www.docker.com/).
Além disto a recomendação é o editor [Intellij](https://www.jetbrains.com/pt-br/idea/).
<br>
O Docker não precisará ser executado pelo terminal, nos arquivos existe o arquivo Docker-compose
com as configurações necessárias, porém uma vez executado, pode ser apenas inicializado os Containers
com os comandos:

Incializar o servidor [Mongodb](https://www.mongodb.com/pt-br): 
``` 
docker container start mongodb
``` 
Incializar o Web-admin do Mongodb, o [Mongo-express](https://github.com/mongo-express/mongo-express)
``` 
docker container start mongo-express
```


### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/iagoAguiar/libraryWaitaka>

# Acesse a pasta do projeto no terminal/cmd
$ cd libraryWaitaka

# Execute a aplicação em modo de desenvolvimento
$ mvn spring-boot:run

#Ou execute direto pelo Intellij.
selecione a classe principal e  use o atalho: CTRL + Shift + F10. 

# O servidor inciará na porta:8080 - acesse <http://localhost:8080>
# O Web-admin iniciará na porta:8081 - acesse <http://localhost:8081>
```

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:


:innocent:

- [Java](https://www.java.com/pt-BR/)
- [Spring](https://spring.io/)
- [Swagger](https://swagger.io/)
- [Lombok](https://projectlombok.org/)
- [MongoDB](https://www.mongodb.com/pt-br/)
- [Mapstruct](https://mapstruct.org/)
- [Docker](https://www.docker.com/)
- [Bean Validation](https://beanvalidation.org/)


### Autor ###
---

<a href="https://blog.rocketseat.com.br/author/thiago/">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/38701614?v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Iago Duarte de Aguiar</b></sub></a> <a href="https://blog.rocketseat.com.br/author/thiago//" title="Rocketseat">🚀</a>


Feito com ❤️ por Iago Aguiar👋🏽 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Iago-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/iagoduarte/)](https://www.linkedin.com/in/iagoduarte/)
[![Gmail Badge](https://img.shields.io/badge/-iagoaguiar202@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:iagoaguiar202@gmail.com)](mailto:iagoaguiar202@gmail.com)




