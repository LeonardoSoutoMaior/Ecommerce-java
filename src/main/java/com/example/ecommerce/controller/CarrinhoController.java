package com.example.ecommerce.controller;

import com.example.ecommerce.domain.carrinho.Carrinho;
import com.example.ecommerce.domain.itemCarrinho.ItemCarrinho;
import com.example.ecommerce.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping("/usuario/{usuarioId}")
    public Carrinho getCarrinhoDoUsuario(@PathVariable UUID usuarioID){
        return carrinhoService.getCarrinhoDoUsuario(usuarioID);
    }

    @GetMapping("/{carrinhoId}/itens")
    public List<ItemCarrinho> getItensDoCarrinho(@PathVariable UUID carrinhoId){
        return carrinhoService.getItensDoCarrinho(carrinhoId);
    }
}
