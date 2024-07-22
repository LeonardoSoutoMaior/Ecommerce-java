package com.example.ecommerce.repositories;

import com.example.ecommerce.domain.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {
    Carrinho findByUsuarioId(UUID usuarioId);
}
