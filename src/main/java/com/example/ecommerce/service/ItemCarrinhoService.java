package com.example.ecommerce.service;

import com.example.ecommerce.domain.carrinho.Carrinho;
import com.example.ecommerce.domain.itemCarrinho.ItemCarrinho;
import com.example.ecommerce.domain.produtos.Produto;
import com.example.ecommerce.repositories.CarrinhoRepository;
import com.example.ecommerce.repositories.ItemCarrinhoRepository;
import com.example.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ItemCarrinho> getItensDoCarrinho(UUID carrinhoId) {
        return itemCarrinhoRepository.findByCarrinhoId(carrinhoId);
    }

    public void adicionarProdutoAoCarrinho(UUID carrinhoId, UUID produtoId, int quantidade) {
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(carrinhoId);
        Optional<Produto> produtoOpt = produtoRepository.findById(produtoId);

        if (carrinhoOpt.isPresent() && produtoOpt.isPresent()) {
            Carrinho carrinho = carrinhoOpt.get();
            Produto produto = produtoOpt.get();

            ItemCarrinho itemCarrinhoExistente = itemCarrinhoRepository.findByCarrinhoIdAndProdutoId(carrinhoId, produtoId);
            if (itemCarrinhoExistente != null) {
                // Atualizar a quantidade do item existente
                itemCarrinhoExistente.setQuantidade(itemCarrinhoExistente.getQuantidade() + quantidade);
            } else {
                // Criar um novo item de carrinho
                ItemCarrinho itemCarrinho = new ItemCarrinho(produto, carrinho, quantidade);
                itemCarrinhoExistente = itemCarrinho;
            }
            // Salvar o item de carrinho (novo ou atualizado)
            itemCarrinhoRepository.save(itemCarrinhoExistente);
        } else {
            throw new RuntimeException("Carrinho ou produto não encontrado");
        }
    }

    public BigDecimal calcularTotalCarrinho(UUID carrinhoId){
        List<ItemCarrinho> itens = itemCarrinhoRepository.findByCarrinhoId(carrinhoId);
        return itens.stream()
                .map(item -> item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<ItemCarrinho> listarItensDoCarrinho(UUID carrinhoId){
        return itemCarrinhoRepository.findByCarrinhoId(carrinhoId);
    }
}
