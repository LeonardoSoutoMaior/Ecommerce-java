# E-Commerce Backend

## Descrição

O **E-Commerce Backend** é uma aplicação desenvolvida para gerenciar as funcionalidades de um sistema de comércio eletrônico. O backend é responsável por processar e armazenar dados relacionados a produtos, categorias, carrinhos de compras, itens de carrinho, endereços, usuários e pedidos. 
A aplicação foi desenvolvida utilizando Spring Boot e H2 Database e está protegida com Spring Security e JWT para garantir uma comunicação segura.

## Funcionalidades

### Produtos
- Cadastro de produtos com informações como nome, descrição, preço, imagem, estoque e categoria.
- Possibilidade de visualizar e gerenciar produtos existentes.

### Categorias
- Cadastro de categorias de produtos com informações como nome e descrição.
- Associação de produtos a categorias específicas.

### Carrinho
- Criação e gerenciamento de carrinhos de compra.
- Adição e remoção de produtos do carrinho.
- Atualização da quantidade de produtos no carrinho.
- Cálculo do valor total do carrinho.

### Itens do Carrinho
- Armazenamento dos produtos e suas quantidades dentro do carrinho.
- Atualização da quantidade de produtos e ajuste do preço total no carrinho.

### Endereços
- Cadastro e gerenciamento de endereços de entrega para os usuários.
- Associação de endereços a usuários específicos.

### Usuários
- Cadastro e gerenciamento de usuários com informações pessoais e de login.
- Associação de usuários aos carrinhos de compra e endereços.

### Pedidos
- Criação e gerenciamento de pedidos com base nas informações do carrinho.
- Registro do valor total, data do pedido e status.
- Associação de pedidos a usuários específicos.

## Tecnologias Utilizadas
- **Spring Web**: Para criar e gerenciar os endpoints RESTful da aplicação.
- **Spring Security**: Para proteger a aplicação com autenticação e autorização.
- **JWT (JSON Web Token)**: Para comunicação segura e stateless entre o frontend e o backend.
- **Lombok**: Para simplificar a criação de getters, setters e construtores.
- **JPA (Java Persistence API)**: Para gerenciar a persistência de dados.
- **H2 Database**: Para o banco de dados em memória usado para desenvolvimento e testes.

