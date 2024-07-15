package com.example.ecommerce.repositories;

import com.example.ecommerce.domain.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}
