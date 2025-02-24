package com.example.ecommerce.repositories;

import com.example.ecommerce.domain.itemCarrinho.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, UUID> {
    List<ItemCarrinho> findByCarrinhoId(UUID carrinhoId);
    ItemCarrinho findByCarrinhoIdAndProdutoId(UUID carrinhoId, UUID produtoId);

}
