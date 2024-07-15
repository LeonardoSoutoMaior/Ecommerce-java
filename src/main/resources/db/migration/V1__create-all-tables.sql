CREATE TABLE categoria (
    categoria_id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(500)
);

CREATE TABLE produtos (
    produto_id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(500),
    preco DECIMAL(19, 2) NOT NULL,
    imagem_url VARCHAR(300),
    estoque INT NOT NULL,
    categoria_id UUID,
    FOREIGN KEY (categoria_id) REFERENCES categoria(categoria_id)
);

CREATE TABLE usuario (
    usuario_id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    sobrenome VARCHAR(500) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE carrinho (
    carrinho_id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    usuario_id UUID,
    FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);

CREATE TABLE itens_carrinho (
    item_carrinho_id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    quantidade INT NOT NULL,
    produto_id UUID,
    carrinho_id UUID,
    FOREIGN KEY (produto_id) REFERENCES produtos(produto_id),
    FOREIGN KEY (carrinho_id) REFERENCES carrinho(carrinho_id)
);

CREATE TABLE endereco (
    endereco_id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    rua VARCHAR(300) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    cep VARCHAR(10),
    usuario_id UUID,
    FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);

CREATE TABLE pedido (
    pedido_id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    valor_total DECIMAL(19, 2) NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(255),
    usuario_id UUID,
    FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);

CREATE TABLE itens_do_pedido (
    itens_do_pedido_id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    quantidade INT NOT NULL,
    preco DECIMAL(19, 2) NOT NULL,
    pedido_id UUID,
    produto_id UUID,
    FOREIGN KEY (pedido_id) REFERENCES pedido(pedido_id),
    FOREIGN KEY (produto_id) REFERENCES produtos(produto_id)
);

CREATE TABLE pagamento (
    pagamento_id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    total DECIMAL(19, 2) NOT NULL,
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    metodo_pagamento VARCHAR(50) NOT NULL,
    pedido_id UUID,
    FOREIGN KEY (pedido_id) REFERENCES pedido(pedido_id)
);
