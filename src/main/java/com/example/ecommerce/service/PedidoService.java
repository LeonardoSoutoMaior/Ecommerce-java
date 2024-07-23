package com.example.ecommerce.service;

import com.example.ecommerce.domain.carrinho.Carrinho;
import com.example.ecommerce.domain.itemCarrinho.ItemCarrinho;
import com.example.ecommerce.domain.pedido.Pedido;
import com.example.ecommerce.repositories.CarrinhoRepository;
import com.example.ecommerce.repositories.PedidoRepository;
import com.example.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Pedido criarPedidoDoCarrinho(UUID carrinhoId){
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(carrinhoId);
        if (carrinhoOpt.isPresent()){
            Carrinho carrinho = carrinhoOpt.get();
            List<ItemCarrinho> itensCarrinho = carrinho.getItens();

            BigDecimal valorTotal = itensCarrinho.stream()
                    .map(item -> item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            Pedido pedido = new Pedido();
            pedido.setValorTotal(valorTotal);
            pedido.setDataPedido(LocalDateTime.now());
            pedido.setStatus("Em processamento");
            pedido.setUsuario(carrinho.getUsuario());

            Pedido pedidoSalvo = pedidoRepository.save(pedido);

            carrinho.getItens().clear();
            carrinhoRepository.save(carrinho);

            return pedidoSalvo;
        } else {
            throw new RuntimeException("Carrinho não encontrado");
        }
    }

    public Pedido atualizarPedido(UUID pedidoId, Pedido pedidoAtualizado) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(pedidoId);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = pedidoOpt.get();
            pedido.setValorTotal(pedidoAtualizado.getValorTotal());
            pedido.setStatus(pedidoAtualizado.getStatus());
            return pedidoRepository.save(pedido);
        } else {
            throw new RuntimeException("Pedido não encontrado");
        }
    }

    public Pedido obterPedido(UUID pedidoId){
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void deletarPedido(UUID pedidoId){
        pedidoRepository.deleteById(pedidoId);
    }
}
