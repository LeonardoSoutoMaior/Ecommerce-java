package com.example.ecommerce.service;

import com.example.ecommerce.domain.carrinho.Carrinho;
import com.example.ecommerce.repositories.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho getCarrinhoDoUsuario(UUID usuarioId) {
        return carrinhoRepository.findByUsuarioId(usuarioId);
    }
}
