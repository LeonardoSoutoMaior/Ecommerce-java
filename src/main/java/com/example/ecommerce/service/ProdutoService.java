package com.example.ecommerce.service;

import com.example.ecommerce.domain.categoria.Categoria;
import com.example.ecommerce.domain.produtos.Produto;
import com.example.ecommerce.domain.produtos.ProdutoRequestPayload;
import com.example.ecommerce.repositories.CategoriaRepository;
import com.example.ecommerce.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Produto criarProduto(ProdutoRequestPayload payload){
        Categoria categoria = categoriaRepository.findById(payload.categoriaId()).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Produto novoProduto = new Produto();
        novoProduto.setNome(payload.nome());
        novoProduto.setDescricao(payload.descricao());
        novoProduto.setPreco(payload.preco());
        novoProduto.setImagemUrl(payload.imagemUrl());
        novoProduto.setEstoque(payload.estoque());
        novoProduto.setCategoria(categoria);

        return repository.save(novoProduto);
    }
}
