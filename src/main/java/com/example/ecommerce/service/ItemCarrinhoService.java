package com.example.ecommerce.service;

import com.example.ecommerce.domain.itemCarrinho.ItemCarrinho;
import com.example.ecommerce.repositories.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    public List<ItemCarrinho> getItensDoCarrinho(UUID carrinhoId) {
        return itemCarrinhoRepository.findByCarrinhoId(carrinhoId);
    }
}
