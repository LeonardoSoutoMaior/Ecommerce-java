package com.example.ecommerce.controller;

import com.example.ecommerce.domain.carrinho.Carrinho;
import com.example.ecommerce.domain.itemCarrinho.ItemCarrinho;
import com.example.ecommerce.service.CarrinhoService;
import com.example.ecommerce.service.ItemCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @PostMapping("/{carrinhoId}/adicionar-produto")
    public ResponseEntity<String> adicionarProdutoAoCarrinho(
            @PathVariable UUID carrinhoId,
            @RequestParam UUID produtoId,
            @RequestParam int quantidade) {

        itemCarrinhoService.adicionarProdutoAoCarrinho(carrinhoId, produtoId, quantidade);
        return ResponseEntity.ok("Produto adicionado ao carrinho com sucesso.");
    }


    @GetMapping("/{carrinhoId}/total")
    public ResponseEntity<BigDecimal> obterTotalCarrinho(@PathVariable UUID carrinhoId) {
        try {
            BigDecimal total = itemCarrinhoService.calcularTotalCarrinho(carrinhoId);
            return ResponseEntity.ok(total);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
