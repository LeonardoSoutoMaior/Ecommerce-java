package com.example.ecommerce.domain.categoria;

import java.util.UUID;

public record CategoriaRequestPayload(UUID id, String nome, String descricao) {
}
