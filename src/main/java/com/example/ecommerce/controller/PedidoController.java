package com.example.ecommerce.controller;

import com.example.ecommerce.domain.pedido.Pedido;
import com.example.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/criar-pedido/{carrinhoId}")
    public ResponseEntity<Pedido> criarPedidoDoCarrinho(@PathVariable UUID carrinhoId){
        Pedido pedido = pedidoService.criarPedidoDoCarrinho(carrinhoId);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<Pedido> obterPedidoPorId(@PathVariable UUID pedidoId){
        Pedido pedido = pedidoService.obterPedido(pedidoId);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/atualizar-pedido/{pedidoId}")
    public ResponseEntity<Pedido> atualizarPedido(
            @PathVariable UUID pedidoId,
            @RequestBody Pedido pedidoAtualizado) {
        Pedido pedido = pedidoService.atualizarPedido(pedidoId, pedidoAtualizado);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/deletar-pedido/{pedidoId}")
    public ResponseEntity<String> deletarPedido(@PathVariable UUID pedidoId) {
        pedidoService.deletarPedido(pedidoId);
        return ResponseEntity.ok("Pedido deletado com sucesso.");
    }
}
