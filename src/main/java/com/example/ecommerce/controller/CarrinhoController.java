package com.example.ecommerce.controller;

import com.example.ecommerce.domain.carrinho.Carrinho;
import com.example.ecommerce.domain.itemCarrinho.ItemCarrinho;
import com.example.ecommerce.service.CarrinhoService;
import com.example.ecommerce.service.ItemCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private ItemCarrinhoService itemCarrinhoService;

    @GetMapping("/{usuarioId}")
    public Carrinho getCarrinhoDoUsuario(@PathVariable UUID usuarioId) {
        return carrinhoService.getCarrinhoDoUsuario(usuarioId);
    }

    @GetMapping("/{carrinhoId}/itens")
    public List<ItemCarrinho> getItensDoCarrinho(@PathVariable UUID carrinhoId) {
        return itemCarrinhoService.getItensDoCarrinho(carrinhoId);
    }
}
