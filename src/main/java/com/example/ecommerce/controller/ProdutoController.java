package com.example.ecommerce.controller;

import com.example.ecommerce.domain.produtos.Produto;
import com.example.ecommerce.domain.produtos.ProdutoRequestPayload;
import com.example.ecommerce.repositories.ProdutoRepository;
import com.example.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody ProdutoRequestPayload payload){
        Produto novoProduto = this.produtoService.criarProduto(payload);
        return ResponseEntity.ok(novoProduto);
    }
}
