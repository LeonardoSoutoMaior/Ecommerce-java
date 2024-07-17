package com.example.ecommerce.domain.produtos;

import com.example.ecommerce.domain.categoria.Categoria;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoRequestPayload(UUID produtoId, String nome, String descricao, BigDecimal preco, String imagemUrl, int estoque, UUID categoriaId) {
}
