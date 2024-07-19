package com.example.ecommerce.service;

import com.example.ecommerce.domain.carrinho.Carrinho;
import com.example.ecommerce.domain.itemCarrinho.ItemCarrinho;
import com.example.ecommerce.domain.usuarios.Usuario;
import com.example.ecommerce.repositories.CarrinhoRepository;
import com.example.ecommerce.repositories.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    public Carrinho getCarrinhoDoUsuario(UUID usuarioId){
        return repository.findByUsuarioId(usuarioId);
    }

    public List<ItemCarrinho> getItensDoCarrinho(UUID carrinhoId){
        return itemCarrinhoRepository.findByCarrinhoId(carrinhoId);
    }
}
