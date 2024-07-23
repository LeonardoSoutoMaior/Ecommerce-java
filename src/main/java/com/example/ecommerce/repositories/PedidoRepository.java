package com.example.ecommerce.repositories;

import com.example.ecommerce.domain.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
