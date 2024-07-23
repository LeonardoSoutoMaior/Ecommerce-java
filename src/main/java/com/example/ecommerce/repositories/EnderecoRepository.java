package com.example.ecommerce.repositories;

import com.example.ecommerce.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
    Endereco findByUsuarioId(UUID usuarioId);
}
