package com.example.ecommerce.repositories;

import com.example.ecommerce.domain.produtos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
